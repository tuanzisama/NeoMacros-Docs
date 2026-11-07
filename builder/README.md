[English](README.md) | [简体中文](README.zh-CN.md)

# builder

A standalone Gradle build. Generates the script API documentation from the
`doc-api` annotations (coordinates `ink.tuanzi.neomacros:doc-api`, resolved
from the local repository) and their Javadoc (including the `@zh` bilingual
tags) of the [NeoMacros mod repository](https://github.com/tuanzisama/NeoMacros):

- `api/<page>.md` — English page (the normative source)
- `api/<page>.zh.md` — Chinese page, translated via `@zh` tags with
  per-member English fallback
- `api/version-matrix.md` / `.zh.md` — version-compatibility matrix:
  module × MC version availability table plus a detail table for members
  carrying an `@ApiMC` range; MC versions are discovered from the mod
  repository's `versions/*` Stonecutter nodes (ascending)
- `api/warnings.txt` — generation warnings (missing `@zh`, missing `@ApiSince`)
- `types/neomacros.d.ts` — the global-scope definitions (module facades,
  root-level classes, and the `declare const neo` aggregate)

Markdown and `.d.ts` consume the same `ApiModel` (the annotation-scan
product). Generated artifacts must not be hand-edited; snapshot baselines
under `src/test/snapshots/` are updated only after a human reviews the diff.

## Usage

```bash
# one-time, in the mod repository: publish the annotation jar locally
./gradlew :doc-api:publishToMavenLocal

# generate from the real facade sources (core + ports), no snapshot
# assertions; outputs land in build/gen/{md/api,ts/types}/
./gradlew -p builder generateApiDocs

# generate + snapshot regression + TypeScript compile check
./gradlew -p builder check -PtscPath=<typescript package bin/tsc path>
```

The scanned mod repository defaults to a sibling checkout (`../neomacros`);
other layouts can override with `-PneomacrosRoot=<path>` or the
`NEOMACROS_ROOT` environment variable. `-PtscPath` points at the
typescript package's `tsc` JS file (executed through node); the compile
check is skipped when not provided.

The toolchain is JVM 25 (the same JDK the mod build's Gradle daemon uses);
CI provides it via `actions/setup-java`.

## Layout

```
src/main/java/ink/tuanzi/neomacros/docs/
├── ApiModel.java        # renderer-shared model (modules/members/handles/events/warnings)
├── ModelExtractor.java  # DocletEnvironment → ApiModel, deterministic ordering
├── DocletSupport.java   # Javadoc flattening, @zh tag extraction, Java→TS type mapping
├── MDDoclet.java        # bilingual Markdown rendering (with -mc-versions matrix switch)
├── VersionMatrix.java   # version-compatibility pages (@ApiMC evaluation, bilingual)
├── TSDoclet.java        # TypeScript ambient definition rendering
├── NpmTypesPackager.java# npm-package form of the type definitions
└── ApiDocsGenerate.java # CLI entry (optional 5th arg: comma-separated MC versions)
```
