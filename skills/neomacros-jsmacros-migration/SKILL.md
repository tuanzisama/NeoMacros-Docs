---
name: neomacros-jsmacros-migration
description: Migrate JsMacros scripts to native NeoMacros without the compat
  layer. Use when rewriting or porting JsMacros .js scripts — JsMacros.on
  events, Player/World/Chat/Client/FS/GlobalVars globals — into NeoMacros
  folder scripts: neomacro.yml manifests, startup exports, neo.* facades,
  camelCase domain:name events, async I/O, and permission declarations.
---

# JsMacros → NeoMacros (native rewrite)

JsMacros and NeoMacros scripts share the language — plain ES modules — not
the API. This skill covers the direct rewrite against `neo.*`, with no
compat layer involved. (The site's migration page also documents an
optional compat layer for running old code unchanged; treat that as a
separate, temporary path — this skill is the durable one.)

Migration page: https://neomacros.tuanzi.ink/en/migration/migrating-from-jsmacros

## The five transformations

### 1. Script layout: flat file → manifest folder

JsMacros executes every `.js` file in its scripts folder. NeoMacros loads
one folder per script under a trigger-type directory, with a
`neomacro.yml` manifest and an entry file:

```text
config/NeoMacros/macros/        # data dir follows the mod display name
├── event/<name>/               # fires on declared events
│   ├── neomacro.yml
│   └── index.js
├── services/<name>/            # starts once, runs for the session
└── keypress/<name>/            # fires on a key edge
```

Manifest (required: `name`, `version`, `author`):

```yaml
name: health-warn
version: 1.0.0
author: you

config:
  event:
    on: [player:health]     # validated at load; camelCase, domain-prefixed
```

The entry file exports `startup(payload)` (async ok) and optionally
`dispose()`:

```js
const { chat } = neo;

export function startup(payload) {
    if (payload.health <= 6) chat.actionbar('low health!');
}
```

Routing: a top-level `JsMacros.on(...)` session-lifetime script →
`services/`; a script that wakes on declared events → `event/`; a keybind
script → `keypress/` with `key_code` (the initial binding is a suggestion,
not a lock).

### 2. Globals → `neo.*` facades

Destructure from the global `neo` object — no imports. Full table in
`references/facade-map.zh.md`; the core:

| JsMacros | NeoMacros | Notes |
| --- | --- | --- |
| `JsMacros.on/once/off/waitForEvent` | `events.on/once/off/waitFor` | see transformation 3 |
| `Chat` | `chat` | plus `title` / `toast` |
| `Player` | `player` | `player.self` may be `undefined` outside a world |
| `World` | `world` | |
| `Client` | `client` | |
| `KeyBind` | `input` | |
| `Inventory` | `player.inventory` | `items` is `Record<number, ItemStack>` |
| `Hud` (Draw2D/Draw3D) | `hud` + `render` | plus `hud.texture` registry |
| `FS` | `fs` | natively async — `await` each call |
| `GlobalVars` | `storage` | JSON-serializable values only |
| `Request` | `net` | fetch semantics |
| `Reflection` / `JavaUtils` / `JavaWrapper` | `java` + `reflect` | java permission |
| `Time.sleep(ms)` | `thread.sleep(ms)` | `Time.time()` is `Date.now()` |
| `PositionCommon` | `Pos3D` and friends | |
| `Color` | plain ARGB integers | |

### 3. Events: UPPER_SNAKE → camelCase `domain:name`

```js
// JsMacros
JsMacros.on('HealthChange', (event, context) => {
    Chat.actionbar(`hp ${event.health}`);
});
```

```js
// NeoMacros — declared style (manifest config.event.on) calls startup:
export function startup(payload) {
    chat.actionbar(`hp ${payload.health}`);
}

// or manual style for multiple/dynamic subscriptions:
events.on('player:health', (payload) => {
    chat.actionbar(`hp ${payload.health}`);
});
```

Rules:

- Names are `domain:name` camelCase — `player:health`, `world:blockUpdate`,
  `input:keyPress`. Legacy `UPPER_SNAKE` (`HEALTH_CHANGE`, `TICK`) does
  not exist natively. The full 36-event map is in
  `references/event-map.zh.md`.
- Callbacks receive **one frozen payload object** — the
  `(event, context)` pair is gone; payload fields differ from JsMacros
  shapes, so read fields from the event page, never assume.
- Cancel and rewrite run on `events.onSync` (dispatch thread, keep it
  short): `e.cancel()` vetoes, the writable `e.cancelled` accessor
  reflects state, and whitelisted payload fields are rewritten in place —
  return values are ignored. Whether an event accepts this is its
  **direction and cancellable flag on the event page**: `c2s` events
  (client about to act — `input:keyPress`, `chat:send`,
  `player:attackBlock/attackEntity/interactBlock/interactEntity`) and
  cancellable `s2c` events (`chat:title`, `screen:signEdit`, …) take
  onSync; `local` events (tick, vitals, world, screen transitions,
  `input:wheel`) are observation only. Check the event page before
  assuming.
