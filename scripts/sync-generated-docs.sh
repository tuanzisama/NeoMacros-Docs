#!/usr/bin/env bash
# Copies generated API documentation into the Docus site content tree:
# English pages to content/en/3.api/, Chinese pages to content/zh-cn/3.api/,
# and the TypeScript definitions to server/assets/ (a prerendered server
# route serves them for download; a *.d.ts cannot ship from public/).
# The api/ section folder carries a "3." numeric prefix (stripped from the
# routes) to order the header sections Guide -> Examples -> API, because
# Nuxt Content v3 sorts navigation alphabetically by path. Facade module
# pages are grouped into a Modules/ tree by their upstream Category
# annotation (Core/UI/World/Input/System), mirroring the overview tables;
# module page routes become /api/modules/<domain>/<name>.
#
# Hand-written per-module example snippets (api-examples/
# <locale>/<module>.md) are appended under an "## Examples" heading; pages
# without a matching snippet pass through unchanged.
#
# The API trees are fully generated (only the hand-written index.md is
# tracked), so stale pages from removed generators are wiped first, and the
# sidebar section titles (.navigation.yml) for the API subtree are written
# here as well. Event pages are grouped into per-domain subfolders derived
# from the slug's first dash segment (e.g. chat-send -> events/chat/) so the
# auto-generated sidebar folds them by domain. Relative ".html" links in the
# generated Markdown (MDDoclet emits VitePress-style URLs) are stripped and
# lowercased because Nuxt Content serves clean, lowercased routes.
#
# Usage: bash scripts/sync-generated-docs.sh [gen-md-dir] [gen-ts-dir]
# Defaults match the builder generateApiDocs task outputs.
set -euo pipefail

repo_root="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
gen_md="${1:-$repo_root/builder/build/gen/md}"
gen_ts="${2:-$repo_root/builder/build/gen/ts}"
# This repository hosts the Docus site at its root (no site/ subdirectory).
site="$repo_root"
examples="$site/api-examples"

if [[ ! -d "$gen_md/api" || ! -f "$gen_ts/types/neomacros.d.ts" ]]; then
  echo "generated docs not found; run: ./gradlew -p builder generateApiDocs" >&2
  exit 1
fi

mkdir -p "$site/content/en/3.api" "$site/content/zh-cn/3.api" "$site/server/assets"

# The API trees are fully generated (the hand-written overview and glossary
# pages are tracked as 00.overview.md / 01.glossary.md — real ordered pages,
# NOT index.md: Nuxt Content v3 turns a section folder's index.md into a
# non-routable navigation ghost that 404s the header section links), so
# stale pages from removed generators are wiped first.
find "$site/content/en/3.api" -mindepth 1 -maxdepth 1 ! -name 'index.md' ! -name '00.overview.md' ! -name '01.glossary.md' -exec rm -rf {} +
find "$site/content/zh-cn/3.api" -mindepth 1 -maxdepth 1 ! -name 'index.md' ! -name '00.overview.md' ! -name '01.glossary.md' -exec rm -rf {} +

# Sidebar titles for the API section root and the generated subtrees. The
# section folders carry no index.md (Nuxt Content v3 turns a folder's
# index.md into a non-routable navigation ghost that breaks the header
# section links), so a folder-level .navigation.yml is safe here and gives
# the nav a proper label instead of the raw folder name. Module groups are
# discovered from the generated pages' Category annotations (arg 2: the
# whitespace-separated set); the zh table below is pure display labeling —
# unknown categories fall back to their raw name in both locales.
zh_category_label() {
  case "$1" in
    Core)   printf '核心' ;;
    UI)     printf '界面' ;;
    World)  printf '世界' ;;
    Input)  printf '输入' ;;
    System) printf '系统' ;;
    *)      printf '%s' "$1" ;;
  esac
}

