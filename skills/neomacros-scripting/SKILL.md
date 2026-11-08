---
name: neomacros-scripting
description: Write scripts for NeoMacros, the client-side Fabric mod that runs
  ECMAScript in Minecraft. Use when creating, editing, or debugging
  NeoMacro scripts — manifests (neomacro.yml), event handlers, timers and
  threading, persistent storage, HUD text, world rendering, client commands,
  permissions/trust, or Java interop. Covers the scripting model, the
  `neo.*` facade patterns, and common failure modes.
---

# NeoMacros Scripting

NeoMacros runs ordinary `.js` ES modules inside Minecraft via GraalJS: real
promises, `async`/`await`, and a dedicated event loop per script. No build
step — folders under `config/neomacros/macros/` are the deployment unit.

Detailed guides (Chinese): see `references/`. Full reference:
https://neomacros.tuanzi.ink/en/guide/getting-started — TypeScript users can
drop https://neomacros.tuanzi.ink/neomacros.d.ts next to their scripts for
editor autocompletion.

## Folder layout and the manifest

One folder per script, under the category folder that decides its trigger:

```text
config/neomacros/
├── config.json        # mod settings, including trust decisions
└── macros/
    ├── keypress/<name>/   # fires on a key edge
    ├── event/<name>/      # fires on declared game events
    └── services/<name>/   # starts once, keeps itself alive
```

Each folder holds `neomacro.yml` (or `neomacro.json`; a sibling `.yml` wins)
plus its entry file (default `index.js`). Required identity fields: `name`,
`version`, `author`. Behavior lives in the `config:` block — legacy
top-level fields (`key`, `lifecycle`, `autostart`, `events`) are rejected.

Event macro:

```yaml
name: hello
version: 1.0.0
author: you
description: greets you when you join a world
permissions: ["fs"]          # optional; only what gated APIs need

config:
  event:
    on: [world:join]         # validated at load; typos are rejected
```

Keypress macro:

```yaml
config:
  keypress:
    on: keydown              # keydown / keyup / keypress (default)
    key_code: key.keyboard.j
    modifiers: [ctrl]        # optional: ctrl / shift / alt
```

Entry file exports `startup(payload)` (required, async supported) and
optionally `dispose()` for teardown beyond auto-cleaned subscriptions:

```js
const { chat } = neo;

export function startup(payload) {
    chat.log('Hello!');
}
```

Management loop: edit → `/neomacros reload` → `/neomacros list`, errors in
`/neomacros errors`.

## Core patterns

Everything hangs off the global `neo` object — no imports.

### Events

```js
const { events, chat } = neo;

const handle = events.on('player:health', (payload) => {
    chat.actionbar(`health: ${payload.health}`);
});
events.off(handle);                       // or events.off('player:health')

await events.waitForUntil('player:health', (p) => p.health < 6, 30000);
```

- Names are `domain:name` camelCase (`chat:receive`, `world:blockUpdate`,
  `player:attackBlock`); the bare built-in `tick` is the only exception.
- Wildcards `domain:*` and `*` exist, but `tick`, `world:sound`, and
  `world:blockUpdate` are excluded from wildcard dispatch.
- High-frequency events need an early-return guard (see Threading below).
- Custom events: `events.register('myscript:burst')`, then
  `events.emit(...)`; payload keys must avoid `type`, `timestamp`,
  `cancellable`.

### Threading

Every script owns an event loop. Awaiting never blocks the game; blocking
it synchronously stalls your own timers and handlers.

```js
const { thread } = neo;

await thread.sleep(1000);     // wall-clock ms
await thread.ticks(20);       // client tick boundaries
const health = await thread.runOnMain(() => neo.player.self?.health);
const beat = thread.every(5000, () => {});
beat.cancel();                // also: after, afterTick, everyTick, nextTick
```

Rule of thumb: compute and wait on the script loop; touch game state only
inside `thread.runOnMain`; yield every loop iteration with an `await`.

### Storage

Per-script isolated, JSON-only, survives reload and restarts.

