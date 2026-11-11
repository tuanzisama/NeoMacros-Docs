package ink.tuanzi.neomacros.docs;

import com.sun.source.doctree.DocCommentTree;
import com.sun.source.util.DocTrees;
import ink.tuanzi.neomacros.doc.api.ApiClass;
import ink.tuanzi.neomacros.doc.api.ApiEvent;
import ink.tuanzi.neomacros.doc.api.ApiModule;
import jdk.javadoc.doclet.DocletEnvironment;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Builds the {@link ApiModel} from a doclet environment: picks annotated
 * module classes, script-facing class types, event records, and referenced
 * record types; collects generation warnings (missing @zh translations,
 * missing @ApiSince) in deterministic (sorted) order.
 */
final class ModelExtractor {

    private ModelExtractor() {
    }

    static ApiModel extract(DocletEnvironment env) {
        DocTrees trees = env.getDocTrees();
        List<ApiModel.ModuleModel> modules = new ArrayList<>();
        List<ApiModel.EventModel> events = new ArrayList<>();
        List<ApiModel.ClassModel> standaloneClasses = new ArrayList<>();
        Map<String, ApiModel.TypeModel> eventReferenced = new TreeMap<>();
        Map<String, ApiModel.TypeModel> standaloneReferenced = new TreeMap<>();
        List<String> warnings = new ArrayList<>();

        Set<TypeElement> types = typesIn(env);
        for (TypeElement type : types) {
            ApiModule module = DocletSupport.moduleOf(type);
            if (module != null) {
                modules.add(moduleModel(type, module, trees, warnings));
                continue;
            }
            ApiEvent event = DocletSupport.eventOf(type);
            if (event != null && type.getKind() == ElementKind.RECORD) {
                events.add(eventModel(type, event, trees, eventReferenced, warnings));
                continue;
            }
            // Standalone @ApiClass: not nested in any facade module.
            ApiClass apiClass = DocletSupport.classOf(type);
            if (apiClass != null) {
                // Skip if nested inside a facade — moduleModel already handles those.
                var enclosing = type.getEnclosingElement();
                boolean nestedInFacade = enclosing != null
                        && enclosing.getAnnotation(ink.tuanzi.neomacros.doc.api.ApiModule.class) != null;
                if (!nestedInFacade) {
                    standaloneClasses.add(standaloneClassModel(type, apiClass, trees,
                            standaloneReferenced, standaloneClasses, warnings,
                            DocletSupport.sinceOf(type)));
                }
            }
        }

        modules.sort(Comparator.comparing(ApiModel.ModuleModel::name));
        events.sort(Comparator.comparing(ApiModel.EventModel::name));
        standaloneClasses.sort(java.util.Comparator.comparing(ApiModel.ClassModel::name));
        List<ApiModel.TypeModel> eventReferencedList = new ArrayList<>(eventReferenced.values());
        eventReferencedList.sort(java.util.Comparator.comparing(ApiModel.TypeModel::name));
        List<ApiModel.TypeModel> standaloneReferencedList = new ArrayList<>(standaloneReferenced.values());
        standaloneReferencedList.sort(java.util.Comparator.comparing(ApiModel.TypeModel::name));
        warnings.sort(String::compareTo);
        return new ApiModel(List.copyOf(modules), List.copyOf(events),
                List.copyOf(standaloneClasses), List.copyOf(eventReferencedList),
                List.copyOf(standaloneReferencedList), List.copyOf(warnings));
    }

