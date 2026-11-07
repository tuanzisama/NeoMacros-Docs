[English](README.md) | [简体中文](README.zh-CN.md)

# NeoMacros-Docs

The documentation site for
[NeoMacros](https://github.com/tuanzisama/NeoMacros), a client-side
ECMAScript scripting mod for Minecraft (Fabric). Built with
[Docus](https://docus.dev/) (Nuxt 4), bilingual English / 简体中文.
Sections: guide, examples, and an API reference generated from the mod's
annotated sources.

## Development

```bash
npm install
npm run dev        # http://localhost:3300
npm run generate   # static output in .output/public
```

The API section is generated and gitignored, so a fresh clone must run
once before dev/build:

```bash
npm run api:generate && npm run api:sync
```

## Agent Skills

The site publishes two AI skills (`neomacros-scripting`, `neomacros-api`)
at `/.well-known/skills/`. Install into any AI tool with:

```bash
npx skills add https://neomacros.tuanzi.ink
```
