---
title: "ItemStack"
description: "不可变的物品堆副本。实例只来自查询（容器槽位、事件载荷）或 ；不提供直接构造器。JSON.stringify 输出纯字段。"
---

::api-declaration{ kind="data" name="ItemStack"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `count` | `number` | 物品数量。 :api-badge{kind="readonly"} |
| `damage` | `number` | 当前耐久损伤（无耐久物品为 0）。 :api-badge{kind="readonly"} |
| `damageable` | `boolean` | 该物品是否会损耗耐久。 :api-badge{kind="readonly"} |
| `edible` | `boolean` | 该物品是否为食物。 :api-badge{kind="readonly"} |
| `enchantable` | `boolean` | 该物品是否可被附魔台附魔。 :api-badge{kind="readonly"} |
| `enchanted` | `boolean` | 该物品当前是否带附魔。 :api-badge{kind="readonly"} |
| `enchantments` | `Array<Record<string, unknown>>` | 按 {id, level} 形态的附魔列表，按存储顺序。 :api-badge{kind="readonly"} |
| `id` | `string` | 命名空间物品标识，如 minecraft:diamond_sword。 :api-badge{kind="readonly"} |
| `isEmpty` | `boolean` | 物品堆是否为空（空气或数量为零）。 |
| `lore` | `Array<string>` | 按序排列的 Lore 行。 :api-badge{kind="readonly"} |
| `maxDamage` | `number` | 最大耐久（无耐久物品为 0）。 :api-badge{kind="readonly"} |
| `maxStackSize` | `number` | 该物品的最大堆叠数。 :api-badge{kind="readonly"} |
| `name` | `string` | 显示名（样式文本平铺）。 :api-badge{kind="readonly"} |
| `repairCost` | `number` | 铁砧累积的修复费用（未动过为 0）。 :api-badge{kind="readonly"} |

## Methods

### `equals(other: unknown)`



**Parameters**

- `other` `unknown`: 

**Returns** `boolean`

:api-badges{ since="0.2.0"}

### `hashCode()`



**Returns** `number`

:api-badges{ since="0.2.0"}

### `is(itemId: string)`

物品标识是否等于给定 id（命名空间可省略）。

**Parameters**

- `itemId` `string`: 

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `isSameItem(other: unknown)`

另一物品堆是否为同类物品（忽略数量、耐久与组件）。

**Parameters**

- `other` `unknown`: 

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `of(data: ItemStackData)`

由中立端口快照构建脚本物品堆。

**Parameters**

- `data` [ItemStackData](itemstackdata): 

**Returns** [ItemStack](itemstack)

:api-badges{ since="0.2.0"}

### `same(other: unknown)`

另一物品堆是否与本堆完全相同。

**Parameters**

- `other` `unknown`: 

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `toJSON()`

JSON 形式，使 JSON.stringify 直接输出物品堆。

**Returns** `Record<string, unknown>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `toString()`



**Returns** `string`

:api-badges{ since="0.2.0"}

