---
name: neomacros-api
description: Look up exact NeoMacros API facts — facade modules, classes and
  handles, event names and payloads, availability across Minecraft versions.
  Use when writing or reviewing NeoMacro scripts and you need a member
  signature, an exact camelCase event name, payload fields, version support,
  or the TypeScript definitions. Prevents inventing API members that don't
  exist.
---

# NeoMacros API Lookup

Everything a script can touch hangs off the global `neo` object: 18 facade
modules plus every script-facing class on the same root (`neo.Entity`,
`neo.Pos3D`). The API pages are generated from the annotated mod sources on
every API change, so they match what the running mod exposes — when this
skill and a doc page disagree, trust the page.

Docs root: https://neomacros.tuanzi.ink/en/api/overview
(Chinese: /zh-cn/api/overview). Definitions file for editor autocomplete:
https://neomacros.tuanzi.ink/neomacros.d.ts

## Facade tree (18 modules, by category)

| Category | Facades |
| --- | --- |
| Core | `events` — on/once/waitFor, auto-cleanup · `thread` — timers, ticks, runOnMain · `storage` — per-script persistent KV · `performance` — marks/measures, monotonic clock |
| UI | `chat` — send/log/actionbar · `hud` — persistent text overlays · `command` — client commands, typed arg slots · `render` — world-space wireframes · `screen` — current screen metadata |
| World | `world` — time/dimension/weather/block+chunk queries · `player` — local player as live handle · `entity` — lookup by UUID/type/radius |
| Input | `input` — keybind registration, key listening/injection |
| System | `fs` (perm `fs`) · `net` (perm `net`) · `java` (perm `java`) · `client` — FPS/version, raw entry · `reflect` (perm `java`) |

Facade page URL: `/en/api/modules/<category>/<name>` — e.g.
https://neomacros.tuanzi.ink/en/api/modules/ui/chat,
https://neomacros.tuanzi.ink/en/api/modules/core/events

## Class kinds

Script-visible types come in three kinds, marked by chips on class pages:

- **Handle** — live reference; getters re-query game state per access, a
  vanished entity reads `undefined`. `snapshot()` freezes values into a
  plain record. Examples: `Entity`, `Player`, `FileHandle`.
- **Data** — immutable plain data, JSON-safe (`Pos2D`, `BlockPos`,
  `ItemStack`, `Text`).
- **Record** — plain composite rendered as a field table; signatures and
  event payloads (`EntitySnapshot`, `Pos3D`).

All payloads extend `BaseEvent`. Class index starts at
https://neomacros.tuanzi.ink/en/api/classes/entity ; URL slugs are the
lowercased class name (`/en/api/classes/pos3d`).

## Event catalog

45 client events across nine domains: `chat`, `entity`, `game`, `input`,
`key`, `player`, `screen`, `tick`, `world`. Names are `domain:name`
**camelCase** — `player:attackBlock`, `world:blockUpdate` — with the bare
`tick` the only exception. Each event page lists payload fields and whether
it is cancellable (six are: `key:press`, `chat:send`, `player:attackBlock`,
`player:attackEntity`, `player:interactBlock`, `player:interactEntity`).

Event page URL: lowercase kebab slug, e.g.
https://neomacros.tuanzi.ink/en/api/events/player/player-attackblock
(the slug lowercases the camelCase name). Full catalog with exact names:
`references/event-catalog.zh.md`.

## Version support

One mod build per supported Minecraft version (1.18.2 – 26.3). Every
module and member carries three chips — **NeoMacro** (introducing release),
**Minecraft** (an availability expression: `*`, `>=1.20.6`, `1.18-1.21`,
or exact), **Fabric Loader**; `*` means all. The version matrix evaluates
every expression against every build:
https://neomacros.tuanzi.ink/en/api/version-matrix
When targeting a specific MC version, verify the member's row there before
relying on it.

## Anti-hallucination rules

1. Never invent a `neo.*` member or event name — verify against a facade
   page or `neomacros.d.ts`. If unsure, say so.
2. Event names keep camelCase after the colon; manifests are validated
   against the catalog and typos are rejected at load.
3. Member availability is version-dependent — check the matrix when the
   target MC version matters.
4. Payload classes are `…Event extends BaseEvent` with read-only fields.
5. Gated facades (`fs`, `net`, `command`, `java`, `reflect`,
   `client.minecraft`) need the matching permission granted.

## References (Chinese)

- `references/facades.zh.md` — 18 门面成员速查(中文)
- `references/glossary.zh.md` — 术语表:Handle/Data/Record/载荷/徽章等
- `references/event-catalog.zh.md` — 45 个事件的完整目录(精确驼峰名)