    /** Extracts a standalone (non-facade-nested) @ApiClass into a full
     * ClassModel; nested @ApiClass members join the standalone class list and
     * referenced records feed the standalone referenced-type set. */
    private static ApiModel.ClassModel standaloneClassModel(TypeElement type,
            ApiClass apiClass, DocTrees trees,
            Map<String, ApiModel.TypeModel> referenced,
            List<ApiModel.ClassModel> nestedOut, List<String> warnings,
            String fallbackSince) {
        var comment = trees.getDocCommentTree(type);
        var zhBody = DocletSupport.zhBody(comment);
        if (zhBody.isEmpty()) {
            warnings.add(apiClass.name() + ": standalone class has no @zh docs");
        }
        for (var member : type.getEnclosedElements()) {
            if (member instanceof TypeElement nestedType
                    && DocletSupport.classOf(nestedType) != null) {
                nestedOut.add(classModel(nestedType, DocletSupport.classOf(nestedType),
                        trees, referenced, warnings, apiClass.name(), null));
            }
        }
        return classModel(type, apiClass, trees, referenced, warnings, null, fallbackSince);
    }

    /** Collects the class and record types included in this documentation run, deduplicated. */
    private static Set<TypeElement> typesIn(DocletEnvironment env) {
        Map<TypeElement, Boolean> seen = new LinkedHashMap<>();
        // Only explicitly specified types enter the model: expanding package
        // elements would drag every sibling source into resolution (the
        // event package alone transitively requires snakeyaml and the whole
        // module tree), breaking the standalone source list.
        for (Element element : env.getIncludedElements()) {
            switch (element.getKind()) {
                case CLASS, RECORD, INTERFACE, ENUM -> seen.put((TypeElement) element, true);
                default -> {
                }
            }
        }
        return seen.keySet();
    }

    private static ApiModel.ModuleModel moduleModel(TypeElement type, ApiModule module,
                                                    DocTrees trees,
                                                    List<String> warnings) {
        Map<String, ApiModel.TypeModel> referenced = new TreeMap<>();
        var comment = trees.getDocCommentTree(type);
        var zhBody = DocletSupport.zhBody(comment);
        String moduleSince = DocletSupport.sinceOf(type);
        if (zhBody.isEmpty()) {
            warnings.add(module.name() + ": module doc has no @zh body");
        }
        if (moduleSince == null) {
            warnings.add(module.name() + ": module is missing @ApiSince");
        }

        List<ApiModel.PropertyModel> properties = new ArrayList<>();
        List<ApiModel.MethodModel> methods = new ArrayList<>();
        List<ApiModel.ClassModel> classes = new ArrayList<>();

        for (Element member : type.getEnclosedElements()) {
            if (member.getKind() == ElementKind.CLASS || member.getKind() == ElementKind.RECORD) {
                TypeElement nested = (TypeElement) member;
                var apiClass = DocletSupport.classOf(nested);
                if (apiClass != null) {
                    classes.add(classModel(nested, apiClass, trees, referenced, warnings,
                            module.name(), null));
                }
                continue;
            }
            if (member.getKind() != ElementKind.METHOD
                    || !member.getModifiers().contains(Modifier.PUBLIC)
                    || DocletSupport.internalOf(member)) {
                continue;
            }
            ExecutableElement method = (ExecutableElement) member;
            var memberComment = trees.getDocCommentTree(method);
            String since = memberSince(method, moduleSince, module.name(), warnings);
            String zhLabel = DocletSupport.propertyName(method);
            if (DocletSupport.isBeanGetter(method)) {
                if (DocletSupport.zhBody(memberComment).isEmpty()) {
                    warnings.add(module.name() + "." + zhLabel + ": property has no @zh docs");
                }
                properties.add(new ApiModel.PropertyModel(
                        zhLabel,
                        DocletSupport.returnTypeOf(method),
                        DocletSupport.docBody(memberComment),
                        DocletSupport.zhBody(memberComment).orElse(""),
                        DocletSupport.readOnlyOf(method),
                        since,
                        DocletSupport.mcOf(method),
                        DocletSupport.loaderOf(method),
                        DocletSupport.permissionOf(method),
                        DocletSupport.experimentalOf(method)));
                collectReferenced(method.getReturnType(), referenced);
            } else {
                if (DocletSupport.zhBody(memberComment).isEmpty()) {
                    warnings.add(module.name() + "." + method.getSimpleName() + ": method has no @zh docs");
                }
                methods.add(new ApiModel.MethodModel(
                        method.getSimpleName().toString(),
                        DocletSupport.parametersOf(method),
                        DocletSupport.returnTypeOf(method),
                        DocletSupport.docBody(memberComment),
                        DocletSupport.paramDocs(memberComment),
                        DocletSupport.returnDoc(memberComment).orElse(""),
                        DocletSupport.zhBody(memberComment).orElse(""),
                        DocletSupport.zhParamDocs(memberComment),
                        DocletSupport.zhReturnDoc(memberComment).orElse(""),
                        DocletSupport.zhExample(memberComment).orElse(""),
                        since,
                        DocletSupport.mcOf(method),
                        DocletSupport.loaderOf(method),
                        DocletSupport.permissionOf(method),
                        DocletSupport.experimentalOf(method),
                        DocletSupport.paramDefaults(memberComment)));
                collectReferenced(method.getReturnType(), referenced);
                method.getParameters().forEach(p -> collectReferenced(p.asType(), referenced));
            }
        }

        properties.sort(java.util.Comparator.comparing(ApiModel.PropertyModel::name));
        methods.sort(java.util.Comparator.comparing(ApiModel.MethodModel::name));
        classes.sort(java.util.Comparator.comparing(ApiModel.ClassModel::name));
        List<ApiModel.TypeModel> referencedList = new ArrayList<>(referenced.values());
        referencedList.sort(java.util.Comparator.comparing(ApiModel.TypeModel::name));
        return new ApiModel.ModuleModel(
                module.name(), module.category(),
                DocletSupport.docBody(comment),
                zhBody.orElse(""),
                moduleSince, DocletSupport.mcOf(type),
                        DocletSupport.loaderOf(type),
                List.copyOf(properties), List.copyOf(methods), List.copyOf(classes),
                List.copyOf(referencedList));
    }