write_navigation() {
  local loc="$1" cats="$2" c lc title
  local section_title modules_title classes_title events_title
  if [[ "$loc" == zh-cn ]]; then
    section_title='API 参考' modules_title='模块' classes_title='类与类型' events_title='事件'
  else
    section_title='API Reference' modules_title='Modules' classes_title='Classes & Types' events_title='Events'
  fi
  local modules="$site/content/$loc/3.api/10.modules"
  mkdir -p "$modules" "$site/content/$loc/3.api/20.classes" "$site/content/$loc/3.api/30.events"
  printf 'title: %s\n' "$section_title" > "$site/content/$loc/3.api/.navigation.yml"
  printf 'title: %s\n' "$modules_title" > "$modules/.navigation.yml"
  printf 'title: %s\n' "$classes_title" > "$site/content/$loc/3.api/20.classes/.navigation.yml"
  printf 'title: %s\n' "$events_title"  > "$site/content/$loc/3.api/30.events/.navigation.yml"
  for c in $cats; do
    lc="$(printf '%s' "$c" | tr '[:upper:]' '[:lower:]')"
    mkdir -p "$modules/$lc"
    if [[ "$loc" == zh-cn ]]; then title="$(zh_category_label "$c")"; else title="$c"; fi
    printf 'title: %s\n' "$title" > "$modules/$lc/.navigation.yml"
  done
}

# Appends the locale's example snippet for one module, when one exists.
append_examples() {
  local dest="$1" fragment="$2"
  if [[ -f "$fragment" ]]; then
    { printf '\n## Examples\n\n'; cat "$fragment"; } >> "$dest"
  fi
}

# MDDoclet emits VitePress-style relative links (Pos3D.html); Nuxt Content
# routes are clean and lowercased, so the suffix is stripped and relative
# targets are lowercased (class pages are synced to lowercased file names).
# Links with a scheme (http://...) are left untouched.
strip_html_links() {
  sed -i -E -e 's/\]\(([^):]*)\.html\)/](\1)/g' \
            -e 's/\]\(([^):]+)\)/](\L\1\E)/g' "$1"
}

# Module pages sort alphabetically inside their domain group — no hardcoded
# module order list; upstream adds/removes modules and the sidebar follows.

# URL segment for a module's domain group under Modules/: the upstream
# Category annotation lowercased, read from the module header component's
# category prop (MDDoclet emits `:api-module-header{category="..." ...}`).
# No hardcoded category list — a new upstream category automatically gets
# its own group (labelled with its raw name until write_navigation's label
# table learns it).
category_dir() {
  local cat
  cat="$(grep -m1 -o 'category="[A-Za-z-]*"' "$1" | cut -d'"' -f2)"
  if [[ -n "$cat" ]]; then
    printf '%s' "$cat" | tr '[:upper:]' '[:lower:]'
  else
    printf 'uncategorized'
  fi
}

