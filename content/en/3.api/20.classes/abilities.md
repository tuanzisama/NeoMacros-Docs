---
title: "Abilities"
description: "The local player abilities handle: the creative-mode flags and speed multipliers, readable live and writable client-side. Multiplayer servers keep authority over flying, so writes may be corrected."
---

Handle · Wraps: `net.minecraft.world.entity.player.Abilities`

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `flySpeed` | `number` | The fly speed multiplier. (read-only) |
| `flying` | `boolean` | Whether the player is currently flying. (read-only) |
| `instabuild` | `boolean` | Whether the player has instant block breaking. (read-only) |
| `invulnerable` | `boolean` | Whether the player is immune to damage. (read-only) |
| `walkingSpeed` | `number` | The walking speed multiplier. (read-only) |

## Methods

### `mayBuild()`

Whether the player may build and break blocks.

**Returns** `boolean`

Since: 0.2.0 · MC: * · Loader: *

### `mayFly()`

Whether the player may toggle flight at all.

**Returns** `boolean`

Since: 0.2.0 · MC: * · Loader: *

### `setFlySpeed(value: number)`

Sets the fly speed multiplier (client-side write).

**Parameters**

- `value` `number`: 

**Returns** `Promise<void>`

Since: 0.2.0 · MC: * · Loader: *

### `setFlying(value: boolean)`

Toggles flight (client-side write; servers may revoke it).

**Parameters**

- `value` `boolean`: 

**Returns** `Promise<void>`

Since: 0.2.0 · MC: * · Loader: *

### `setWalkingSpeed(value: number)`

Sets the walking speed multiplier (client-side write).

**Parameters**

- `value` `number`: 

**Returns** `Promise<void>`

Since: 0.2.0 · MC: * · Loader: *

