package ink.tuanzi.neomacros.docs;

import com.sun.source.doctree.DocCommentTree;
import com.sun.source.doctree.DocTree;
import com.sun.source.doctree.ParamTree;
import com.sun.source.doctree.ReturnTree;
import com.sun.source.doctree.TextTree;
import com.sun.source.doctree.UnknownBlockTagTree;
import com.sun.source.doctree.UnknownInlineTagTree;
import ink.tuanzi.neomacros.doc.api.ApiClass;
import ink.tuanzi.neomacros.doc.api.ApiEvent;
import ink.tuanzi.neomacros.doc.api.ApiExperimental;
import ink.tuanzi.neomacros.doc.api.ApiInternal;
import ink.tuanzi.neomacros.doc.api.ApiMC;
import ink.tuanzi.neomacros.doc.api.ApiModule;
import ink.tuanzi.neomacros.doc.api.ApiPermission;
import ink.tuanzi.neomacros.doc.api.ApiReadOnly;
import ink.tuanzi.neomacros.doc.api.ApiLoader;
import ink.tuanzi.neomacros.doc.api.ApiSince;
import ink.tuanzi.neomacros.doc.api.ApiType;
import jdk.javadoc.doclet.Doclet;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Shared helpers for the doclets: Javadoc flattening, bilingual tag
 * extraction, annotation reads, and the Java-to-TypeScript type mapping.
 */
final class DocletSupport {

    private DocletSupport() {
    }

    /** Name of the warnings artifact written next to the Markdown files. */
    static final String WARNINGS_FILE = "warnings.txt";

