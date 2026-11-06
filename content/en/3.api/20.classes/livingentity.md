---
title: "LivingEntity"
description: "Living entity handle: adds the health and equipment read face on top of the entity base."
---

Handle · Wraps: `net.minecraft.world.entity.LivingEntity` · Extends: [`Entity`](entity) · Extended by: [`Player`](player), [`Mob`](mob)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `absorption` | `number` | The absorption hearts from golden apples and effects. (read-only) |
| `armorValue` | `number` | The armor points from worn gear (0-20 scale). (read-only) |
| `glowing` | `boolean` | Whether the entity is currently glowing (outline). (read-only) |
| `health` | `number` | The health value; undefined once the entity is gone. (read-only) |
| `heldItem` | [ItemStack](itemstack) | The item in the main hand; undefined for an empty hand or a gone entity. (read-only) |
| `hostile` | `boolean` | Whether the entity is hostile (implements the Enemy marker). (read-only) |
| `maxHealth` | `number` | The maximum health value; undefined once the entity is gone. (read-only) |
| `noGravity` | `boolean` | Whether gravity is disabled for the entity. (read-only) |
| `offhandItem` | [ItemStack](itemstack) | The item in the off hand; undefined for an empty hand or a gone entity. (read-only) |
| `sleeping` | `boolean` | Whether the entity is sleeping in a bed. |

## Methods

### `isHolding(itemId: string)`

Whether either hand holds an item of the given id (namespace optional).

**Parameters**

- `itemId` `string`: 

**Returns** `boolean`

Since: 0.2.0 · MC: * · Loader: *

