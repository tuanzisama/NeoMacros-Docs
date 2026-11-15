---
title: "Abilities"
description: "The local player abilities handle: the creative-mode flags and speed multipliers, readable live and writable client-side. Multiplayer servers keep authority over flying, so writes may be corrected."
---

::api-declaration{ kind="handle" name="Abilities" wraps="net.minecraft.world.entity.player.Abilities"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `flySpeed` | `number` | The fly speed multiplier. :api-badge{kind="readonly"} |
| `flying` | `boolean` | Whether the player is currently flying. :api-badge{kind="readonly"} |
| `instabuild` | `boolean` | Whether the player has instant block breaking. :api-badge{kind="readonly"} |
| `invulnerable` | `boolean` | Whether the player is immune to damage. :api-badge{kind="readonly"} |
| `walkingSpeed` | `number` | The walking speed multiplier. :api-badge{kind="readonly"} |

## Methods

::api-method

### `mayBuild`

Whether the player may build and break blocks.

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `mayFly`

Whether the player may toggle flight at all.

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `setFlySpeed`

Sets the fly speed multiplier (client-side write).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `value` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `setFlying`

Toggles flight (client-side write; servers may revoke it).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `value` | `boolean` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `setWalkingSpeed`

Sets the walking speed multiplier (client-side write).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `value` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

