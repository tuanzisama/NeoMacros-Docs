package ink.tuanzi.neomacros.docs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Renders the bilingual version-compatibility pages from the same
 * {@link ApiModel} the other renderers consume: a module-to-build matrix
 * over every supported Minecraft version, plus a detail table for the
 * members that carry a specific {@code @ApiMC} availability range (members
 * without a range are available in every build and listed once as such).
 */
final class VersionMatrix {

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
            sb.append("# 版本兼容性\n\n");
            sb.append("每个发布版本为每个受支持的 Minecraft 版本提供独立构建。")
              .append("下表列出每个门面模块在各个构建上的可用性；页面标注为 `*` 的成员")
              .append("在所有列出的构建上均可用。\n\n");
            sb.append("## 模块\n\n");
        } else {
            sb.append("# Version compatibility\n\n");
            sb.append("Every release ships one build per supported Minecraft version. ")
              .append("The tables below map every facade module to the builds it is available on; ")
              .append("a member whose page shows `*` as its MC availability is available in ")
              .append("every listed build.\n\n");
            sb.append("## Modules\n\n");
        }
        sb.append(moduleHeader(versions, zh)).append("\n");
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
            sb.append("| [`").append(module.name()).append("`](").append(module.name())
              .append(".html) | ");
            for (int i = 0; i < versions.size(); i++) {
                String version = versions.get(i);
                if (i > 0) {
                    sb.append(" | ");
                }
                if (memberRanges.isEmpty()) {
                    sb.append(ok(zh));
                } else {
                    long available = memberRanges.stream()
                            .filter(r -> evaluatesTo(r, version)).count();
                    sb.append(available == memberRanges.size()
                            ? ok(zh)
                            : available + "/" + memberRanges.size());
                }
            }
            sb.append(" |\n");
        }
        sb.append("\n");

        List<String[]> constrained = constrainedMembers(model);
        if (zh) {
            sb.append("## 带版本限制的成员\n\n");
            sb.append(constrained.isEmpty()
                    ? "当前没有带具体版本范围的成员——整个 API 在所有受支持的版本上都可用。\n"
                    : "以下成员带有具体的可用版本范围；其余 API 成员在所有受支持的版本上都可用。\n\n");
        } else {
            sb.append("## Version-constrained members\n\n");
            sb.append(constrained.isEmpty()
                    ? "No member carries a specific availability range — the whole API is "
                            + "available on every supported version.\n"
                    : "These members carry a specific availability range; every other member "
                            + "of the API is available on all supported versions.\n\n");
        }
        if (!constrained.isEmpty()) {
            sb.append(memberHeader(versions, zh)).append("\n");
            for (String[] row : constrained) {
                sb.append("| `").append(row[0]).append("` | `").append(row[1]).append("` | `")
                  .append(row[2]).append("` | ");
                for (String version : versions) {
                    sb.append(evaluatesTo(row[2], version) ? ok(zh) : "\u2014").append(" | ");
                }
                sb.append("\n");
            }
        }
        return sb.toString();
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

    private static String ok(boolean zh) {
        return "\u2713";
    }

    /** Table header for the module rows: Module + one column per version. */
    private static String moduleHeader(List<String> versions, boolean zh) {
        StringBuilder sb = new StringBuilder();
        sb.append("| ").append(zh ? "模块" : "Module").append(" | ");
        sb.append(joinVersionColumns(versions));
        sb.append(" |\n| --- | ");
        sb.append(joinSeparators(versions));
        sb.append(" |\n");
        return sb.toString();
    }

    /** Table header for the member rows: Module | Member | Range + versions. */
    private static String memberHeader(List<String> versions, boolean zh) {
        StringBuilder sb = new StringBuilder();
        sb.append("| ").append(zh ? "模块" : "Module").append(" | ");
        sb.append(zh ? "成员" : "Member").append(" | ");
        sb.append(zh ? "范围" : "Range").append(" | ");
        sb.append(joinVersionColumns(versions));
        sb.append(" |\n| --- | --- | --- | ");
        sb.append(joinSeparators(versions));
        sb.append(" |\n");
        return sb.toString();
    }

    private static String joinVersionColumns(List<String> versions) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < versions.size(); i++) {
            sb.append(versions.get(i));
            if (i < versions.size() - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    private static String joinSeparators(List<String> versions) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < versions.size(); i++) {
            sb.append("---");
            if (i < versions.size() - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
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