    private static ApiModel.ClassModel classModel(TypeElement type,
                                                  ApiClass apiClass,
                                                  DocTrees trees,
                                                  Map<String, ApiModel.TypeModel> referenced,
                                                  List<String> warnings, String moduleName,
                                                  String fallbackSince) {
        var comment = trees.getDocCommentTree(type);
        var zhBody = DocletSupport.zhBody(comment);
        if (zhBody.isEmpty()) {
            warnings.add(moduleName + "." + apiClass.name() + ": class has no @zh docs");
        }
        if (type.getKind() == ElementKind.RECORD) {
            return recordClassModel(type, apiClass, trees, comment, zhBody.orElse(""),
                    referenced, moduleName, fallbackSince);
        }
        boolean constructible = isSelfConstructing(type);
        List<ApiModel.ParameterModel> constructorParams = List.of();
        if (constructible) {
            ExecutableElement ctor = guestConstructorOf(type);
            if (ctor == null) {
                warnings.add((moduleName == null ? apiClass.name()
                        : moduleName + "." + apiClass.name())
                        + ": SelfConstructing class has no @ApiSince constructor to document");
            } else {
                constructorParams = DocletSupport.parametersOf(ctor);
                ctor.getParameters().forEach(p -> collectReferenced(p.asType(), referenced));
            }
        }
        List<ApiModel.PropertyModel> properties = new ArrayList<>();
        List<ApiModel.MethodModel> methods = new ArrayList<>();
        for (Element member : type.getEnclosedElements()) {
            if (member.getKind() != ElementKind.METHOD
                    || !member.getModifiers().contains(Modifier.PUBLIC)
                    || DocletSupport.internalOf(member)) {
                continue;
            }
            ExecutableElement method = (ExecutableElement) member;
            if (isObjectProtocol(method)) {
                continue;
            }
            var memberComment = trees.getDocCommentTree(method);
            String since = DocletSupport.sinceOf(method) != null
                    ? DocletSupport.sinceOf(method) : fallbackSince;
            if (DocletSupport.isBeanGetter(method)) {
                String prop = DocletSupport.propertyName(method);
                if (moduleName != null && DocletSupport.zhBody(memberComment).isEmpty()) {
                    warnings.add(moduleName + "." + apiClass.name() + "." + prop
                            + ": property has no @zh docs");
                }
                properties.add(new ApiModel.PropertyModel(
                        prop,
                        DocletSupport.returnTypeOf(method),
                        DocletSupport.docBody(memberComment),
                        DocletSupport.zhBody(memberComment).orElse(""),
                        DocletSupport.readOnlyOf(method),
                        since,
                        DocletSupport.mcOf(method),
                        DocletSupport.loaderOf(method),
                        DocletSupport.permissionOf(method),
                        DocletSupport.experimentalOf(method)));
                collectReferenced(method.getReturnType(), referenced);
            } else {
                if (moduleName != null && DocletSupport.zhBody(memberComment).isEmpty()) {
                    warnings.add(moduleName + "." + apiClass.name() + "." + method.getSimpleName()
                            + ": method has no @zh docs");
                }
                methods.add(new ApiModel.MethodModel(
                        method.getSimpleName().toString(),
                        DocletSupport.parametersOf(method),
                        DocletSupport.returnTypeOf(method),
                        DocletSupport.docBody(memberComment),
                        DocletSupport.paramDocs(memberComment),
                        DocletSupport.returnDoc(memberComment).orElse(""),
                        DocletSupport.zhBody(memberComment).orElse(""),
                        DocletSupport.zhParamDocs(memberComment),
                        DocletSupport.zhReturnDoc(memberComment).orElse(""),
                        DocletSupport.zhExample(memberComment).orElse(""),
                        since,
                        DocletSupport.mcOf(method),
                        DocletSupport.loaderOf(method),
                        DocletSupport.permissionOf(method),
                        DocletSupport.experimentalOf(method),
                        DocletSupport.paramDefaults(memberComment)));
                collectReferenced(method.getReturnType(), referenced);
                method.getParameters().forEach(p -> collectReferenced(p.asType(), referenced));
            }
        }
        properties.sort(java.util.Comparator.comparing(ApiModel.PropertyModel::name));
        methods.sort(java.util.Comparator.comparing(ApiModel.MethodModel::name));
        return new ApiModel.ClassModel(apiClass.name(), apiClass.kind(), apiClass.wraps(),
                extendsNameOf(type), DocletSupport.docBody(comment),
                zhBody.orElse(""), constructible, constructorParams,
                DocletSupport.zhExample(comment).orElse(""),
                List.copyOf(properties), List.copyOf(methods));
    }