    /**
     * Flattens the English comment body (first sentence plus remaining body,
     * block tags excluded) to normalized plain text.
     */
    static String flattenBody(DocCommentTree tree) {
        if (tree == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        appendNodes(tree.getFirstSentence(), sb);
        if (sb.length() > 0) {
            sb.append(' ');
        }
        appendNodes(tree.getBody(), sb);
        return normalize(sb.toString());
    }

    /** Collapses whitespace runs so multi-line sources render as one line. */
    static String normalize(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }

    /** Flattens a list of doc tree nodes to plain text. */
    static String flattenNodes(List<? extends DocTree> nodes) {
        StringBuilder sb = new StringBuilder();
        appendNodes(nodes, sb);
        return sb.toString();
    }

    private static void appendNodes(List<? extends DocTree> nodes, StringBuilder sb) {
        for (DocTree node : nodes) {
            if (node instanceof UnknownBlockTagTree blockTag) {
                appendNodes(blockTag.getContent(), sb);
            } else if (node instanceof UnknownInlineTagTree inlineTag) {
                appendNodes(inlineTag.getContent(), sb);
            } else {
                appendNode(node, sb);
            }
        }
    }

    private static void appendNode(DocTree node, StringBuilder sb) {
        switch (node.getKind()) {
            case TEXT -> sb.append(((TextTree) node).getBody());
            case CODE -> sb.append(((com.sun.source.doctree.LiteralTree) node).getBody().getBody());
            case LITERAL -> sb.append(((com.sun.source.doctree.LiteralTree) node).getBody().getBody());
            case ERRONEOUS -> sb.append(((com.sun.source.doctree.ErroneousTree) node).getBody());
            default -> {
                // Structural nodes (lists, links, entities) contribute nothing to the
                // plain-text view; the fixture sources use plain paragraphs only.
            }
        }
    }

    /** Extracts the English body text of the comment. */
    static String docBody(DocCommentTree tree) {
        return flattenBody(tree);
    }

    /**
     * Returns the text of a custom block tag, or empty when absent. The name
     * is given without the leading {@code @} (matching {@code getTagName()}).
     */
    static Optional<String> customTag(DocCommentTree tree, String tagName) {
        if (tree == null) {
            return Optional.empty();
        }
        return tree.getBlockTags().stream()
                .filter(UnknownBlockTagTree.class::isInstance)
                .map(t -> (UnknownBlockTagTree) t)
                .filter(t -> tagName.contentEquals(t.getTagName()))
                .map(t -> normalize(flattenNodes(t.getContent())))
                .filter(s -> !s.isEmpty())
                .findFirst();
    }

    /** Returns the @zh Chinese body text, or empty when absent. */
    static Optional<String> zhBody(DocCommentTree tree) {
        return customTag(tree, "zh");
    }

    /** Returns the @zh-example code text, or empty when absent. */
    static Optional<String> zhExample(DocCommentTree tree) {
        return customTag(tree, "zh-example");
    }

    /** Returns @param name-to-description entries. */
    static Map<String, String> paramDocs(DocCommentTree tree) {
        Map<String, String> out = new LinkedHashMap<>();
        if (tree == null) {
            return out;
        }
        for (DocTree tag : tree.getBlockTags()) {
            if (tag.getKind() == DocTree.Kind.PARAM) {
                ParamTree param = (ParamTree) tag;
                out.put(param.getName().getName().toString(), normalize(flattenNodes(param.getDescription())));
            }
        }
        return out;
    }

    /** Returns @zh-param name-to-description entries; the name is the first whitespace token. */
    static Map<String, String> zhParamDocs(DocCommentTree tree) {
        Map<String, String> out = new LinkedHashMap<>();
        if (tree == null) {
            return out;
        }
        for (DocTree tag : tree.getBlockTags()) {
            if (tag instanceof UnknownBlockTagTree blockTag
                    && "zh-param".contentEquals(blockTag.getTagName())) {
                String text = normalize(flattenNodes(blockTag.getContent()));
                int split = text.indexOf(' ');
                if (split > 0) {
                    out.put(text.substring(0, split), text.substring(split + 1).trim());
                }
            }
        }
        return out;
    }

    /** Returns @default name-to-value entries; the name is the first
     * whitespace token and the rest is the parameter's default value. */
    static Map<String, String> paramDefaults(DocCommentTree tree) {
        Map<String, String> out = new LinkedHashMap<>();
        if (tree == null) {
            return out;
        }
        for (DocTree tag : tree.getBlockTags()) {
            if (tag instanceof UnknownBlockTagTree blockTag
                    && "default".contentEquals(blockTag.getTagName())) {
                String text = normalize(flattenNodes(blockTag.getContent()));
                int split = text.indexOf(' ');
                if (split > 0) {
                    out.put(text.substring(0, split), text.substring(split + 1).trim());
                }
            }
        }
        return out;
    }

    /** Returns the @return description, or empty when absent. */
    static Optional<String> returnDoc(DocCommentTree tree) {
        if (tree == null) {
            return Optional.empty();
        }
        return tree.getBlockTags().stream()
                .filter(t -> t.getKind() == DocTree.Kind.RETURN)
                .map(t -> normalize(flattenNodes(((ReturnTree) t).getDescription())))
                .filter(s -> !s.isEmpty())
                .findFirst();
    }

    /** Returns the @zh-return description, or empty when absent. */
    static Optional<String> zhReturnDoc(DocCommentTree tree) {
        return customTag(tree, "zh-return");
    }

    /** Extracts the module declaration from an annotated class, or null when the class is not a module. */
    static ApiModule moduleOf(TypeElement type) {
        return type.getAnnotation(ApiModule.class);
    }

    /** Extracts the class declaration from an annotated type, or null when absent. */
    static ApiClass classOf(TypeElement type) {
        return type.getAnnotation(ApiClass.class);
    }

    /** Returns the {@code @ApiSince} value of a type or method element, or null when absent. */
    static String sinceOf(Element element) {
        ApiSince since = element.getAnnotation(ApiSince.class);
        return since == null ? null : since.value();
    }

    /** Returns the {@code @ApiLoader} value of a type or method element, or null when absent. */
    static String loaderOf(javax.lang.model.element.Element element) {
        ApiLoader loader = element.getAnnotation(ApiLoader.class);
        return loader == null ? null : loader.value();
    }

    /** Returns the {@code @ApiMC} range of a type or method element, or null when absent. */
    static String mcOf(Element element) {
        ApiMC mc = element.getAnnotation(ApiMC.class);
        return mc == null ? null : mc.value();
    }

    /** Returns the capability key required by {@code @ApiPermission}, or null when unrestricted. */
    static String permissionOf(Element element) {
        ApiPermission permission = element.getAnnotation(ApiPermission.class);
        return permission == null ? null : permission.value();
    }

    /** Returns the explicit TypeScript type of the member or parameter, or empty when inferred. */
    static Optional<String> typeOverrideOf(Element element) {
        ApiType override = element.getAnnotation(ApiType.class);
        return override == null ? Optional.empty() : Optional.of(override.value());
    }

    /** Returns true when the member carries the experimental badge. */
    static boolean experimentalOf(Element element) {
        return element.getAnnotation(ApiExperimental.class) != null;
    }

    /** Returns true when the member is internal surface and must be hidden from documentation. */
    static boolean internalOf(Element element) {
        return element.getAnnotation(ApiInternal.class) != null;
    }

    /** Returns true when the member is marked read-only in the TypeScript definitions. */
    static boolean readOnlyOf(Element element) {
        return element.getAnnotation(ApiReadOnly.class) != null;
    }

    /** Returns the event descriptor carried by a record class, or null when absent. */
    static ApiEvent eventOf(TypeElement type) {
        return type.getAnnotation(ApiEvent.class);
    }

    /** The script-facing payload class name of one event ({@code chat:receive} ->
     * {@code ChatReceiveEvent}); mirrors the engine glue rule. */
    static String eventClassName(String eventName) {
        StringBuilder out = new StringBuilder();
        boolean upperNext = true;
        for (char ch : eventName.toCharArray()) {
            if (ch == ':' || ch == '_' || ch == '-') {
                upperNext = true;
            } else if (upperNext) {
                out.append(Character.toUpperCase(ch));
                upperNext = false;
            } else {
                out.append(ch);
            }
        }
        out.append("Event");
        return out.toString();
    }

    /** True when the method is a bean getter (getX/isX with no parameters and a non-void return). */
    static boolean isBeanGetter(ExecutableElement method) {
        String name = method.getSimpleName().toString();
        boolean prefix = name.startsWith("get") || name.startsWith("is");
        return prefix && method.getParameters().isEmpty()
                && method.getReturnType().getKind() != TypeKind.VOID;
    }

    /** Converts a bean getter name to the script property name ({@code getName} to {@code name}). */
    static String propertyName(ExecutableElement getter) {
        String name = getter.getSimpleName().toString();
        int offset = 0;
        if (name.startsWith("is") && name.length() > 2) {
            offset = 2;
        } else if (name.startsWith("get") && name.length() > 3) {
            offset = 3;
        }
        String base = name.substring(offset);
        return base.isEmpty() ? base : Character.toLowerCase(base.charAt(0)) + base.substring(1);
    }

    /** Maps a Java signature type to the script-visible TypeScript type. */
    static String tsType(TypeMirror type) {
        return switch (type.getKind()) {
            case BOOLEAN -> "boolean";
            case BYTE, SHORT, INT, LONG, FLOAT, DOUBLE -> "number";
            case CHAR -> "string";
            case VOID -> "void";
            case DECLARED -> tsDeclaredType((DeclaredType) type);
            case ARRAY -> tsArrayType((javax.lang.model.type.ArrayType) type);
            default -> "unknown";
        };
    }

    /** Maps a Java array to the script-visible type: byte arrays cross as
     * Uint8Array (the engine's byte-channel rendering), everything else as
     * a typed script array. */
    private static String tsArrayType(javax.lang.model.type.ArrayType type) {
        TypeMirror component = type.getComponentType();
        if (component.getKind() == TypeKind.BYTE) {
            return "Uint8Array";
        }
        return "Array<" + tsType(component) + ">";
    }

    private static String tsDeclaredType(DeclaredType type) {
        TypeElement element = (TypeElement) type.asElement();
        Optional<String> override = typeOverrideOf(element);
        if (override.isPresent()) {
            return override.get();
        }
        ApiClass apiClass = classOf(element);
        if (apiClass != null) {
            return apiClass.name();
        }
        if (element.getKind() == ElementKind.RECORD) {
            return element.getSimpleName().toString();
        }
        List<? extends TypeMirror> args = type.getTypeArguments();
        return switch (element.getQualifiedName().toString()) {
            case "java.lang.String", "java.lang.CharSequence", "java.util.UUID",
                    "java.lang.Character" -> "string";
            case "java.lang.Void" -> "void";
            case "java.lang.Boolean" -> "boolean";
            case "java.lang.Byte", "java.lang.Short", "java.lang.Integer",
                    "java.lang.Long", "java.lang.Float", "java.lang.Double" -> "number";
            case "java.lang.Object" -> "unknown";
            case "java.util.List", "java.util.Collection", "java.util.Set" ->
                    "Array<" + (args.isEmpty() ? "unknown" : tsType(args.get(0))) + ">";
            case "java.util.Map" -> {
                String key = args.isEmpty() ? "unknown" : tsType(args.get(0));
                String value = args.size() < 2 ? "unknown" : tsType(args.get(1));
                yield "Record<" + key + ", " + value + ">";
            }
            case "java.util.Optional" ->
                    (args.isEmpty() ? "unknown" : tsType(args.get(0))) + " | undefined";
            case "java.util.concurrent.CompletableFuture" ->
                    "Promise<" + (args.isEmpty() ? "void" : tsType(args.get(0))) + ">";
            case "java.util.concurrent.Callable" ->
                    "() => " + (args.isEmpty() ? "unknown" : tsType(args.get(0)));
            case "java.util.function.Consumer" ->
                    "(arg: " + (args.isEmpty() ? "unknown" : tsType(args.get(0))) + ") => void";
            case "java.util.function.Predicate" ->
                    "(arg: " + (args.isEmpty() ? "unknown" : tsType(args.get(0))) + ") => boolean";
            case "java.util.function.DoubleConsumer" -> "(arg: number) => void";
            case "java.lang.Runnable" -> "() => void";
            default -> element.getSimpleName().toString();
        };
    }

    /** Whether the element carries {@code @ApiOptional}, detected by qualified
     * name: the marker only exists in doc-api revisions that ship it, and a
     * compile-time reference here would break builds against older jars. */
    static boolean hasApiOptional(Element element) {
        return element.getAnnotationMirrors().stream().anyMatch(mirror ->
                mirror.getAnnotationType().toString()
                        .equals("ink.tuanzi.neomacros.doc.api.ApiOptional"));
    }

    /**
     * The effective {@code @ApiType} override of one record component. The
     * javadoc source model keeps annotations off the RECORD_COMPONENT
     * element itself, so the override is read off the generated accessor
     * method ({@code @ApiType} carries the METHOD target and propagates
     * there).
     */
    static Optional<String> componentTypeOverride(TypeElement record, String componentName) {
        for (Element member : record.getEnclosedElements()) {
            if (member.getKind() == ElementKind.METHOD
                    && member.getModifiers().contains(javax.lang.model.element.Modifier.PUBLIC)
                    && member.getSimpleName().contentEquals(componentName)) {
                return typeOverrideOf(member);
            }
        }
        return Optional.empty();
    }

    /**
     * The script type of one record component: its override (when annotated)
     * or the inferred mapping, with unbound fact maps
     * ({@code Map<String, Object>}) reading as JSON values — record
     * components carry neutral plain data by construction.
     */
    static String recordComponentType(TypeElement record, VariableElement component) {
        String name = component.getSimpleName().toString();
        String mapped = componentTypeOverride(record, name)
                .orElseGet(() -> tsType(component.asType()));
        if (mapped.equals("Record<string, unknown>")) {
            return "Record<string, JsonValue>";
        }
        return mapped;
    }

    /**
     * Whether one record component carries {@code @ApiOptional}: the marker
     * (PARAMETER target) propagates to the canonical constructor parameter,
     * which the source model does expose.
     */
    static boolean componentOptional(TypeElement record, String componentName) {
        for (Element member : record.getEnclosedElements()) {
            if (member.getKind() == ElementKind.CONSTRUCTOR) {
                for (VariableElement parameter
                        : ((ExecutableElement) member).getParameters()) {
                    if (parameter.getSimpleName().contentEquals(componentName)
                            && hasApiOptional(parameter)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /** Returns the parameters of the method as name/type pairs, honoring
     * {@code @ApiType} overrides, the {@code @ApiOptional} marker, and the
     * Java varargs tail. */
    static List<ApiModel.ParameterModel> parametersOf(ExecutableElement method) {
        List<? extends VariableElement> parameters = method.getParameters();
        boolean varargs = method.isVarArgs() && !parameters.isEmpty();
        List<ApiModel.ParameterModel> out = new java.util.ArrayList<>();
        for (int i = 0; i < parameters.size(); i++) {
            VariableElement p = parameters.get(i);
            out.add(new ApiModel.ParameterModel(p.getSimpleName().toString(),
                    typeOverrideOf(p).orElseGet(() -> tsType(p.asType())),
                    hasApiOptional(p), varargs && i == parameters.size() - 1));
        }
        return List.copyOf(out);
    }

    /** Returns the script-visible return type of the method, honoring an @ApiType override. */
    static String returnTypeOf(ExecutableElement method) {
        return typeOverrideOf(method).orElseGet(() -> tsType(method.getReturnType()));
    }

    /** Accepts a single-argument option without consuming its value (e.g. {@code -tag}). */
    static Doclet.Option passthroughOption(String name) {
        return new Doclet.Option() {
            @Override
            public int getArgumentCount() {
                return 1;
            }

            @Override
            public String getDescription() {
                return "declares a custom tag; consumed by the doclet without action";
            }

            @Override
            public Doclet.Option.Kind getKind() {
                return Doclet.Option.Kind.STANDARD;
            }

            @Override
            public List<String> getNames() {
                return List.of(name);
            }

            @Override
            public String getParameters() {
                return "specification";
            }

            @Override
            public boolean process(String option, List<String> arguments) {
                return true;
            }
        };
    }
}
