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
        // Referenced record types, deduplicated by name across modules and
        // standalone classes; a name that already has a class page wins.
        Map<String, ApiModel.TypeModel> referencedTypes = new java.util.TreeMap<>();
        for (ApiModel.ModuleModel module : model.modules()) {
            for (ApiModel.TypeModel type : module.referencedTypes()) {
                if (!classNames.contains(type.name())) {
                    referencedTypes.putIfAbsent(type.name(), type);
                }
            }
        }
        for (ApiModel.TypeModel type : model.standaloneReferencedTypes()) {
            if (!classNames.contains(type.name())) {
                referencedTypes.putIfAbsent(type.name(), type);
                classNames.add(type.name());
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
            for (String direction : List.of("c2s", "s2c", "local")) {
                String face = directionClassName(direction);
                write(typesDir.resolve(face + ".md"), renderDirectionClassPage(direction, false));
                write(typesDir.resolve(face + ".zh.md"), renderDirectionClassPage(direction, true));
            }
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

        // Javadoc-style module header (MDC inline component): pure-data
        // props only; the Vue component supplies all wording in the
        // active locale. The category prop doubles as the sync script's
        // grouping key (it greps category="..." for the Modules/ tree).
        List<String> props = new java.util.ArrayList<>();
        if (!module.category().isEmpty()) {
            props.add(mdcProp("category", categoryLabel(module.category(), zh)));
        }
        props.add(mdcProp("neo-name", "neo." + module.name()));
        props.addAll(availabilityProps(module.since(), module.mc(), module.loader()));
        sb.append(":api-module-header{").append(String.join("", props)).append("}\n\n");

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
        // Javadoc-style declaration block (MDC): plain data as props,
        // inheritance links as markdown slots so the sync script's link
        // rewrites keep applying to them.
        StringBuilder decl = new StringBuilder("::api-declaration{");
        decl.append(mdcProp("kind", switch (clazz.kind()) {
            case HANDLE -> "handle";
            case DATA -> "data";
        }));
        decl.append(mdcProp("name", clazz.name()));
        if (clazz.constructible()) {
            decl.append(mdcProp("ctor", ctorSignature(clazz)));
        }
        if (!clazz.wraps().isEmpty()) {
            decl.append(mdcProp("wraps", clazz.wraps()));
        }
        decl.append("}\n");
        if (!clazz.extendsName().isEmpty()) {
            decl.append("#extends\n[`").append(clazz.extendsName()).append("`](")
                    .append(clazz.extendsName()).append(".html)\n");
        }
        List<String> children = extendedBy.getOrDefault(clazz.name(), List.of());
        if (!children.isEmpty()) {
            decl.append("#extended-by\n").append(joinLinks(children)).append("\n");
        }
        decl.append("::");
        sb.append(decl).append("\n\n");
        renderProperties(sb, clazz.properties(), zh, linkTargets);
        renderMethods(sb, clazz.methods(), zh, linkTargets);
        if (zh && !clazz.zhExample().isEmpty()) {
            sb.append("**Example**\n\n```js\n").append(clazz.zhExample()).append("\n```\n\n");
        }
        return sb.toString();
    }

    /** The script-facing constructor signature shown in the declaration
     * box, e.g. {@code new Pos3D(x: number, y: number, z: number)}. */
    private static String ctorSignature(ApiModel.ClassModel clazz) {
        StringBuilder sb = new StringBuilder("new ").append(clazz.name()).append("(");
        List<ApiModel.ParameterModel> params = clazz.constructorParams();
        for (int i = 0; i < params.size(); i++) {
            ApiModel.ParameterModel parameter = params.get(i);
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(parameter.varargs() ? "..." : "").append(parameter.name())
                    .append(parameter.optional() ? "?" : "").append(": ")
                    .append(parameter.type());
        }
        return sb.append(")").toString();
    }

    /** Renders one referenced record type as its own page under classes/. */
    private static String renderTypePage(ApiModel.TypeModel type, boolean zh) {
        StringBuilder sb = new StringBuilder();
        sb.append(frontmatter(type.name(), zh
                ? "API 签名中引用的 record 类型。"
                : "Record type referenced in API signatures."));
        sb.append("::api-declaration{").append(mdcProp("kind", "record"))
                .append(mdcProp("name", type.name())).append("}\n::\n\n");
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
        // Javadoc-style event header: props carry name/direction/availability,
        // the payload link travels in a markdown slot so the sync script's
        // link rewrites keep applying.
        List<String> props = new java.util.ArrayList<>();
        props.add(mdcProp("event", event.name()));
        props.add(mdcProp("direction", event.direction()));
        if (event.cancellable()) {
            props.add(mdcProp("cancellable", "true"));
        }
        props.addAll(availabilityProps(event.since(), event.mc(), event.loader()));
        sb.append("::api-event-header{").append(String.join("", props)).append("}\n");
        sb.append("#payload\n[`").append(event.className()).append("`](../types/")
                .append(event.className()).append(".html)\n::\n\n");
        sb.append(zh
                ? "**方向**：`" + event.direction() + "` — "
                : "**Direction**: `" + event.direction() + "` — ");
        sb.append(switch (event.direction()) {
            case "c2s" -> (zh ? "客户端上行动作拦截：取消即抑制该动作（按键/聊天/交互）。"
                              : "client-to-server action interception: cancelling suppresses the action.");
            case "s2c" -> (zh ? "服务器下行显示拦截：取消即抑制显示，白名单字段可本地改写。"
                              : "server-to-client display interception: cancelling suppresses the display; whitelisted fields may be rewritten locally.");
            default -> (zh ? "客户端本地状态派生：仅观测，不可取消。"
                           : "client-derived local state; observation only, never cancellable.");
        }).append("\n\n");
        if (!event.fields().isEmpty() || event.cancellable()) {
            sb.append("| Field | Type | Description |\n| --- | --- | --- |\n");
            for (ApiModel.ParameterModel field : event.fields()) {
                String mutableMark = event.mutableFields().contains(field.name())
                        ? " :api-badge{kind=\"writable\"}"
                        : "";
                sb.append("| `").append(field.name()).append("` | ")
                        .append(linkType(field.type(), linkTargets)).append(" | ")
                        .append(fieldDescription(event, field.name(), zh)).append(mutableMark).append(" |\n");
            }
            if (event.cancellable()) {
                sb.append("| `cancelled` | `boolean` | ").append(cancelledFieldDescription(zh)).append(" :api-badge{kind=\"writable\"} |\n");
            }
            sb.append("\n");
        }
        if (event.cancellable()) {
            renderCancelMethod(sb, zh);
        }
        return sb.toString();
    }

    /** The field-table description of the cancellation state on cancellable events. */
    private static String cancelledFieldDescription(boolean zh) {
        return zh ? "取消状态；遵循最后写入优先。"
                  : "Cancellation state; last write wins.";
    }

    /** The method-card description of {@code cancel()} on cancellable events. */
    private static String cancelMethodDescription(boolean zh) {
        return zh ? "取消事件。仅同步通道投递时可用；后续优先级处理器可写入 `cancelled` 恢复分发，取消状态遵循最后写入优先。"
                  : "Cancels the event. Available on synchronous deliveries only; handlers at later"
                       + " priorities may restore delivery by writing `cancelled` (last write wins).";
    }

    /** Appends the {@code cancel()} method card in the class-page method format. */
    private static void renderCancelMethod(StringBuilder sb, boolean zh) {
        sb.append("## Methods\n\n");
        sb.append("::api-method\n\n");
        sb.append("### `cancel()`\n\n");
        sb.append(cancelMethodDescription(zh)).append("\n\n::\n\n");
    }

    /**
     * Renders one event payload class as its own page under types/, with a
     * raised-by link back to its event page. The extends slot names the
     * direction middle class the payload chains through.
     */
    private static String renderEventTypePage(ApiModel.EventModel event, boolean zh,
            Map<String, String> linkTargets) {
        StringBuilder sb = new StringBuilder();
        sb.append(frontmatter(event.className(), text(event.doc(), event.zhDoc(), zh)));
        // Javadoc-style event payload header: the direction class and
        // raised-by links travel in markdown slots; the component renders
        // the extends keyword and localized "Raised by" label around them.
        sb.append("::api-type-header{")
                .append(String.join("", availabilityProps(event.since(), event.mc(), event.loader())))
                .append("}\n");
        String directionFace = directionClassName(event.direction());
        sb.append("#extends\n[`").append(directionFace).append("`](")
                .append(directionFace).append(".html)\n");
        sb.append("#raised-by\n[`").append(event.name()).append("`](")
                .append(eventHref(eventSlug(event.name()))).append(")\n::\n\n");
        if (!event.fields().isEmpty() || event.cancellable()) {
            sb.append("| Field | Type | Description |\n| --- | --- | --- |\n");
            for (ApiModel.ParameterModel field : event.fields()) {
                String mutableMark = event.mutableFields().contains(field.name())
                        ? " :api-badge{kind=\"writable\"}"
                        : "";
                sb.append("| `").append(field.name()).append("` | ")
                        .append(linkType(field.type(), linkTargets)).append(" | ")
                        .append(fieldDescription(event, field.name(), zh)).append(mutableMark).append(" |\n");
            }
            if (event.cancellable()) {
                sb.append("| `cancelled` | `boolean` | ").append(cancelledFieldDescription(zh)).append(" :api-badge{kind=\"writable\"} |\n");
            }
            sb.append("\n");
        }
        if (event.cancellable()) {
            renderCancelMethod(sb, zh);
        }
        return sb.toString();
    }

    /** The guest middle-class name of one traffic direction. */
    private static String directionClassName(String direction) {
        return switch (direction) {
            case "c2s" -> "InputEvent";
            case "s2c" -> "DisplayEvent";
            default -> "StateEvent";
        };
    }

    /** The shared description of one direction middle class. */
    private static String directionClassDoc(String direction, boolean zh) {
        return switch (direction) {
            case "c2s" -> (zh
                    ? "客户端上行事件（c2s）的中间基类：客户端即将做出动作（按键、发送聊天、交互）时触发，可取消。"
                    : "Middle class of client-to-server events (c2s): raised as the client is about to act (key press, chat send, interaction); cancellable.");
            case "s2c" -> (zh
                    ? "服务器下行显示事件（s2c）的中间基类：服务器发来的内容落地前触发，可取消、白名单字段可改写。"
                    : "Middle class of server-to-client display events (s2c): raised before server-originated content lands; cancellable with rewritable whitelisted fields.");
            default -> (zh
                    ? "客户端本地状态事件（local）的中间基类：客户端自行派生或感知的变化，仅观测，永不可取消。"
                    : "Middle class of client-local state events (local): changes the client derives or observes itself; observation only, never cancellable.");
        };
    }

    /** Renders one direction middle class as its own page under types/. */
    private static String renderDirectionClassPage(String direction, boolean zh) {
        String name = directionClassName(direction);
        StringBuilder sb = new StringBuilder();
        sb.append(frontmatter(name, directionClassDoc(direction, zh)));
        sb.append("::api-type-header{mc=\"*\" loader=\"*\"}\n");
        sb.append("#extends\n[`BaseEvent`](BaseEvent.html)\n::\n\n");
        sb.append("| Property | Type | Description |\n| --- | --- | --- |\n");
        sb.append("| `direction` | `'").append(direction).append("'` | ")
                .append(zh ? "本事件的流向字面量。" : "The literal direction of this event family.")
                .append(" |\n");
        sb.append("\n");
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
        sb.append("| `direction` | `'c2s' | 's2c' | 'local'` | ").append(zh ? "事件流向：上行拦截 / 下行显示 / 本地状态。" : "Traffic direction: upstream interception / incoming display / local state.").append(" |\n");
        sb.append("| `timestamp` | `number` | ").append(zh ? "事件分发时的毫秒时间戳。" : "Dispatch time in epoch milliseconds.").append(" |\n");
        sb.append("| `cancellable` | `boolean` | ").append(zh ? "本事件是否可取消。" : "Whether this event is cancellable.").append(" |\n");
        sb.append("\n## Methods\n\n::api-method\n\n### `toJSON()`\n\n");
        sb.append(zh ? "返回事件的普通对象形式，可直接 `JSON.stringify`。"
                     : "Plain-object form of the event so `JSON.stringify` renders it directly.");
        sb.append("\n\n::\n\n");
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

    /** One quoted MDC component prop; values are generator-controlled. */
    static String mdcProp(String key, String value) {
        return " " + key + "=\"" + value + "\"";
    }

    /** since/mc/loader MDC props for one element, skipping absent data. */
    private static List<String> availabilityProps(String since, String mc, String loader) {
        List<String> props = new java.util.ArrayList<>();
        if (since != null) {
            props.add(mdcProp("since", since));
        }
        if (mc != null) {
            props.add(mdcProp("mc", mc));
        }
        if (loader != null) {
            props.add(mdcProp("loader", loader));
        }
        return props;
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
                sb.append(" :api-badge{kind=\"readonly\"}");
            }
            if (property.experimental()) {
                sb.append(" :api-badge{kind=\"experimental\"}");
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
            // One card per method: the ApiMethod MDC block component draws
            // the signature strip and footer, and keeps the h3 a real
            // heading for the TOC and anchor links.
            sb.append("::api-method\n\n");
            // The strip carries the bare method name; parameter detail lives
            // in the table below.
            sb.append("### `").append(method.name()).append("`\n\n");
            sb.append(text(method.doc(), method.zhDoc(), zh)).append("\n\n");
            if (!method.parameters().isEmpty()) {
                sb.append("| ").append(zh ? "参数" : "Parameter")
                        .append(" | ").append(zh ? "类型" : "Type")
                        .append(" | ").append(zh ? "说明" : "Description")
                        .append(" | ").append(zh ? "可选" : "Optional")
                        .append(" | ").append(zh ? "默认" : "Default")
                        .append(" |\n");
                sb.append("| --- | --- | --- | --- | --- |\n");
                for (ApiModel.ParameterModel parameter : method.parameters()) {
                    // Locale convention matches text()/fieldDescription():
                    // the zh view prefers @zh-param and falls back to @param;
                    // the English view never leaks Chinese text.
                    String description = zh
                            ? method.zhParamDocs().getOrDefault(parameter.name(),
                                    method.paramDocs().getOrDefault(parameter.name(), ""))
                            : method.paramDocs().getOrDefault(parameter.name(), "");
                    String defaultValue = method.paramDefaults().get(parameter.name());
                    sb.append("| `").append(parameter.varargs() ? "..." : "")
                            .append(parameter.name()).append("` | ")
                            .append(linkType(parameter.type(), linkTargets)).append(" | ")
                            .append(escapeTableCell(description)).append(" | ")
                            .append(parameter.optional() ? "✓" : "—").append(" | ")
                            .append(defaultValue == null ? "—" : "`" + escapeTableCell(defaultValue) + "`")
                            .append(" |\n");
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
            badges.addAll(availabilityProps(method.since(), method.mc(), method.loader()));
            if (method.permission() != null) {
                badges.add(mdcProp("permission", method.permission()));
            }
            if (method.experimental()) {
                badges.add(mdcProp("experimental", "true"));
            }
            if (!badges.isEmpty()) {
                sb.append(":api-badges{").append(String.join("", badges)).append("}\n\n");
            }
            if (zh && !method.zhExample().isEmpty()) {
                sb.append("**Example**\n\n```js\n").append(method.zhExample()).append("\n```\n\n");
            }
            sb.append("::\n\n");
        }
    }

    /** Escapes pipe characters in table cell content so type unions and
     * prose cannot break the markdown table row. */
    private static String escapeTableCell(String value) {
        return value.replace("|", "\\|");
    }

    /**
     * Wraps known type names in wiki-style links to their pages. The link
     * target map supplies each known name's relative link prefix for the
     * current page context. Unlinked regions stay one code span each so
     * generics like {@code Promise<void>} render verbatim; bare code spans
     * are skipped when nothing links.
     */
    /**
     * Renders one type expression. Types referencing a documented page come
     * out as an {@code :api-type} inline component (ApiType.vue draws the
     * whole expression as a single code capsule with the referenced names
     * clickable inside); plain expressions stay a code span. The refs paths
     * are final, api-root-relative and lowercase — every referenced page
     * (classes and event payloads alike) lives under Classes & types at
     * classes/<lowercase>, and ApiType.vue prepends locale and /api base, so
     * the sync script's markdown-link rewrites don't apply here. Pipes are
     * escaped in the text because the markdown table parser splits cells on
     * unescaped ones.
     */
    private static String linkType(String type, Map<String, String> linkTargets) {
        if (type == null || type.isEmpty()) {
            return "`" + type + "`";
        }
        var matcher = java.util.regex.Pattern.compile("[A-Z][A-Za-z0-9]+").matcher(type);
        StringBuilder refs = new StringBuilder();
        while (matcher.find()) {
            String word = matcher.group();
            if (linkTargets.containsKey(word)) {
                if (refs.length() > 0) {
                    refs.append(',');
                }
                refs.append(word).append("=classes/")
                        .append(word.toLowerCase(java.util.Locale.ROOT));
            }
        }
        if (refs.isEmpty()) {
            return "`" + type + "`";
        }
        // Single-quoted attribute values: type expressions routinely carry
        // double-quoted string literal types (command.arg's Record<"...">),
        // and the remark-mdc lexer ends a quoted value at the first matching
        // quote — no backslash escapes outside bind attributes (the same
        // single-quote trick carries the JSON in :api-version-matrix).
        return ":api-type{text='" + type.replace("|", "\\|") + "' refs='" + refs + "'}";
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
    /** English category label; VersionMatrix reuses it for href computation. */
    static String categoryLabel(String category, boolean zhView) {
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
