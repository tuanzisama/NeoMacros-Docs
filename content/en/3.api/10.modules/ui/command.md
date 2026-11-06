---
title: "command"
description: "The neo.command facade: client command registration and dispatch. Commands register declaratively with typed argument slots built through command.arg (int() float() bool() word() string() greedy() player() pos() plus optional() and default(v)); the handler receives a context whose args carry parsed values and whose raw keeps the remainder string."
---

:api-module-header{ category="UI" global="true" neo-name="neo.command" esm-name="@neomacros/command" since="0.1.0" mc="*" loader="*"}

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `arg` | `CommandArgFactory` | The typed argument-slot factory (command.arg). :api-badge{kind="readonly"} |

## Methods

### `argKindNames()`

Kind names the slot factory answers to (kept for tests and docs).

**Returns** `Array<string>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `execute(commandLine: string)`

Executes a client command as if typed by the player; dispatches through the vanilla dispatcher on the main thread. The promise settles with whether the command was found and executed.

**Parameters**

- `commandLine` `string`: 

**Returns** `Promise<boolean>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="command"}

### `register(spec: Record<string, unknown>)`

Registers a client command. The spec map carries name, description, optional args slots and the handler receiving the parsed context.

**Parameters**

- `spec` `Record<string, unknown>`: 

**Returns** `unknown` — an opaque registration handle (unregister via )

:api-badges{ since="0.1.0" mc="*" loader="*" permission="command"}

### `unregister(handleOrName: unknown)`

Unregisters by the handle returned from , or by command name when a string is given.

**Parameters**

- `handleOrName` `unknown`: 

:api-badges{ since="0.1.0" mc="*" loader="*"}


## Examples

Register a client command with typed argument slots and dispatch another command as if typed (register and execute require the command permission).

```js
const { command } = neo;

// register/execute both require the 'command' permission
command.register({
  name: 'mine',
  description: 'Announce a mining route',
  args: {
    ore: command.arg.word(), // required word slot
    seconds: command.arg.int().optional(),
  },
  handler(ctx) {
    // ctx.args: parsed values (ctx.args.ore); ctx.raw: the remainder string
  },
});

await command.execute('/neomacros list'); // dispatch as if typed
```