```js
const { storage } = neo;

const DEFAULTS = { welcome: true, warnHealth: 6 };
const settings = { ...DEFAULTS, ...(storage.get('settings') ?? {}) };
storage.put('settings', settings);

storage.put('lastPos', { x: p.x, y: p.y, z: p.z });  // fields, not handles
```

Live handles, class instances, and functions fail `put`; `null` deletes.

### Chat, HUD, world rendering

```js
const { chat, hud, render, player } = neo;

chat.log('local line');  chat.actionbar('above hotbar');

hud.addText('coords', text, 8, 8, 0xFFFFFFFF);   // ARGB int; same id replaces
hud.removeText('coords');

const base = player.self?.pos?.floor();
if (base) render.drawBox('marker', base, base.withY(base.y + 1), 0xFF00FF00);
render.clearLayer('marker');
```

Entries persist across frames until removed or the script unloads. Update
HUD from a guarded `tick` subscription (e.g. every 10 ticks), not per frame.

### Client commands (permission-gated)

```js
const { command } = neo;

export function startup() {          // put in a services script
    command.register({
        name: 'greet',
        description: 'Greets someone, N times',
        args: {
            target: command.arg.player(),
            times: command.arg.int().defaultTo(1),   // defaultTo, not default
            note: command.arg.greedy().optional(),
        },
        handler(ctx) { /* ctx.args.times, ctx.raw */ },
    });
}
```

Slot kinds: `int`, `float`, `bool`, `word`, `string`, `greedy` (last),
`player`, `pos`. Needs the `command` permission plus `/neomacros trust`.

### Permissions and trust

Base surface is always allowed: events, timers, chat output, world/player
reads, HUD and render, `neo.storage`. Gated (declared in manifest
`permissions`, granted via `/neomacros trust <script>`):

| Permission | Unlocks |
| --- | --- |
| `fs` | `neo.fs` (sandboxed to the game directory) |
| `net` | `neo.net` fetch/get/post |
| `command` | `neo.command.register` / `execute` |
| `java` | `neo.java`, `neo.reflect`, `neo.client.minecraft` — full host access, highest trust |

Trust is keyed to the script's content hash: any edit requires re-trust.
Denied calls throw at runtime and show in `/neomacros errors`.

### Java interop (permission-gated, last resort)

```js
const { java, reflect, thread } = neo;

const UUID = java.type('java.util.UUID');       // Mojmap names for MC classes
const list = java.toList(['a', 'b']);           // toList/fromList/toArray
const m = reflect.method(target, 'getSender', ['int']);   // exact overload
const mc = neo.client.minecraft;                // raw client object proxy
```

Wrap reads/writes of game state in `thread.runOnMain`.

## Failure modes to check first

1. Script missing from `/neomacros list` → manifest rejected: typo'd event
   name, missing `domain:` prefix, legacy top-level fields, or missing
   `name`/`version`/`author`. Reason shown in `/neomacros errors`.
2. Denied-call error right after an edit → content hash changed;
   re-run `/neomacros trust <script>`.
3. Crash on property read → guard `player.self` and entity handles
   against `undefined` (no world, or entity gone).
4. Script freezes its own timers → a loop without `await`; yield with
   `thread.ticks`/`sleep`, and keep game state reads in `runOnMain`.
5. `storage.put` throws → value is not plain JSON; test with
   `JSON.stringify`.

## References (Chinese)

- `references/manifest-and-scripts.zh.md` — 清单字段、三类脚本、生命周期
- `references/events.zh.md` — 事件订阅、onSync 取消、自定义事件
- `references/threading-and-storage.zh.md` — 线程模型与持久化存储
- `references/hud-render-commands.zh.md` — HUD、世界渲染、客户端命令
- `references/permissions-and-java.zh.md` — 权限信任体系与 Java 互操作
- `references/pitfalls.zh.md` — 常见失败模式与排查清单

## Doc map

- Guide: https://neomacros.tuanzi.ink/en/guide/getting-started
- Examples: https://neomacros.tuanzi.ink/en/examples/overview
- API reference: https://neomacros.tuanzi.ink/en/api/overview
- Event catalog: https://neomacros.tuanzi.ink/en/api/overview (Events section)
- Version matrix: https://neomacros.tuanzi.ink/en/api/version-matrix
