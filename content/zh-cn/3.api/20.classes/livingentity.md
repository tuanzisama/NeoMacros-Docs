---
title: "LivingEntity"
description: "生物句柄：在实体基类之上增加生命与装备读面。"
---

Handle · Wraps: `net.minecraft.world.entity.LivingEntity` · Extends: [`Entity`](entity) · Extended by: [`Player`](player), [`Mob`](mob)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `absorption` | `number` | 吸收心血量（金苹果/效果赋予）。 (read-only) |
| `armorValue` | `number` | 已穿戴护甲值（0-20 刻度）。 (read-only) |
| `glowing` | `boolean` | 实体当前是否发光（描边）。 (read-only) |
| `health` | `number` | 生命值；实体消失后为 undefined。 (read-only) |
| `heldItem` | [ItemStack](itemstack) | 主手物品；空手或实体消失时为 undefined。 (read-only) |
| `hostile` | `boolean` | Whether the entity is hostile (implements the Enemy marker). (read-only) |
| `maxHealth` | `number` | 最大生命值；实体消失后为 undefined。 (read-only) |
| `noGravity` | `boolean` | 实体是否无重力。 (read-only) |
| `offhandItem` | [ItemStack](itemstack) | 副手物品；空手或实体消失时为 undefined。 (read-only) |
| `sleeping` | `boolean` | 实体是否睡在床上。 |

## Methods

### `isHolding(itemId: string)`

主/副手任一是否持有指定 id 的物品（命名空间可省略）。

**Parameters**

- `itemId` `string`: 

**Returns** `boolean`

Since: 0.2.0 · MC: * · Loader: *