    /**
     * Whether the class implements the engine's {@code SelfConstructing}
     * marker anywhere on its superclass chain. Matched by simple name so the
     * standalone fixture tree (which cannot depend on core-api) can exercise
     * the same path.
     */
    private static boolean isSelfConstructing(TypeElement type) {
        TypeElement current = type;
        while (current != null) {
            for (TypeMirror implemented : current.getInterfaces()) {
                if (typeName(implemented).equals("SelfConstructing")) {
                    return true;
                }
            }
            TypeMirror sup = current.getSuperclass();
            current = sup.getKind() == TypeKind.DECLARED
                    ? (TypeElement) ((DeclaredType) sup).asElement() : null;
        }
        return false;
    }

    /** The simple name of a declared type, or empty for primitives and arrays. */
    private static String typeName(TypeMirror type) {
        return type.getKind() == TypeKind.DECLARED
                ? ((TypeElement) ((DeclaredType) type).asElement()).getSimpleName().toString() : "";
    }

    /** The script-facing constructor: public and version-annotated. The
     * no-arg engine-factory constructor carries no {@code @ApiSince} and is
     * skipped. */
    private static ExecutableElement guestConstructorOf(TypeElement type) {
        for (Element member : type.getEnclosedElements()) {
            if (member.getKind() != ElementKind.CONSTRUCTOR
                    || !member.getModifiers().contains(Modifier.PUBLIC)
                    || DocletSupport.sinceOf(member) == null) {
                continue;
            }
            return (ExecutableElement) member;
        }
        return null;
    }

