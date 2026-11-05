[English](README.md) | [简体中文](README.zh-CN.md)

# NeoMacros-Docs

The documentation site for
[NeoMacros](https://github.com/tuanzisama/NeoMacros), a client-side
ECMAScript scripting mod for Minecraft (Fabric). Built with
[Docus](https://docus.dev/) (Nuxt 4), bilingual English / 简体中文.

Three content sections per locale (`content/en/`, `content/zh-cn/`):

| Section | Source |
| --- | --- |
| `guide/` | hand-written tutorial pages |
| `examples/` | hand-written complete runnable scripts |
| `api/` | **generated** from the mod's `doc-api` annotated facade sources (`index.md` is hand-written) |

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

## CI

`.github/workflows/docs.yml` regenerates the API trees and commits when the
sources change. Triggers: pushes touching pipeline/site paths, manual
dispatch, and the `api-docs` repository dispatch sent by the mod
repository's `docs-dispatch` workflow.

## License

MIT
