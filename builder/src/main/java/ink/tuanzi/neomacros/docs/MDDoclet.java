package ink.tuanzi.neomacros.docs;

import jdk.javadoc.doclet.Doclet;
import jdk.javadoc.doclet.DocletEnvironment;
import jdk.javadoc.doclet.Reporter;

import javax.lang.model.SourceVersion;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * Renders one bilingual Markdown page per module plus one page per
 * documented script-facing type and event: {@code <name>.md} from the
 * English Javadoc (the normative source) and {@code <name>.zh.md} from the
 * {@code @zh} tag translations, falling back to the English text per member.
 * Class and referenced-record pages live under {@code classes/}, event pages
 * under {@code events/}, and event payload classes (plus {@code BaseEvent})
 * under {@code types/}. Generation warnings (missing translations, missing
 * {@code @ApiSince}) are collected into {@code warnings.txt}.
 */
public class MDDoclet implements Doclet {

    private Reporter reporter;
    private Path outDir = Path.of("docs-dist");

    /** Supported Minecraft versions, ascending; empty disables the matrix page. */
    private List<String> mcVersions = List.of();

    @Override
    public void init(Locale locale, Reporter reporter) {
        this.reporter = reporter;
    }

    @Override
    public String getName() {
        return "MDDoclet";
    }

