package ink.tuanzi.neomacros.docs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Renders the bilingual version-compatibility pages from the same
 * {@link ApiModel} the other renderers consume. Both tables are emitted as
 * one {@code :api-version-matrix} MDC leaf component per section, fed with
 * a compact JSON payload ({@code section} + {@code data}); the Vue side
 * renders the tables (sticky first column, horizontal scroll) and localizes
 * all wording, so both locale pages share one body. The module grid carries
 * a per-build availability
 * cell ("all" or "n/m" members); the constrained-member section lists the
 * members with a specific {@code @ApiMC} availability range.
 */
final class VersionMatrix {

    /** Compact, non-HTML-escaping JSON for the single-quoted MDC data prop. */
    private static final Gson GSON = new GsonBuilder().disableHtmlEscaping().create();

    private VersionMatrix() {
    }

    /**
     * Writes {@code version-matrix.md} and {@code version-matrix.zh.md} into
     * {@code apiDir}. The version list must be in ascending release order,
     * mirroring the mod build's Stonecutter nodes.
     */
    static void write(Path apiDir, ApiModel model, List<String> versions) throws IOException {
        writePage(apiDir.resolve("version-matrix.md"), render(model, versions, false));
        writePage(apiDir.resolve("version-matrix.zh.md"), render(model, versions, true));
    }

    private static String render(ApiModel model, List<String> versions, boolean zh) {
        StringBuilder sb = new StringBuilder();
        if (zh) {
            sb.append(MDDoclet.frontmatter("版本兼容性",
                    "每个发布版本为每个受支持的 Minecraft 版本提供独立构建。下表列出每个门面模块在各个构建上的可用性；页面标注为 `*` 的成员在所有列出的构建上均可用。"));
            sb.append("## 模块\n\n");
        } else {
            sb.append(MDDoclet.frontmatter("Version compatibility",
                    "Every release ships one build per supported Minecraft version. "
                    + "The tables below map every facade module to the builds it is available on; "
                    + "a member whose page shows `*` as its MC availability is available in "
                    + "every listed build."));
            sb.append("## Modules\n\n");
        }
        String data = GSON.toJson(matrixData(model, versions));
        // MDC attributes live inside braces; the JSON travels in a
        // single-quoted prop value (its double quotes are safe inside
        // single quotes, and the payload — identifiers, version numbers —
        // never contains one). The braces around the value terminate the
        // attribute list; braces inside the quoted value are plain data.
        sb.append(":api-version-matrix{").append(MDDoclet.mdcProp("section", "modules"))
          .append(" data='").append(data).append("'}\n\n");
        sb.append(zh ? "## 带版本限制的成员\n\n" : "## Version-constrained members\n\n");
        sb.append(":api-version-matrix{").append(MDDoclet.mdcProp("section", "constrained"))
          .append(" data='").append(data).append("'}\n\n");
        return sb.toString();
    }

    /** One matrix payload shared by both component instances on the page. */
    private static JsonObject matrixData(ApiModel model, List<String> versions) {
        JsonObject data = new JsonObject();
        JsonArray versionArray = new JsonArray();
        versions.forEach(versionArray::add);
        data.add("versions", versionArray);

        JsonArray modules = new JsonArray();
        for (ApiModel.ModuleModel module : model.modules()) {
            List<String> memberRanges = new ArrayList<>();
            for (ApiModel.PropertyModel property : module.properties()) {
                memberRanges.add(range(property.mc()));
            }
            for (ApiModel.MethodModel method : module.methods()) {
                memberRanges.add(range(method.mc()));
            }
            for (ApiModel.ClassModel clazz : module.classes()) {
                for (ApiModel.PropertyModel property : clazz.properties()) {
                    memberRanges.add(range(property.mc()));
                }
                for (ApiModel.MethodModel method : clazz.methods()) {
                    memberRanges.add(range(method.mc()));
                }
            }
            JsonObject row = new JsonObject();
            row.addProperty("name", module.name());
            // The sync script moves module pages to Modules/<domain>/<name>,
            // so emit the post-move relative href directly (domainDir mirrors
            // the script's category_dir rule, see below).
            row.addProperty("href", "modules/" + domainDir(module.category()) + "/" + module.name());
            JsonArray cells = new JsonArray();
            for (String version : versions) {
                if (memberRanges.isEmpty()) {
                    cells.add("all");
                } else {
                    long available = memberRanges.stream()
                            .filter(r -> evaluatesTo(r, version)).count();
                    cells.add(available == memberRanges.size()
                            ? "all"
                            : available + "/" + memberRanges.size());
                }
            }
            row.add("cells", cells);
            modules.add(row);
        }
        data.add("modules", modules);

        JsonArray constrained = new JsonArray();
        for (String[] entry : constrainedMembers(model)) {
            JsonObject row = new JsonObject();
            row.addProperty("module", entry[0]);
            row.addProperty("member", entry[1]);
            row.addProperty("range", entry[2]);
            JsonArray cells = new JsonArray();
            for (String version : versions) {
                cells.add(evaluatesTo(entry[2], version));
            }
            row.add("cells", cells);
            constrained.add(row);
        }
        data.add("constrained", constrained);
        return data;
    }