    /** Renders an {@code @ApiClass} record as a field interface: record
     * components become read-only properties (honoring {@code @ApiType}
     * overrides and {@code @ApiOptional}), described by the record's
     * {@code @param}/{@code @zh-param} tags. */
    private static ApiModel.ClassModel recordClassModel(TypeElement type,
                                                        ApiClass apiClass,
                                                        DocTrees trees,
                                                        DocCommentTree comment,
                                                        String zhDoc,
                                                        Map<String, ApiModel.TypeModel> referenced,
                                                        String moduleName,
                                                        String fallbackSince) {
        Map<String, String> paramDocs = DocletSupport.paramDocs(comment);
        Map<String, String> zhParamDocs = DocletSupport.zhParamDocs(comment);
        List<ApiModel.PropertyModel> properties = new ArrayList<>();
        for (Element component : type.getEnclosedElements()) {
            if (component.getKind() != ElementKind.RECORD_COMPONENT) {
                continue;
            }
            VariableElement variable = (VariableElement) component;
            String name = variable.getSimpleName().toString();
            properties.add(new ApiModel.PropertyModel(
                    name,
                    DocletSupport.recordComponentType(type, variable),
                    paramDocs.getOrDefault(name, ""),
                    zhParamDocs.getOrDefault(name, ""),
                    true,
                    DocletSupport.sinceOf(type) != null
                            ? DocletSupport.sinceOf(type) : fallbackSince,
                    DocletSupport.mcOf(type),
                    DocletSupport.loaderOf(type),
                    null,
                    false));
            collectReferenced(variable.asType(), referenced);
        }
        properties.sort(java.util.Comparator.comparing(ApiModel.PropertyModel::name));
        return new ApiModel.ClassModel(apiClass.name(), apiClass.kind(), apiClass.wraps(),
                "", DocletSupport.docBody(comment), zhDoc,
                false, List.of(), "", List.copyOf(properties), List.of());
    }

    /** Whether the method is a {@code java.lang.Object} protocol member
     * (toString/hashCode/equals) rather than declared API surface. */
    private static boolean isObjectProtocol(ExecutableElement method) {
        String name = method.getSimpleName().toString();
        if (method.getParameters().isEmpty()) {
            return name.equals("toString") || name.equals("hashCode");
        }
        if (name.equals("equals") && method.getParameters().size() == 1
                && method.getParameters().get(0).asType().getKind()
                        == javax.lang.model.type.TypeKind.DECLARED) {
            TypeElement param = (TypeElement) ((javax.lang.model.type.DeclaredType)
                    method.getParameters().get(0).asType()).asElement();
            return param.getQualifiedName().contentEquals("java.lang.Object");
        }
        return false;
    }

    /**
     * Resolves the script-visible name of the nearest annotated ancestor
     * class, or empty when the type has no {@code @ApiClass} superclass.
     */
    private static String extendsNameOf(TypeElement type) {
        TypeMirror sup = type.getSuperclass();
        while (sup.getKind() == TypeKind.DECLARED) {
            TypeElement element = (TypeElement) ((DeclaredType) sup).asElement();
            ApiClass ann = DocletSupport.classOf(element);
            if (ann != null) {
                return ann.name();
            }
            sup = element.getSuperclass();
        }
        return "";
    }

