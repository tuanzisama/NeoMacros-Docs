---
title: "ItemStack"
description: "Immutable copy of one item stack. Instances come only from queries (inventory slots, event payloads) or the ; there is no direct constructor. JSON.stringify renders the plain fields."
---

::api-declaration{ kind="data" name="ItemStack"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `count` | `number` | The stack size. :api-badge{kind="readonly"} |
| `damage` | `number` | The current durability damage (0 for undamageable items). :api-badge{kind="readonly"} |
| `damageable` | `boolean` | Whether the item takes durability damage at all. :api-badge{kind="readonly"} |
| `edible` | `boolean` | Whether the item is food. :api-badge{kind="readonly"} |
| `enchantable` | `boolean` | Whether the item can receive enchantments in an enchanting table. :api-badge{kind="readonly"} |
| `enchanted` | `boolean` | Whether the item currently carries enchantments. :api-badge{kind="readonly"} |
| `enchantments` | :api-type{text='Array<EnchantmentData>' refs='EnchantmentData=classes/enchantmentdata'} | The enchantments as {id, level} entries, in stored order. :api-badge{kind="readonly"} |
| `id` | `string` | The namespaced item identifier, e.g. minecraft:diamond_sword. :api-badge{kind="readonly"} |
| `isEmpty` | `boolean` | Whether the stack represents nothing (air or a zero count). |
| `lore` | `Array<string>` | The lore lines, in order. :api-badge{kind="readonly"} |
| `maxDamage` | `number` | The maximum durability (0 for undamageable items). :api-badge{kind="readonly"} |
| `maxStackSize` | `number` | The maximum stack size for this item. :api-badge{kind="readonly"} |
| `name` | `string` | The display name (styled text flattened). :api-badge{kind="readonly"} |
| `repairCost` | `number` | The anvil repair cost added by prior anvil work (0 when untouched). :api-badge{kind="readonly"} |

## Methods

::api-method

### `is`

Whether the stack's item id equals the identifier (namespace optional).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `itemId` | `string` |  | — | — |

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `isSameItem`

Whether the other stack holds the same item, ignoring count, damage, and components.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} |  | — | — |

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `same`

Whether the other stack is a full copy of this one.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} |  | — | — |

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `toJSON`

JSON string so JSON.stringify renders the stack directly.

**Returns** `string`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