- One-shot helpers: `events.once`, `events.waitFor`,
  `events.waitForUntil(name, filter, timeoutMillis)`.
- Wildcard `ANYTHING` → `*` or `domain:*`; `tick`, `world:sound`, and
  `world:blockUpdate` are excluded from wildcard dispatch by default.
- Custom events: `events.register('ns:name')` then `events.emit(...)` —
  payload keys must avoid `type`, `timestamp`, `cancellable`,
  `direction`.

### 4. Sync → async

NeoMacros is async-first. These surfaces return promises where JsMacros
was synchronous — each call site needs its own `await`:

| JsMacros | NeoMacros |
| --- | --- |
| `FS.*` (all file access) | `await fs.*` per call |
| `Request.get/post` | `await net.fetch/get/post` |
| `Time.sleep(ms)` | `await thread.sleep(ms)` |
| `Client.waitTick([n])` | `await thread.nextTick()` / `thread.ticks(n)` |
| `Client.runOnMainThread(fn)` | `await thread.runOnMain(fn)` |
| inventory click/drop/swap actions | `await` each |

The classic trap: an un-awaited `fs.exists(p)` inside an `if` is always
truthy — the branch tests the promise object, not the file. Migrate call
sites one at a time, not with batch find-and-replace.

Game state (world, entities, player) belongs on the main thread — wrap
reads and writes in `thread.runOnMain`.

### 5. Permissions and trust

Base surface (events, timers, chat output, world/player reads, HUD/render,
`storage`) needs nothing. Gated capabilities are declared in the manifest
and granted once per content hash:

```yaml
permissions: ["fs"]     # fs | net | command | java
```

`/neomacros trust <name>` grants; any edit changes the hash and re-opens
the prompt. Denied calls throw at the exact call site and show in
`/neomacros errors`.

## Before / after

JsMacros (one flat file):

```js
JsMacros.on('HealthChange', (event) => {
    if (event.health <= 6) Chat.actionbar('low health!');
});

if (GlobalVars.getBoolean('greet') !== false) {
    Chat.log('hello');
}
```

NeoMacros — `macros/event/health-warn/neomacro.yml`:

```yaml
name: health-warn
version: 1.0.0
author: you

config:
  event:
    on: [player:health]
```

and `index.js`:

```js
const { chat, storage } = neo;

const greet = storage.get('greet') ?? true;
if (greet) chat.log('hello');

export function startup(payload) {
    if (payload.health <= 6) chat.actionbar('low health!');
}
```

## The 19 events the compat layer doesn't bridge

For a direct rewrite most of these have native paths — several entries
below are stale compat conclusions (`Riding`, `ArmorChange`, and the
inventory family gained native events after the pack shipped). The rest
need a redesign:

| JsMacros | Native path |
| --- | --- |
| `RecvPacket` / `SendPacket` | `packet:receive` / `packet:send` events + `client.createPacketBuffer` / `sendPacket` |
| `Title` | `chat:title` + `chat:actionbar` |
| `SignEdit` | `screen:signEdit` |
| `ClickSlot` / `DropSlot` / `OpenContainer` / `ContainerUpdate` / `SlotUpdate` | `inventory:click` / `inventory:open` / `inventory:close` / `inventory:update` (observation only, never cancellable) |
| `Riding` | `player:riding` (`vehicle` snapshot, `null` on dismount) |
| `ArmorChange` | `player:armor` |
| `NameChange`, `ItemPickup`, `ItemDamage`, `ResourcePackLoaded`, `ProfileLoad` | no native equivalent — drop or redesign |
| `WrappedScript`, `Service`, `CommandContext` | internal JsMacros concepts; script lifecycle and client commands are native (`startup`/`dispose`, `command` facade) |

## Verification loop

1. `/neomacros reload` → `/neomacros list` — the folder appears; a
   rejection reason lands in `/neomacros errors`.
2. Event names checked against the catalog — casing and domain prefix
   included (`input:keyPress`, not `Key`).
3. `player.self` and entity handles guarded against `undefined`.
4. Every loop yields with `await`; game state only via `runOnMain`.
5. Declared `permissions` match what the code calls; re-trusted after
   edits.

## References (Chinese)

- `references/event-map.zh.md` — 36 个 JsMacros 事件的精确映射、不支持事件与原生替代、旧 UPPER_SNAKE 别名
- `references/facade-map.zh.md` — 全局 → 门面对照、形态变化、异步面清单
- `references/layout-and-pitfalls.zh.md` — 目录与清单迁移、权限信任、常见陷阱

## Doc map

- Migration guide: https://neomacros.tuanzi.ink/en/migration/migrating-from-jsmacros
- Getting started: https://neomacros.tuanzi.ink/en/guide/getting-started
- Events: https://neomacros.tuanzi.ink/en/guide/events
- API reference: https://neomacros.tuanzi.ink/en/api/overview
- TypeScript definitions: https://neomacros.tuanzi.ink/neomacros.d.ts
