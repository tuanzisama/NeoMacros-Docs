---
title: "LocalPlayer"
description: "The action surface of the local player: attack, interact, swing, and drop dispatch through the game on the main thread and resolve once processed."
---

Handle · Wraps: `net.minecraft.client.player.LocalPlayer` · Extends: [`Player`](player)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `abilities` | `Record<string, unknown>` | The player abilities snapshot: {invulnerable, flying, mayFly, instabuild, mayBuild, flySpeed, walkingSpeed}, or null when unloaded. (read-only) |
| `blockInteractionRange` | `number` | The block interaction range in blocks. (read-only) |
| `breakingBlock` | `boolean` | Whether the local player is currently breaking a block. (read-only) |
| `entityInteractionRange` | `number` | The entity interaction range in blocks. (read-only) |
| `statistics` | `Record<string, number>` | The client-side statistics as statTypeId:valueId -> value entries; only non-zero values appear. null without a world. (read-only) |

## Methods

### `attack(target: Entity)`

Attacks the entity behind the target handle.

**Parameters**

- `target` [Entity](entity): 

**Returns** `Promise<void>`

Since: 0.1.0 · MC: * · Loader: *

### `dropHeld(all: boolean)`

Drops the held item stack (all = the whole stack).

**Parameters**

- `all` `boolean`: 

**Returns** `Promise<void>`

Since: 0.1.0 · MC: * · Loader: *

### `interactBlock(pos: BlockPos)`

Uses (right-clicks) the block behind the position handle.

**Parameters**

- `pos` [BlockPos](blockpos): 

**Returns** `Promise<void>`

Since: 0.1.0 · MC: * · Loader: *

### `interactEntity(target: Entity)`

Uses (right-clicks) the entity behind the target handle.

**Parameters**

- `target` [Entity](entity): 

**Returns** `Promise<void>`

Since: 0.1.0 · MC: * · Loader: *

### `swingHand(offhand: boolean)`

Swings the main hand (offhand = the off hand).

**Parameters**

- `offhand` `boolean`: 

**Returns** `Promise<void>`

Since: 0.1.0 · MC: * · Loader: *

### `toString()`

Human-readable form.

**Returns** `string`