    /**
     * URL segment for a module's domain group. Raw {@code @ApiModule}
     * categories are zh-first, so map to the English label first (the same
     * table the module pages display), then mirror the sync script's
     * category_dir: keep [A-Za-z-], lowercase, unknown falls back to the
     * shared "uncategorized" segment.
     */
    private static String domainDir(String category) {
        String label = MDDoclet.categoryLabel(category == null ? "" : category, false);
        String cleaned = label.replaceAll("[^A-Za-z-]", "");
        return cleaned.isEmpty() ? "uncategorized" : cleaned.toLowerCase(Locale.ROOT);
    }

    /**
     * Collects the members with a non-wildcard MC range as
     * {@code [module, member, range]} rows in stable model order. Class
     * members are qualified with their class name.
     */
    private static List<String[]> constrainedMembers(ApiModel model) {
        List<String[]> rows = new ArrayList<>();
        for (ApiModel.ModuleModel module : model.modules()) {
            for (ApiModel.PropertyModel property : module.properties()) {
                if (isConstrained(property.mc())) {
                    rows.add(new String[]{module.name(), property.name(), property.mc()});
                }
            }
            for (ApiModel.MethodModel method : module.methods()) {
                if (isConstrained(method.mc())) {
                    rows.add(new String[]{module.name(),
                            method.name() + "(" + method.parameters().size() + ")", method.mc()});
                }
            }
            for (ApiModel.ClassModel clazz : module.classes()) {
                for (ApiModel.PropertyModel property : clazz.properties()) {
                    if (isConstrained(property.mc())) {
                        rows.add(new String[]{module.name(),
                                clazz.name() + "." + property.name(), property.mc()});
                    }
                }
                for (ApiModel.MethodModel method : clazz.methods()) {
                    if (isConstrained(method.mc())) {
                        rows.add(new String[]{module.name(),
                                clazz.name() + "." + method.name() + "("
                                        + method.parameters().size() + ")", method.mc()});
                    }
                }
            }
        }
        return rows;
    }

    private static boolean isConstrained(String mc) {
        return mc != null && !mc.isBlank() && !mc.equals("*");
    }

    /** Normalizes a member's MC annotation value to an expression string. */
    private static String range(String mc) {
        return mc == null || mc.isBlank() ? "*" : mc;
    }

    /**
     * Evaluates one {@code @ApiMC} availability expression against one
     * version. Supported forms: {@code *}, a comparison ({@code >=1.20.6}),
     * an inclusive range ({@code 1.18-1.21}), and an exact version. Version
     * segments compare numerically; a shorter version pads with zeros.
     */
    static boolean evaluatesTo(String expression, String version) {
        String expr = expression.trim();
        if (expr.isEmpty() || expr.equals("*")) {
            return true;
        }
        for (String op : List.of(">=", "<=", ">", "<")) {
            if (expr.startsWith(op)) {
                int cmp = compare(version, expr.substring(op.length()).trim());
                return switch (op) {
                    case ">=" -> cmp >= 0;
                    case "<=" -> cmp <= 0;
                    case ">" -> cmp > 0;
                    default -> cmp < 0;
                };
            }
        }
        int dash = expr.indexOf('-');
        if (dash > 0 && dash < expr.length() - 1) {
            return compare(version, expr.substring(0, dash).trim()) >= 0
                    && compare(version, expr.substring(dash + 1).trim()) <= 0;
        }
        return compare(version, expr) == 0;
    }

    /** Segment-wise numeric version comparison; missing segments count as zero. */
    private static int compare(String left, String right) {
        String[] a = left.trim().split("\\.");
        String[] b = right.trim().split("\\.");
        int length = Math.max(a.length, b.length);
        for (int i = 0; i < length; i++) {
            int x = segment(a, i);
            int y = segment(b, i);
            if (x != y) {
                return Integer.compare(x, y);
            }
        }
        return 0;
    }

    private static int segment(String[] parts, int index) {
        if (index >= parts.length) {
            return 0;
        }
        try {
            return Integer.parseInt(parts[index].trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static void writePage(Path file, String content) throws IOException {
        Files.createDirectories(file.getParent());
        Files.writeString(file, content, StandardCharsets.UTF_8);
    }
}