    @Override
    public Set<? extends Doclet.Option> getSupportedOptions() {
        return Set.of(
                new Doclet.Option() {
                    @Override
                    public int getArgumentCount() {
                        return 1;
                    }

                    @Override
                    public String getDescription() {
                        return "output directory for the generated Markdown pages";
                    }

                    @Override
                    public Doclet.Option.Kind getKind() {
                        return Doclet.Option.Kind.STANDARD;
                    }

                    @Override
                    public List<String> getNames() {
                        return List.of("-d");
                    }

                    @Override
                    public String getParameters() {
                        return "directory";
                    }

                    @Override
                    public boolean process(String option, List<String> arguments) {
                        outDir = Path.of(arguments.get(0));
                        return true;
                    }
                },
                new Doclet.Option() {
                    @Override
                    public int getArgumentCount() {
                        return 1;
                    }

                    @Override
                    public String getDescription() {
                        return "comma-separated supported Minecraft versions, ascending; "
                                + "enables the version-compatibility matrix page";
                    }

                    @Override
                    public Doclet.Option.Kind getKind() {
                        return Doclet.Option.Kind.STANDARD;
                    }

                    @Override
                    public List<String> getNames() {
                        return List.of("-mc-versions");
                    }

                    @Override
                    public String getParameters() {
                        return "versions";
                    }

                    @Override
                    public boolean process(String option, List<String> arguments) {
                        mcVersions = List.of(arguments.get(0).split("\\s*,\\s*"));
                        return true;
                    }
                },
                DocletSupport.passthroughOption("-tag"));
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean run(DocletEnvironment env) {
        ApiModel model = ModelExtractor.extract(env);
        Path apiDir = outDir.resolve("api");
        Path classesDir = apiDir.resolve("classes");
        Path eventsDir = apiDir.resolve("events");
        Path typesDir = apiDir.resolve("types");
        Map<String, List<String>> extendedBy = new java.util.LinkedHashMap<>();
        for (ApiModel.ModuleModel module : model.modules()) {
            for (ApiModel.ClassModel clazz : module.classes()) {
                if (!clazz.extendsName().isEmpty()) {
                    extendedBy.computeIfAbsent(clazz.extendsName(), k -> new java.util.ArrayList<>())
                            .add(clazz.name());
                }
            }
        }
        for (ApiModel.ClassModel clazz : model.standaloneClasses()) {
            if (!clazz.extendsName().isEmpty()) {
                extendedBy.computeIfAbsent(clazz.extendsName(), k -> new java.util.ArrayList<>())
                        .add(clazz.name());
            }
        }
        // Every documented type name resolves to its own page under classes/.
        Set<String> classNames = new java.util.TreeSet<>();
        for (ApiModel.ModuleModel module : model.modules()) {
            for (ApiModel.ClassModel clazz : module.classes()) {
                classNames.add(clazz.name());
            }
        }
        for (ApiModel.ClassModel clazz : model.standaloneClasses()) {
            classNames.add(clazz.name());
        }
        // Referenced record types, deduplicated by name across modules; a
        // name that already has a class page wins.
        Map<String, ApiModel.TypeModel> referencedTypes = new java.util.TreeMap<>();
        for (ApiModel.ModuleModel module : model.modules()) {
            for (ApiModel.TypeModel type : module.referencedTypes()) {
                if (!classNames.contains(type.name())) {
                    referencedTypes.putIfAbsent(type.name(), type);
                }
            }
        }
        classNames.addAll(referencedTypes.keySet());
        // Records referenced only from event fields get pages too; a name
        // that already has a class page wins.
        for (ApiModel.TypeModel type : model.eventReferencedTypes()) {
            if (!classNames.contains(type.name())) {
                referencedTypes.putIfAbsent(type.name(), type);
                classNames.add(type.name());
            }
        }
        // Event payload classes live under types/ (one page per dispatched
        // class plus the shared BaseEvent), so their names link differently.
        Set<String> eventTypeNames = new java.util.TreeSet<>();
        eventTypeNames.add("BaseEvent");
        for (ApiModel.EventModel event : model.events()) {
            eventTypeNames.add(event.className());
        }
        try {
            Files.createDirectories(apiDir);
            Files.createDirectories(classesDir);
            Files.createDirectories(eventsDir);
            Files.createDirectories(typesDir);
            for (ApiModel.ModuleModel module : model.modules()) {
                write(apiDir.resolve(module.name() + ".md"),
                        renderModule(module, false, extendedBy,
                                linkTargets(classNames, eventTypeNames, "classes/", "types/")));
                write(apiDir.resolve(module.name() + ".zh.md"),
                        renderModule(module, true, extendedBy,
                                linkTargets(classNames, eventTypeNames, "classes/", "types/")));
                for (ApiModel.ClassModel clazz : module.classes()) {
                    write(classesDir.resolve(clazz.name() + ".md"),
                            renderClassPage(clazz, extendedBy, classLinks(classNames, eventTypeNames), false));
                    write(classesDir.resolve(clazz.name() + ".zh.md"),
                            renderClassPage(clazz, extendedBy, classLinks(classNames, eventTypeNames), true));
                }
            }
            for (ApiModel.ClassModel clazz : model.standaloneClasses()) {
                write(classesDir.resolve(clazz.name() + ".md"),
                        renderClassPage(clazz, extendedBy, classLinks(classNames, eventTypeNames), false));
                write(classesDir.resolve(clazz.name() + ".zh.md"),
                        renderClassPage(clazz, extendedBy, classLinks(classNames, eventTypeNames), true));
            }
            for (ApiModel.TypeModel type : referencedTypes.values()) {
                write(classesDir.resolve(type.name() + ".md"), renderTypePage(type, false));
                write(classesDir.resolve(type.name() + ".zh.md"), renderTypePage(type, true));
            }
            for (ApiModel.EventModel event : model.events()) {
                write(eventsDir.resolve(eventSlug(event.name()) + ".md"),
                        renderEventPage(event, false, eventLinks(classNames, eventTypeNames)));
                write(eventsDir.resolve(eventSlug(event.name()) + ".zh.md"),
                        renderEventPage(event, true, eventLinks(classNames, eventTypeNames)));
                write(typesDir.resolve(event.className() + ".md"),
                        renderEventTypePage(event, false, typePageLinks(classNames)));
                write(typesDir.resolve(event.className() + ".zh.md"),
                        renderEventTypePage(event, true, typePageLinks(classNames)));
            }
            write(typesDir.resolve("BaseEvent.md"), renderBaseEventPage(false));
            write(typesDir.resolve("BaseEvent.zh.md"), renderBaseEventPage(true));
            if (!mcVersions.isEmpty()) {
                VersionMatrix.write(apiDir, model, mcVersions);
            }
            write(apiDir.resolve(DocletSupport.WARNINGS_FILE),
                    String.join("\n", model.warnings()) + "\n");
        } catch (IOException e) {
            report("failed to write generated documentation: " + e.getMessage());
            return false;
        }
        model.warnings().forEach(this::report);
        return true;
    }

    /** File-name slug of one event name (colon becomes a dash, lowercased). */
    private static String eventSlug(String eventName) {
        return eventName.toLowerCase(Locale.ROOT).replace(':', '-');
    }

    /**
     * Link targets for one page context: known type name to the relative
     * link prefix that reaches its page from the rendered page. Classes and
     * referenced records live under {@code classes/}, event payload classes
     * under {@code types/}; pages inside a subdirectory need a {@code ../}
     * prefix because the site strips only the numeric ordering prefix from
     * directory routes.
     */
    private static Map<String, String> linkTargets(Set<String> classNames,
            Set<String> eventTypeNames, String classPrefix, String typePrefix) {
        Map<String, String> out = new java.util.LinkedHashMap<>();
        for (String name : classNames) {
            out.put(name, classPrefix);
        }
        for (String name : eventTypeNames) {
            out.put(name, typePrefix);
        }
        return out;
    }

    /** Link targets on class pages: classes sit next door, types one level up. */
    private static Map<String, String> classLinks(Set<String> classNames, Set<String> eventTypeNames) {
        return linkTargets(classNames, eventTypeNames, "", "../types/");
    }

    /** Link targets on event pages, which the site nests one level deeper. */
    private static Map<String, String> eventLinks(Set<String> classNames, Set<String> eventTypeNames) {
        return linkTargets(classNames, eventTypeNames, "../classes/", "../types/");
    }

    /** Link targets on the types pages themselves. */
    private static Map<String, String> typePageLinks(Set<String> classNames) {
        return linkTargets(classNames, new java.util.TreeSet<>(), "../classes/", "");
    }

    /**
     * YAML frontmatter leading every generated page: the Docus docs layout
     * renders the page title and description from it in the page header,
     * so the body carries neither a duplicate H1 nor a duplicate
     * description paragraph. Nuxt Content v3 would otherwise auto-extract
     * the first body paragraph as the description — for class pages that
     * first paragraph is the meta line ("Handle · ..."), which reads as a
     * nonsense description.
     */
    static String frontmatter(String title, String description) {
        String desc = description.replaceAll("\\s+", " ").trim();
        return "---\ntitle: " + yaml(title) + "\ndescription: " + yaml(desc) + "\n---\n\n";
    }

    /** Double-quoted YAML scalar with the two special characters escaped. */
    private static String yaml(String s) {
        return "\"" + s.replace("\\", "\\\\").replace("\"", "\\\"") + "\"";
    }

    /** Renders one module page; {@code zh} selects the translation-fallback view. */
    private static String renderModule(ApiModel.ModuleModel module, boolean zh,
                                       Map<String, List<String>> extendedBy,
                                       Map<String, String> linkTargets) {
        StringBuilder sb = new StringBuilder();
        sb.append(frontmatter(module.name(), text(module.doc(), module.zhDoc(), zh)));

        List<String> meta = new java.util.ArrayList<>();
        if (!module.category().isEmpty()) {
            meta.add("Category: " + categoryLabel(module.category(), zh));
        }
        if (module.since() != null) {
            meta.add("Since: " + module.since());
        }
        if (module.mc() != null) {
            meta.add("MC availability: " + module.mc());
        }
        if (module.loader() != null) {
            meta.add("Loader availability: " + module.loader());
        }
        meta.add(module.global() ? "Exposed as `neo." + module.name() + "` and `@neomacros/"
                + module.name() + "`" : "ES module only: `@neomacros/" + module.name() + "`");
        sb.append(String.join(" · ", meta)).append("\n\n");

        // Module classes are documented on their own pages under classes/.
        if (!module.classes().isEmpty()) {
            sb.append("**Classes**\n\n");
            List<String> links = new java.util.ArrayList<>();
            for (ApiModel.ClassModel clazz : module.classes()) {
                links.add("[`" + clazz.name() + "`](classes/" + clazz.name() + ".html)");
            }
            sb.append(String.join(" · ", links)).append("\n\n");
        }

        renderProperties(sb, module.properties(), zh, linkTargets);
        renderMethods(sb, module.methods(), zh, linkTargets);
        return sb.toString();
    }

    /** Renders one script-facing class as its own page under classes/. */
    private static String renderClassPage(ApiModel.ClassModel clazz,
            Map<String, List<String>> extendedBy, Map<String, String> linkTargets, boolean zh) {
        StringBuilder sb = new StringBuilder();
        sb.append(frontmatter(clazz.name(), text(clazz.doc(), clazz.zhDoc(), zh)));
        sb.append(String.join(" · ", classMeta(clazz, extendedBy))).append("\n\n");
        renderProperties(sb, clazz.properties(), zh, linkTargets);
        renderMethods(sb, clazz.methods(), zh, linkTargets);
        return sb.toString();
    }

    /** Renders one referenced record type as its own page under classes/. */
    private static String renderTypePage(ApiModel.TypeModel type, boolean zh) {
        StringBuilder sb = new StringBuilder();
        sb.append(frontmatter(type.name(), zh
                ? "API 签名中引用的 record 类型。"
                : "Record type referenced in API signatures."));
        sb.append("| Field | Type |\n");
        sb.append("| --- | --- |\n");
        for (ApiModel.ParameterModel field : type.fields()) {
            sb.append("| `").append(field.name()).append("` | `").append(field.type()).append("` |\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    /**
     * Renders one event as its own page under events/. The meta line leads
     * to the dispatched payload class under types/ so a script author can
     * follow the event name to its type definition.
     */
    private static String renderEventPage(ApiModel.EventModel event, boolean zh,
            Map<String, String> linkTargets) {
        StringBuilder sb = new StringBuilder();
        sb.append(frontmatter(event.name(), text(event.doc(), event.zhDoc(), zh)));
        List<String> meta = new java.util.ArrayList<>();
        meta.add("Payload: [`" + event.className() + "`](../types/" + event.className() + ".html)");
        if (event.cancellable()) {
            meta.add("Cancellable");
        }
        if (event.since() != null) {
            meta.add("Since: " + event.since());
        }
        if (event.mc() != null) {
            meta.add("MC: " + event.mc());
        }
        if (event.loader() != null) {
            meta.add("Loader: " + event.loader());
        }
        sb.append(String.join(" · ", meta)).append("\n\n");
        if (!event.fields().isEmpty()) {
            sb.append("| Field | Type | Description |\n| --- | --- | --- |\n");
            for (ApiModel.ParameterModel field : event.fields()) {
                sb.append("| `").append(field.name()).append("` | ")
                        .append(linkType(field.type(), linkTargets)).append(" | ")
                        .append(fieldDescription(event, field.name(), zh)).append(" |\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Renders one event payload class as its own page under types/, with a
     * raised-by link back to its event page.
     */
    private static String renderEventTypePage(ApiModel.EventModel event, boolean zh,
            Map<String, String> linkTargets) {
        StringBuilder sb = new StringBuilder();
        sb.append(frontmatter(event.className(), text(event.doc(), event.zhDoc(), zh)));
        List<String> meta = new java.util.ArrayList<>();
        meta.add("Extends: [`BaseEvent`](BaseEvent.html)");
        meta.add("Raised by: [`" + event.name() + "`](" + eventHref(eventSlug(event.name())) + ")");
        if (event.since() != null) {
            meta.add("Since: " + event.since());
        }
        if (event.mc() != null) {
            meta.add("MC: " + event.mc());
        }
        if (event.loader() != null) {
            meta.add("Loader: " + event.loader());
        }
        sb.append(String.join(" · ", meta)).append("\n\n");
        if (!event.fields().isEmpty()) {
            sb.append("| Field | Type | Description |\n| --- | --- | --- |\n");
            for (ApiModel.ParameterModel field : event.fields()) {
                sb.append("| `").append(field.name()).append("` | ")
                        .append(linkType(field.type(), linkTargets)).append(" | ")
                        .append(fieldDescription(event, field.name(), zh)).append(" |\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /** Renders the shared event base class as its own page under types/. */
    private static String renderBaseEventPage(boolean zh) {
        StringBuilder sb = new StringBuilder();
        sb.append(frontmatter("BaseEvent", zh
                ? "所有事件载荷共用的基类；分发到脚本的事件实例都是它的冻结子类实例。"
                : "Base class shared by all event payloads; dispatched event instances are frozen subclasses of it."));
        sb.append("| Property | Type | Description |\n| --- | --- | --- |\n");
        sb.append("| `type` | `string` | ").append(zh ? "事件名，如 `chat:receive`。" : "Event name, e.g. `chat:receive`.").append(" |\n");
        sb.append("| `timestamp` | `number` | ").append(zh ? "事件分发时的毫秒时间戳。" : "Dispatch time in epoch milliseconds.").append(" |\n");
        sb.append("| `cancellable` | `boolean` | ").append(zh ? "本事件是否可取消。" : "Whether this event is cancellable.").append(" |\n");
        sb.append("\n## Methods\n\n### `toJSON()`\n\n");
        sb.append(zh ? "返回事件的普通对象形式，可直接 `JSON.stringify`。"
                     : "Plain-object form of the event so `JSON.stringify` renders it directly.");
        sb.append("\n\n");
        return sb.toString();
    }

    /** Picks the event field description for the current view, falling back to English. */
    private static String fieldDescription(ApiModel.EventModel event, String field, boolean zh) {
        String en = event.fieldDocs().getOrDefault(field, "");
        return zh ? event.zhFieldDocs().getOrDefault(field, en) : en;
    }

    /**
     * Location of one synced event page relative to the types/ directory:
     * the site groups event pages into a per-domain subfolder derived from
     * the slug's first dash segment (e.g. chat-receive -> events/chat/).
     */
    private static String eventHref(String slug) {
        int dash = slug.indexOf('-');
        String domain = dash < 0 ? slug : slug.substring(0, dash);
        return "../events/" + domain + "/" + slug + ".html";
    }

    /** Composes the kind/wraps/inheritance meta line of one class page. */
    private static List<String> classMeta(ApiModel.ClassModel clazz,
                                          Map<String, List<String>> extendedBy) {
        List<String> meta = new java.util.ArrayList<>();
        meta.add(switch (clazz.kind()) {
            case HANDLE -> "Handle";
            case DATA -> "Data";
        });
        if (!clazz.wraps().isEmpty()) {
            meta.add("Wraps: `" + clazz.wraps() + "`");
        }
        if (!clazz.extendsName().isEmpty()) {
            meta.add("Extends: [`" + clazz.extendsName() + "`](" + clazz.extendsName() + ".html)");
        }
        List<String> children = extendedBy.getOrDefault(clazz.name(), List.of());
        if (!children.isEmpty()) {
            meta.add("Extended by: " + joinLinks(children));
        }
        return meta;
    }

    /** Link-joins type names pointing at their class pages (same directory). */
    private static String joinLinks(List<String> names) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < names.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append("[`").append(names.get(i)).append("`](").append(names.get(i)).append(".html)");
        }
        return sb.toString();
    }

    private static void renderProperties(StringBuilder sb, List<ApiModel.PropertyModel> properties,
            boolean zh, Map<String, String> linkTargets) {
        if (properties.isEmpty()) {
            return;
        }
        sb.append("## Properties\n\n");
        sb.append("| Property | Type | Description |\n");
        sb.append("| --- | --- | --- |\n");
        for (ApiModel.PropertyModel property : properties) {
            sb.append("| `").append(property.name()).append("` | ")
                    .append(linkType(property.type(), linkTargets)).append(" | ");
            sb.append(text(property.doc(), property.zhDoc(), zh));
            if (property.readOnly()) {
                sb.append(" (read-only)");
            }
            if (property.experimental()) {
                sb.append(" (experimental)");
            }
            sb.append(" |\n");
        }
        sb.append("\n");
    }

    private static void renderMethods(StringBuilder sb, List<ApiModel.MethodModel> methods,
            boolean zh, Map<String, String> linkTargets) {
        if (methods.isEmpty()) {
            return;
        }
        sb.append("## Methods\n\n");
        for (ApiModel.MethodModel method : methods) {
            sb.append("### `").append(method.name()).append("(");
            sb.append(joinParameters(method));
            sb.append(")`\n\n");
            sb.append(text(method.doc(), method.zhDoc(), zh)).append("\n\n");
            if (!method.parameters().isEmpty()) {
                sb.append("**Parameters**\n\n");
                for (ApiModel.ParameterModel parameter : method.parameters()) {
                    sb.append("- `").append(parameter.name()).append("` ").append(
                            linkType(parameter.type(), linkTargets)
                    ).append(": ").append(method.paramDocs().getOrDefault(parameter.name(),
                            method.zhParamDocs().getOrDefault(parameter.name(), "")));
                    if (parameter.optional()) {
                        sb.append(zh ? "（可选，缺省按方法说明取默认值）" : " (optional, defaults per the method description)");
                    }
                    sb.append("\n");
                }
                sb.append("\n");
            }
            String returns = text(method.returnDoc(), method.zhReturnDoc(), zh);
            if (!returns.isEmpty() || !method.returnType().equals("void")) {
                sb.append("**Returns** ").append(linkType(method.returnType(), linkTargets));
                if (!returns.isEmpty()) {
                    sb.append(" — ").append(returns);
                }
                sb.append("\n\n");
            }
            List<String> badges = new java.util.ArrayList<>();
            if (method.since() != null) {
                badges.add("Since: " + method.since());
            }
            if (method.mc() != null) {
                badges.add("MC: " + method.mc());
            }
            if (method.loader() != null) {
                badges.add("Loader: " + method.loader());
            }
            if (method.permission() != null) {
                badges.add("Permission: `" + method.permission() + "`");
            }
            if (method.experimental()) {
                badges.add("Experimental");
            }
            if (!badges.isEmpty()) {
                sb.append(String.join(" · ", badges)).append("\n\n");
            }
            if (zh && !method.zhExample().isEmpty()) {
                sb.append("**Example**\n\n```js\n").append(method.zhExample()).append("\n```\n\n");
            }
        }
    }

    private static String joinParameters(ApiModel.MethodModel method) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < method.parameters().size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            ApiModel.ParameterModel parameter = method.parameters().get(i);
            sb.append(parameter.name()).append(parameter.optional() ? "?" : "")
                    .append(": ").append(parameter.type());
        }
        return sb.toString();
    }

    /**
     * Wraps known type names in wiki-style links to their pages. The link
     * target map supplies each known name's relative link prefix for the
     * current page context. Unlinked regions stay one code span each so
     * generics like {@code Promise<void>} render verbatim; bare code spans
     * are skipped when nothing links.
     */
    private static String linkType(String type, Map<String, String> linkTargets) {
        if (type == null || type.isEmpty()) {
            return "`" + type + "`";
        }
        var matcher = java.util.regex.Pattern.compile("[A-Z][A-Za-z0-9]+").matcher(type);
        var out = new StringBuilder();
        int last = 0;
        boolean linked = false;
        while (matcher.find()) {
            String word = matcher.group();
            String prefix = linkTargets.get(word);
            if (prefix != null) {
                String before = type.substring(last, matcher.start());
                if (!before.isEmpty()) {
                    out.append("`").append(before).append("`");
                }
                out.append("[").append(word).append("](")
                        .append(prefix).append(word).append(".html)");
                last = matcher.end();
                linked = true;
            }
        }
        if (!linked) {
            return "`" + type + "`";
        }
        String remaining = type.substring(last);
        if (!remaining.isEmpty()) {
            out.append("`").append(remaining).append("`");
        }
        return out.toString();
    }

    /** Picks the translation for the current view, falling back to English. */
    private static String text(String en, String zh, boolean zhView) {
        return zhView && !zh.isEmpty() ? zh : en;
    }

    /**
     * English display label for a module category on the English page;
     * category values in {@code @ApiModule} are zh-first, so the English
     * view maps the known set and passes anything else through verbatim.
     */
    private static String categoryLabel(String category, boolean zhView) {
        if (zhView) {
            return category;
        }
        return switch (category) {
            case "核心" -> "Core";
            case "界面" -> "UI";
            case "世界" -> "World";
            case "系统" -> "System";
            case "输入" -> "Input";
            default -> category;
        };
    }

    private void report(String message) {
        reporter.print(javax.tools.Diagnostic.Kind.WARNING, message);
    }

    private static void write(Path file, String content) throws IOException {
        Files.writeString(file, content, StandardCharsets.UTF_8);
    }
}
