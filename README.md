[English](README.md) | [简体中文](README.zh-CN.md)

# NeoMacros-Docs

The documentation site for
[NeoMacros](https://github.com/tuanzisama/NeoMacros), a client-side
ECMAScript scripting mod for Minecraft (Fabric). Built with
[Docus](https://docus.dev/) (Nuxt 4), bilingual English / 简体中文.

Three content sections per locale (`content/en/`, `content/zh-cn/`). The
folder names carry numeric prefixes (stripped from the routes) so Nuxt
Content's alphabetical navigation order matches the header order
Guide → Examples → API:

| Section | Source |
| --- | --- |
| `1.guide/` | hand-written tutorial pages |
| `2.examples/` | hand-written complete runnable scripts |
| `3.api/` | **generated** from the mod's `doc-api` annotated facade sources (`index.md` is hand-written) |

The generated trees also include the version-compatibility matrix page
(`api/00.version-matrix`) rendered from `@ApiMC` availability annotations.

## API generation pipeline

`builder/` is a standalone Gradle project with two Javadoc doclets that scan
the mod repository's `core` + `ports` facade sources:

- `MDDoclet` — bilingual Markdown pages (`<page>.md` EN + `<page>.zh.md` ZH,
  `@zh` tag translations with per-member English fallback) and the
  version-compatibility matrix (MC versions discovered from the mod's
  `versions/*` Stonecutter nodes)
- `TSDoclet` — `neomacros.d.ts` ambient definitions for editor autocompletion

```bash
# one-time, in the mod repository: publish the annotation jar
cd ../neomacros && ./gradlew :doc-api:publishToMavenLocal

# generate + sync into the site (repo root layout, no site/ subdir)
./gradlew -p builder generateApiDocs
bash scripts/sync-generated-docs.sh
# or: npm run api:generate && npm run api:sync
```

Generated API pages and the `.d.ts` are committed, so the site can be
built without a Java toolchain. Never edit generated API pages by hand —
everything outside `api/index.md` is wiped and re-synced.

Hand-written per-module snippets (`api-examples/<en,zh>/<module>.md`) are
appended to the generated module pages under `## Examples` by the sync
script.

## Development

```bash
npm install
npm run dev        # http://localhost:3300
npm run generate   # static output in .output/public
```

### Keep generated API pages out of your commits

The generated API trees (`3.api/` pages, `server/assets/neomacros.d.ts`)
stay tracked — CI commits their updates and Vercel builds them — but
locally you can hide your sync output from git with skip-worktree:

```bash
bash scripts/skip-generated.sh   # re-run after pulling new generated pages
```

Caveats:

- Pulling overwrites your local regenerated pages with CI's versions —
  re-run `api:sync` if you were working against local mod changes.
- To commit an intentional generated change, undo the flag for that file:
  `git update-index --no-skip-worktree <path>`.
- Inspect flagged files: `git ls-files -v content | grep '^S '`

## CI

`.github/workflows/docs.yml` regenerates the API trees and commits when the
sources change. Triggers: pushes touching pipeline/site paths, manual
dispatch, and the `api-docs` repository dispatch sent by the mod
repository's `docs-dispatch` workflow.

## License

MIT
