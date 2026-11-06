---
title: "LocalPlayer"
description: "Local player action face: attack/interact/swing/drop dispatch through the game on the main thread and resolve once processed."
---

::api-declaration{ kind="handle" name="LocalPlayer" wraps="net.minecraft.client.player.LocalPlayer"}
#extends
[`Player`](player)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `abilities` | [Abilities](abilities) | The live abilities handle: flags and speed multipliers, readable and writable client-side. :api-badge{kind="readonly"} |
| `blockInteractionRange` | `number` | The block interaction range in blocks. :api-badge{kind="readonly"} |
| `breakingBlock` | `boolean` | Whether the local player is currently breaking a block. :api-badge{kind="readonly"} |
| `entityInteractionRange` | `number` | The entity interaction range in blocks. :api-badge{kind="readonly"} |
| `statistics` | `Record<string, number>` | The client-side statistics as statTypeId:valueId -> value entries; only non-zero values appear. null without a world. :api-badge{kind="readonly"} |

## Methods

### `attack(target: Entity)`

Attacks the entity behind the target handle.

**Parameters**

- `target` [Entity](entity): 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `dropHeld(all: boolean)`

Drops the held item stack (all = the whole stack).

**Parameters**

- `all` `boolean`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `interactBlock(pos: BlockPos)`

Uses (right-clicks) the block behind the position handle.

**Parameters**

- `pos` [BlockPos](blockpos): 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `interactEntity(target: Entity)`

Uses (right-clicks) the entity behind the target handle.

**Parameters**

- `target` [Entity](entity): 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `itemCooldown(itemId: string)`

The item cooldown progress for the item id, 0 when not on cooldown (or the item is unknown).

**Parameters**

- `itemId` `string`: 

**Returns** `number`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `look(yaw: number, pitch: number)`

Turns the camera to the yaw (horizontal) and pitch (vertical) angles in degrees.

**Parameters**

- `yaw` `number`: 
- `pitch` `number`: 

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `lookAt(target: Entity)`

Turns the camera to look at the entity behind the target handle.

**Parameters**

- `target` [Entity](entity): 

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `setVelocity(x: number, y: number, z: number)`

Sets the movement velocity vector (client-side write).

**Parameters**

- `x` `number`: 
- `y` `number`: 
- `z` `number`: 

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `swingHand(offhand: boolean)`

Swings the main hand (offhand = the off hand).

**Parameters**

- `offhand` `boolean`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `teleport(x: number, y: number, z: number)`

Moves the local player to the position (client-side write; multiplayer servers correct the position back).

**Parameters**

- `x` `number`: 
- `y` `number`: 
- `z` `number`: 

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `toString()`

Human-readable form.

**Returns** `string`

