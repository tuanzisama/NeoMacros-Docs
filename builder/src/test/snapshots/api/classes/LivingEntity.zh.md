---
title: "LivingEntity"
description: "生物句柄：在实体基类之上增加生命与装备读面。"
---

::api-declaration{ kind="handle" name="LivingEntity" wraps="net.minecraft.world.entity.LivingEntity"}
#extends
[`Entity`](Entity.html)
#extended-by
[`Player`](Player.html), [`MobEntity`](MobEntity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `absorption` | `number` | 吸收心血量（金苹果/效果赋予）。 :api-badge{kind="readonly"} |
| `air` | `number` | 剩余空气刻；原版水中小上限 300。 :api-badge{kind="readonly"} |
| `armorValue` | `number` | 已穿戴护甲值（0-20 刻度）。 :api-badge{kind="readonly"} |
| `effects` | :api-type{text='Array<StatusEffectData>' refs='StatusEffectData=classes/statuseffectdata'} | 生效中的状态效果 {id, duration, amplifier, infinite}；实体消失后为空。 :api-badge{kind="readonly"} |
| `glowing` | `boolean` | 实体当前是否发光（描边）。 :api-badge{kind="readonly"} |
| `health` | `number` | 生命值；实体消失后为 undefined。 :api-badge{kind="readonly"} |
| `heldItem` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | 主手物品；空手或实体消失时为 undefined。 :api-badge{kind="readonly"} |
| `hostile` | `boolean` | 实体是否为敌对（实现 Enemy 标记接口）。 :api-badge{kind="readonly"} |
| `maxAir` | `number` | 最大空气刻（原版 300）。 :api-badge{kind="readonly"} |
| `maxHealth` | `number` | 最大生命值；实体消失后为 undefined。 :api-badge{kind="readonly"} |
| `noGravity` | `boolean` | 实体是否无重力。 :api-badge{kind="readonly"} |
| `offhandItem` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | 副手物品；空手或实体消失时为 undefined。 :api-badge{kind="readonly"} |
| `sleeping` | `boolean` | 实体是否睡在床上。 |
| `tags` | `Array<string>` | 实体携带的命令标签。 :api-badge{kind="readonly"} |
| `useItemRemainingTicks` | `number` | 进食/饮水/格挡时的剩余使用刻。 :api-badge{kind="readonly"} |

## Methods

::api-method

### `hasEffect`

指定 id 的状态效果是否生效中。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `id` | `string` |  | — | — |

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `isHolding`

主/副手任一是否持有指定 id 的物品（命名空间可省略）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `itemId` | `string` |  | — | — |

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

