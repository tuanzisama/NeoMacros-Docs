package ink.tuanzi.neomacros.docs;

import ink.tuanzi.neomacros.doc.api.ApiClassKind;

import java.util.List;
import java.util.Map;

/**
 * Doclet-side model of the script-facing API surface, extracted from
 * doc-api annotations and Javadoc. Both renderers (Markdown and TypeScript)
 * consume the same model, so generated artifacts cannot diverge.
 *
 * @param modules        modules sorted by name
 * @param events         event descriptors sorted by name (nested and standalone)
 * @param standaloneClasses @ApiClass classes not nested in any facade, sorted by name
 * @param eventReferencedTypes record types referenced from event fields only,
 *        sorted by name (facade-referenced records hang off their module)
 * @param standaloneReferencedTypes record types referenced from standalone
 *        class signatures only, sorted by name
 * @param warnings       generation warnings (missing @zh translations, missing @ApiSince)
 */
public record ApiModel(List<ModuleModel> modules, List<EventModel> events,
        List<ClassModel> standaloneClasses, List<TypeModel> eventReferencedTypes,
        List<TypeModel> standaloneReferencedTypes,
        List<String> warnings) {

    /** One script-visible API module. */
    public record ModuleModel(
            String name, String category,
            String doc, String zhDoc, String since, String mc, String loader,
            List<PropertyModel> properties, List<MethodModel> methods,
            List<ClassModel> classes, List<TypeModel> referencedTypes) {
    }

    /** Record type referenced in a module's signatures, rendered as a TS interface of its components. */
    public record TypeModel(String name, List<ParameterModel> fields) {
    }

    /** Bean-getter member rendered as a script property. */
    public record PropertyModel(
            String name, String type,
            String doc, String zhDoc,
            boolean readOnly, String since, String mc, String loader, String permission,
            boolean experimental) {
    }

    /** Action member rendered as a script method. */
    public record MethodModel(
            String name, List<ParameterModel> parameters, String returnType,
            String doc, Map<String, String> paramDocs, String returnDoc, String zhDoc,
            Map<String, String> zhParamDocs, String zhReturnDoc, String zhExample,
            String since, String mc, String loader, String permission,
            boolean experimental, Map<String, String> paramDefaults) {
    }

    /** Method parameter; {@code optional} marks parameters a script may omit,
     * {@code varargs} marks a Java varargs tail parameter, and
     * {@code defaultValue} carries the {@code @default} tag value or null. */
    public record ParameterModel(String name, String type, boolean optional, boolean varargs,
            String defaultValue) {
        public ParameterModel(String name, String type) {
            this(name, type, false, false, null);
        }

        public ParameterModel(String name, String type, boolean optional) {
            this(name, type, optional, false, null);
        }

        public ParameterModel(String name, String type, boolean optional, boolean varargs) {
            this(name, type, optional, varargs, null);
        }
    }

    /** Script-facing class declared with {@code @ApiClass} (live handle or immutable data). */
    public record ClassModel(
            String name, ApiClassKind kind, String wraps, String extendsName,
            String doc, String zhDoc,
            List<PropertyModel> properties, List<MethodModel> methods) {
    }

    /**
     * Event descriptor declared with {@code @ApiEvent}. The payload always
     * dispatches as a frozen {@code className extends BaseEvent} instance;
     * field descriptions come from the record's {@code @param} and
     * {@code @zh-param} tags.
     */
    public record EventModel(
            String name, boolean cancellable, String className,
            List<ParameterModel> fields,
            Map<String, String> fieldDocs, Map<String, String> zhFieldDocs,
            String since, String mc, String loader,
            String doc, String zhDoc) {
    }
}
