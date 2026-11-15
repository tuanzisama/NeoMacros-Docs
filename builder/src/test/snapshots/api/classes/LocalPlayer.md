---
title: "LocalPlayer"
description: "Local player action face: attack/interact/swing/drop dispatch through the game on the main thread and resolve once processed."
---

::api-declaration{ kind="handle" name="LocalPlayer" wraps="net.minecraft.client.player.LocalPlayer"}
#extends
[`Player`](Player.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `abilities` | :api-type{text='Abilities' refs='Abilities=classes/abilities'} | The live abilities handle: flags and speed multipliers, readable and writable client-side. :api-badge{kind="readonly"} |
| `advancements` | :api-type{text='Advancements' refs='Advancements=classes/advancements'} | The client-known advancements: tree queries plus per-advancement progress. null without a server connection. :api-badge{kind="readonly"} |
| `blockInteractionRange` | `number` | The block interaction range in blocks (survival base 4.5; the creative modifier raises it to 5.0; attribute modifiers apply). :api-badge{kind="readonly"} |
| `breakingBlock` | `boolean` | Whether the local player is currently breaking a block. :api-badge{kind="readonly"} |
| `entityInteractionRange` | `number` | The entity interaction range in blocks (survival base 3.0; the creative modifier raises it to 3.5; attribute modifiers apply). :api-badge{kind="readonly"} |
| `statistics` | :api-type{text='Statistics' refs='Statistics=classes/statistics'} | The client-side statistics handle: typed per-category queries over the live stat counters. null without a world. :api-badge{kind="readonly"} |
| `target` | :api-type{text='Target' refs='Target=classes/target'} | The crosshair pick: the first block or entity inside the interaction ranges, re-read on every access. null without a world. :api-badge{kind="readonly"} |

## Methods

::api-method

### `attack`

Attacks the entity behind the target handle.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `target` | :api-type{text='Entity' refs='Entity=classes/entity'} |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `attackBlock`

Starts breaking the block at the position on the named face (defaults to up): swings and begins the destroy path; instant-break blocks complete at once, harder blocks start the mining progress that the game advances while the attack key stays held. Unknown faces throw.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `pos` | :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'} |  | — | — |
| `face` | `string` |  | ✓ | — |

**Returns** `Promise<void>`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `dropHeld`

Drops the held item stack (all = the whole stack).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `all` | `boolean` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `interactBlock`

Uses (right-clicks) the block behind the position handle on the named face (up/down/north/south/ east/west; default up) with the named hand (main or off; default main). Unknown faces throw.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `pos` | :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'} |  | — | — |
| `face` | `string` |  | ✓ | — |
| `hand` | `string` |  | ✓ | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `interactEntity`

Uses (right-clicks) the entity behind the target handle with the named hand (main or off; default main).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `target` | :api-type{text='Entity' refs='Entity=classes/entity'} |  | — | — |
| `hand` | `string` |  | ✓ | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `interactItem`

Uses (right-clicks) the held item in the air with the named hand (main or off; default main).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `hand` | `string` |  | ✓ | — |

**Returns** `Promise<void>`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `itemCooldown`

The item cooldown progress for the item id, 0 when not on cooldown (or the item is unknown).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `itemId` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `look`

Turns the camera to the yaw (horizontal) and pitch (vertical) angles in degrees.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `yaw` | `number` |  | — | — |
| `pitch` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `lookAt`

Turns the camera to look at the entity behind the target handle.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `target` | :api-type{text='Entity' refs='Entity=classes/entity'} |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `setVelocity`

Sets the movement velocity vector (client-side write).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `x` | `number` |  | — | — |
| `y` | `number` |  | — | — |
| `z` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `stopBreaking`

Releases the ongoing block breaking (the same path as releasing the attack key).

**Returns** `Promise<void>`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `swingHand`

Swings the main hand (offhand = the off hand).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `offhand` | `boolean` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `teleport`

Moves the local player to the position (client-side write; multiplayer servers correct the position back).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `x` | `number` |  | — | — |
| `y` | `number` |  | — | — |
| `z` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

