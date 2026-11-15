---
title: "command"
description: "The neo.command module: client command registration and dispatch. Commands register declaratively with typed argument slots built through command.arg (int() float() bool() word() string() greedy() player() pos() plus optional() and default(v)); the handler receives a context whose args carry parsed values and whose raw keeps the remainder string."
---

:api-module-header{ category="UI" neo-name="neo.command" since="0.1.0" mc="*" loader="*"}

**Classes**

[`CommandSpec`](classes/CommandSpec.html)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `arg` | :api-type{text='Record<"int" \| "float" \| "bool" \| "word" \| "string" \| "greedy" \| "player" \| "pos", () => CommandArg>' refs='CommandArg=classes/commandarg'} | The typed argument-slot factory (command.arg). :api-badge{kind="readonly"} |

## Methods

::api-method

### `argKindNames`

Kind names the slot factory answers to (kept for tests and docs).

**Returns** `Array<string>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `execute`

Executes a client command as if typed by the player; dispatches through the vanilla dispatcher on the main thread. The promise settles with whether the command was found and executed.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `commandLine` | `string` |  | — | — |

**Returns** `Promise<boolean>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="command"}

::

::api-method

### `register`

Registers a client command. The spec map carries name, description, optional args slots and the handler receiving the parsed context.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `spec` | :api-type{text='CommandSpec' refs='CommandSpec=classes/commandspec'} |  | — | — |

**Returns** `string` — the command name (the key for )

:api-badges{ since="0.1.0" mc="*" loader="*" permission="command"}

::

::api-method

### `unregister`

Unregisters by the command name returned from .

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `handleOrName` | `string` |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