# Target path relative to the locale's api/ dir. Class and types pages
# (event payload classes, generated into types/) share one Classes &
# types group, lowercased to match the served routes; event slugs gain a
# per-domain subfolder from their first dash segment (e.g. chat-send ->
# events/chat/); facade module pages are grouped under Modules/ by their
# upstream Category (alphabetical within each group); the generated
# version matrix sits above everything. Needs the source page (arg 2) to
# read the Category line for the Modules grouping.
target_for() {
  local rel="$1" src="$2" dir name
  dir="$(dirname "$rel")"
  if [[ "$dir" == events || "$dir" == events/* ]]; then
    local slug
    slug="$(basename "$rel" .md)"
    printf '30.events/%s/%s.md' "${slug%%-*}" "$slug"
  elif [[ "$dir" == classes* || "$dir" == types* ]]; then
    # Event payload types share the Classes & types group with the handle
    # classes, one lowercased page per name.
    printf '20.classes/%s.md' "$(basename "$rel" .md | tr '[:upper:]' '[:lower:]')"
  else
    name="$(basename "$rel" .md)"
    if [[ "$name" == "version-matrix" ]]; then
      printf '00.%s.md' "$name"
    else
      printf '10.modules/%s/%s.md' "$(category_dir "$src")" "$name"
    fi
  fi
}

# Module pages moved from the api root to Modules/<domain>/<name>.md, two
# levels deeper: lift the generated sibling links (classes/, events/,
# types/) so they keep resolving. Runs after strip_html_links, which has
# already removed the .html suffixes and lowercased the targets.
fix_module_links() {
  sed -E -i 's#]\((classes|events|types)/#](../../\1/#g' "$1"
}

# Event payload links are emitted relative to the old VitePress layout
# (../types/<name>), which never resolved from the events/<domain>/ depth;
# point them at the payload pages' home in Classes & types.
fix_event_links() {
  sed -E -i 's#]\(\.\./types/#](../../classes/#g' "$1"
}

# MDDoclet leads every page with an H1, but the Docus docs layout already
# renders the page title (Content v3 extracts it) — the H1 made every page
# show its title twice. Convert the leading H1 into frontmatter title and
# drop the blank line after it. Generator titles are identifiers/slugs and
# never contain double quotes or backslashes, so plain quoting is safe.
frontmatter_title() {
  local f="$1" title
  [[ "$(head -c 2 "$f")" == "# " ]] || return 0
  title="$(sed '1s/^# //' "$f" | head -n1)"
  printf -- '---\ntitle: "%s"\n---\n\n' "$title" > "$f.tmp"
  sed '1d' "$f" | sed '1{/^$/d}' >> "$f.tmp"
  mv "$f.tmp" "$f"
}

# Discover the upstream Category set from the generated module pages (the
# zh pages translate category names, so scan the English ones). Reads the
# module header component's category prop. Drives the Modules/ domain
# groups and their sidebar labels.
categories="$(for f in "$gen_md"/api/*.md; do
  case "$f" in *.zh.md) continue ;; esac
  grep -m1 -o 'category="[A-Za-z-]*"' "$f" | cut -d'"' -f2
done | sort -u)"

write_navigation en "$categories"
write_navigation zh-cn "$categories"

# English pages keep their name; Chinese pages drop the .zh.md suffix so
# each locale tree maps module name to route identically.
while IFS= read -r f; do
  rel="${f#"$gen_md"/api/}"
  case "$f" in
    *.zh.md) ;;
    *)
      target="$(target_for "$rel" "$f")"
      dest="$site/content/en/3.api/$target"
      mkdir -p "$(dirname "$dest")"
      cp "$f" "$dest"
      frontmatter_title "$dest"
      strip_html_links "$dest"
      case "$target" in
        10.modules/*) fix_module_links "$dest" ;;
        30.events/*)  fix_event_links "$dest" ;;
      esac
      append_examples "$dest" "$examples/en/$(basename "$f")"
      ;;
  esac
done < <(find "$gen_md/api" -name '*.md' -type f | sort)
while IFS= read -r f; do
  rel="${f#"$gen_md"/api/}"
  name="$(basename "$f" .zh.md).md"
  # Category props on the zh pages are translated (category="世界"), so
  # read the grouping from the paired English page instead.
  target="$(target_for "$(dirname "$rel")/$name" "${f%.zh.md}.md")"
  dest="$site/content/zh-cn/3.api/$target"
  mkdir -p "$(dirname "$dest")"
  cp "$f" "$dest"
  frontmatter_title "$dest"
  strip_html_links "$dest"
  case "$target" in
    10.modules/*) fix_module_links "$dest" ;;
    30.events/*)  fix_event_links "$dest" ;;
  esac
  append_examples "$dest" "$examples/zh/$name"
done < <(find "$gen_md/api" -name '*.zh.md' -type f | sort)

# Copy the TypeScript definitions into the site. The generated tree is the
# single source: every script-facing class (including the registerGuestType
# cells) hangs on the NeoRoot interface, so no supplement append is needed.
cp "$gen_ts/types/neomacros.d.ts" "$site/server/assets/neomacros.d.ts"

echo "synced $(find "$site/content/en/3.api" -name '*.md' ! -name 'index.md' | wc -l) module page(s) into the site"
