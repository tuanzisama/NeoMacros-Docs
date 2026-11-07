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

The generated API trees are gitignored — every machine that builds the
site runs the two commands above first (CI does the same before its
build). Never edit generated API pages by hand — everything outside the
hand-written overview and glossary pages is wiped and re-synced.

Hand-written per-module snippets (`api-examples/<en,zh>/<module>.md`) are
appended to the generated module pages under `## Examples` by the sync
script.

## Development

```bash
npm install
npm run dev        # http://localhost:3300
npm run generate   # static output in .output/public
```

### Fresh clones

The generated API content is not in the repository, so a fresh clone has
an empty API section until you run the generation once:

```bash
npm run api:generate && npm run api:sync
```

`npm run dev` and `npm run generate` need the synced trees (and
`server/assets/neomacros.d.ts`) in place. Because the trees are ignored,
regenerated or re-synced output never shows up in `git status` and plain
`git pull` always stays clean — no skip-worktree flags involved.

## CI

`.github/workflows/docs.yml` regenerates the API trees, builds the site,
and deploys the prebuilt static output to Vercel — the generated content
is not committed anywhere. Requires the repository secrets `VERCEL_TOKEN`,
`VERCEL_ORG_ID` and `VERCEL_PROJECT_ID`; the Vercel Git integration is
disconnected, making this workflow the only deploy path. Triggers: pushes
touching pipeline/site paths, manual dispatch, and the `api-docs`
repository dispatch sent by the mod repository's `docs-dispatch`
workflow.

## License

MIT
