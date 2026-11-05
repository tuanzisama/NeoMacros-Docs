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

# The API trees are fully generated (the hand-written overview page is
# tracked as 00.overview.md — a real ordered page, NOT index.md: Nuxt
# Content v3 turns a section folder's index.md into a non-routable
# navigation ghost that 404s the header section links), so stale pages
# from removed generators are wiped first.
find "$site/content/en/3.api" -mindepth 1 -maxdepth 1 ! -name 'index.md' ! -name '00.overview.md' -exec rm -rf {} +
find "$site/content/zh-cn/3.api" -mindepth 1 -maxdepth 1 ! -name 'index.md' ! -name '00.overview.md' -exec rm -rf {} +

# Sidebar titles for the API section root and the generated subtrees
# (Modules/Classes/Events/Types). The section folders carry no index.md
# (Nuxt Content v3 turns a folder's index.md into a non-routable navigation
# ghost that breaks the header section links), so a folder-level
# .navigation.yml is safe here and gives the nav a proper label instead of
# the raw folder name. Module pages are grouped under Modules/ by the
# upstream Category annotation: Core/UI/World/Input/System, matching the
# overview page's facade tables.
write_navigation() {
  local loc="$1"
  local section_title modules_title classes_title events_title types_title
  local core_title ui_title world_title input_title system_title
  if [[ "$loc" == zh-cn ]]; then
    section_title='API 参考' modules_title='模块' classes_title='类' events_title='事件' types_title='类型'
    core_title='核心' ui_title='界面' world_title='世界' input_title='输入' system_title='系统'
  else
    section_title='API Reference' modules_title='Modules' classes_title='Classes' events_title='Events' types_title='Types'
    core_title='Core' ui_title='UI' world_title='World' input_title='Input' system_title='System'
  fi
  local modules="$site/content/$loc/3.api/10.modules"
  mkdir -p "$modules/10.core" "$modules/20.ui" "$modules/30.world" \
    "$modules/40.input" "$modules/50.system" \
    "$site/content/$loc/3.api/20.classes" "$site/content/$loc/3.api/30.events" \
    "$site/content/$loc/3.api/40.types"
  printf 'title: %s\n' "$section_title" > "$site/content/$loc/3.api/.navigation.yml"
  printf 'title: %s\n' "$modules_title" > "$modules/.navigation.yml"
  printf 'title: %s\n' "$core_title"    > "$modules/10.core/.navigation.yml"
  printf 'title: %s\n' "$ui_title"      > "$modules/20.ui/.navigation.yml"
  printf 'title: %s\n' "$world_title"   > "$modules/30.world/.navigation.yml"
  printf 'title: %s\n' "$input_title"   > "$modules/40.input/.navigation.yml"
  printf 'title: %s\n' "$system_title"  > "$modules/50.system/.navigation.yml"
  printf 'title: %s\n' "$classes_title" > "$site/content/$loc/3.api/20.classes/.navigation.yml"
  printf 'title: %s\n' "$events_title"  > "$site/content/$loc/3.api/30.events/.navigation.yml"
  printf 'title: %s\n' "$types_title"   > "$site/content/$loc/3.api/40.types/.navigation.yml"
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

# Facade module order for the sidebar, mirroring the old VitePress config:
# modules first, then Classes, then Events. Numeric prefixes order the
# auto-generated sidebar and are stripped from the routes.
api_modules_order="events thread storage performance chat hud command render world player entity fs net java input client reflect"

module_prefix() {
  local name="$1" i=1 m
  for m in $api_modules_order; do
    if [[ "$m" == "$name" ]]; then
      # Zero-padded so the lexicographic file sort matches numeric order.
      printf '%02d.' "$i"
      return
    fi
    i=$((i + 1))
  done
  printf ''
}

# URL segment for a module's domain group under Modules/, derived from the
# upstream Category annotation on the generated page. Unknown categories
# fall back to a lowercased folder of their own so a new upstream category
# still lands in a working subtree (its label falls back to the raw name
# until write_navigation learns it).
category_dir() {
  local cat
  cat="$(grep -m1 -o '^Category: [A-Za-z-]*' "$1" | cut -d' ' -f2)"
  case "$cat" in
    Core)   printf '10.core' ;;
    UI)     printf '20.ui' ;;
    World)  printf '30.world' ;;
    Input)  printf '40.input' ;;
    System) printf '50.system' ;;
    *)      printf '60.%s' "$(printf '%s' "$cat" | tr '[:upper:]' '[:lower:]')" ;;
  esac
}

# Target path relative to the locale's api/ dir. Class pages are lowercased
# to match the served routes; event slugs gain a per-domain subfolder from
# their first dash segment (e.g. chat-send -> events/chat/); types pages
# (event payload classes) are lowercased like classes; facade module pages
# are grouped under Modules/ by their upstream Category; the generated
# version matrix sits above everything. Needs the source page (arg 2) to
# read the Category line for the Modules grouping.
target_for() {
  local rel="$1" src="$2" dir name
  dir="$(dirname "$rel")"
  if [[ "$dir" == events || "$dir" == events/* ]]; then
    local slug
    slug="$(basename "$rel" .md)"
    printf '30.events/%s/%s.md' "${slug%%-*}" "$slug"
  elif [[ "$dir" == classes || "$dir" == classes/* ]]; then
    printf '20.classes/%s.md' "$(basename "$rel" .md | tr '[:upper:]' '[:lower:]')"
  elif [[ "$dir" == types || "$dir" == types/* ]]; then
    printf '40.types/%s.md' "$(basename "$rel" .md | tr '[:upper:]' '[:lower:]')"
  else
    name="$(basename "$rel" .md)"
    if [[ "$name" == "version-matrix" ]]; then
      printf '00.%s.md' "$name"
    else
      printf '10.modules/%s/%s%s.md' "$(category_dir "$src")" "$(module_prefix "$name")" "$name"
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

write_navigation en
write_navigation zh-cn

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
      strip_html_links "$dest"
      case "$target" in 10.modules/*) fix_module_links "$dest" ;; esac
      append_examples "$dest" "$examples/en/$(basename "$f")"
      ;;
  esac
done < <(find "$gen_md/api" -name '*.md' -type f | sort)
while IFS= read -r f; do
  rel="${f#"$gen_md"/api/}"
  name="$(basename "$f" .zh.md).md"
  # Category lines on the zh pages are translated ("Category: 世界"), so
  # read the grouping from the paired English page instead.
  target="$(target_for "$(dirname "$rel")/$name" "${f%.zh.md}.md")"
  dest="$site/content/zh-cn/3.api/$target"
  mkdir -p "$(dirname "$dest")"
  cp "$f" "$dest"
  strip_html_links "$dest"
  case "$target" in 10.modules/*) fix_module_links "$dest" ;; esac
  append_examples "$dest" "$examples/zh/$name"
done < <(find "$gen_md/api" -name '*.zh.md' -type f | sort)

# Copy the TypeScript definitions into the site and append the types/java
# module supplement (non-facade modules that TSDoclet cannot scan: types
# cells, java module re-exports) to the SITE copy only — appending to the
# generated tree would accumulate the supplement across repeated syncs.
supplement="$examples/types-supplement.d.ts"
cp "$gen_ts/types/neomacros.d.ts" "$site/server/assets/neomacros.d.ts"
if [[ -f "$supplement" ]]; then
  cat "$supplement" >> "$site/server/assets/neomacros.d.ts"
fi

echo "synced $(find "$site/content/en/3.api" -name '*.md' ! -name 'index.md' | wc -l) module page(s) into the site"