    private static ApiModel.EventModel eventModel(TypeElement type, ApiEvent event,
                                                  DocTrees trees,
                                                  Map<String, ApiModel.TypeModel> eventReferenced,
                                                  List<String> warnings) {
        var comment = trees.getDocCommentTree(type);
        var zhBody = DocletSupport.zhBody(comment);
        if (zhBody.isEmpty()) {
            warnings.add(event.name() + ": event has no @zh docs");
        }
        String since = DocletSupport.sinceOf(type);
        if (since == null) {
            warnings.add(event.name() + ": event is missing @ApiSince");
        }
        List<ApiModel.ParameterModel> fields = new ArrayList<>();
        for (Element component : type.getEnclosedElements()) {
            if (component.getKind() == ElementKind.RECORD_COMPONENT) {
                VariableElement variable = (VariableElement) component;
                fields.add(new ApiModel.ParameterModel(
                        variable.getSimpleName().toString(),
                        DocletSupport.recordComponentType(type, variable)));
                collectReferenced(variable.asType(), eventReferenced);
            }
        }
        fields.sort(java.util.Comparator.comparing(ApiModel.ParameterModel::name));
        return new ApiModel.EventModel(event.name(), event.cancellable(),
                event.direction().name().toLowerCase(java.util.Locale.ROOT),
                List.of(event.mutable()),
                DocletSupport.eventClassName(event.name()),
                List.copyOf(fields),
                DocletSupport.paramDocs(comment), DocletSupport.zhParamDocs(comment),
                since, DocletSupport.mcOf(type), DocletSupport.loaderOf(type),
                DocletSupport.docBody(comment), zhBody.orElse(""));
    }

    private static String memberSince(ExecutableElement method, String moduleSince,
                                      String moduleName, List<String> warnings) {
        String since = DocletSupport.sinceOf(method);
        if (since == null) {
            since = moduleSince;
        }
        if (since == null) {
            warnings.add(moduleName + "." + method.getSimpleName() + ": missing @ApiSince");
            return null;
        }
        return since;
    }

    /** Registers a record type referenced by a signature for interface
     * emission, recursing into the record's own component types (unwrapping
     * collection and wrapper generics first) so nested records (e.g.
     * ItemStackData.enchantments) are declared as well. */
    private static void collectReferenced(TypeMirror type, Map<String, ApiModel.TypeModel> referenced) {
        if (type.getKind() != javax.lang.model.type.TypeKind.DECLARED) {
            return;
        }
        TypeElement element = (TypeElement) ((DeclaredType) type).asElement();
        String qualified = element.getQualifiedName().toString();
        // Unwrap common containers so records behind List<...>/Map<...> and
        // friends still get declared.
        if (qualified.equals("java.util.List") || qualified.equals("java.util.Collection")
                || qualified.equals("java.util.Set") || qualified.equals("java.util.Optional")
                || qualified.equals("java.util.concurrent.CompletableFuture")) {
            for (TypeMirror arg : ((DeclaredType) type).getTypeArguments()) {
                collectReferenced(arg, referenced);
            }
            return;
        }
        if (qualified.equals("java.util.Map")) {
            List<? extends TypeMirror> args = ((DeclaredType) type).getTypeArguments();
            if (args.size() >= 2) {
                collectReferenced(args.get(1), referenced);
            }
            return;
        }
        if (element.getKind() != ElementKind.RECORD
                || DocletSupport.eventOf(element) != null
                // @ApiClass records render once as documented class
                // interfaces; re-registering them here would emit a second
                // declaration whose readonly modifiers conflict.
                || DocletSupport.classOf(element) != null
                // Port records aliased to script types render through the
                // alias; no standalone record page for them.
                || DocletSupport.portTypeAlias(element.getSimpleName().toString()) != null) {
            return;
        }
        String name = element.getSimpleName().toString();
        if (referenced.containsKey(name)) {
            return;
        }
        List<ApiModel.ParameterModel> fields = new ArrayList<>();
        List<TypeMirror> components = new ArrayList<>();
        for (Element component : element.getEnclosedElements()) {
            if (component.getKind() == ElementKind.RECORD_COMPONENT) {
                VariableElement variable = (VariableElement) component;
                String fieldName = variable.getSimpleName().toString();
                fields.add(new ApiModel.ParameterModel(fieldName,
                        DocletSupport.recordComponentType(element, variable),
                        DocletSupport.componentOptional(element, fieldName)));
                components.add(variable.asType());
            }
        }
        fields.sort(java.util.Comparator.comparing(ApiModel.ParameterModel::name));
        referenced.put(name, new ApiModel.TypeModel(name, List.copyOf(fields)));
        for (TypeMirror component : components) {
            collectReferenced(component, referenced);
        }
    }
}
