---
title: "ItemStackBuilder"
description: "本地 的构建器；脚本造物的唯一构造路径。产物是本地数据——进入世界只能靠特权写（创造物品栏）或仅作比较/展示——生存模式没有\"凭空给物品\"的路径（服务器权威）。"
---

::api-declaration{ kind="data" name="ItemStackBuilder"}
::

## Methods

### `build()`

校验并产出不可变物品堆。

**Returns** [ItemStack](itemstack)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `construct(args: unknown)`



**Parameters**

- `args` `unknown`: 

**Returns** `unknown`

:api-badges{ since="0.2.0"}

### `copyFrom(stack: ItemStack)`

以现有物品堆为底稿拷贝全部字段，随后链式调用逐项覆盖。

**Parameters**

- `stack` [ItemStack](itemstack): 

**Returns** [ItemStackBuilder](itemstackbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `count(size: number)`

设置物品数量。

**Parameters**

- `size` `number`: 

**Returns** [ItemStackBuilder](itemstackbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `damage(value: number)`

设置当前耐久损伤。

**Parameters**

- `value` `number`: 

**Returns** [ItemStackBuilder](itemstackbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `enchant(enchantId: string, level: number)`

添加一条附魔（可链式重复）。

**Parameters**

- `enchantId` `string`: 
- `level` `number`: 

**Returns** [ItemStackBuilder](itemstackbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `lore(lines: unknown)`

追加 Lore 行（变参形态）。

**Parameters**

- `lines` `unknown`: 

**Returns** [ItemStackBuilder](itemstackbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `loreLines(lines: Array<string>)`

以数组形态替换 Lore 行。

**Parameters**

- `lines` `Array<string>`: 

**Returns** [ItemStackBuilder](itemstackbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `maxDamage(value: number)`

设置最大耐久。

**Parameters**

- `value` `number`: 

**Returns** [ItemStackBuilder](itemstackbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `name(value: string)`

设置自定义显示名。

**Parameters**

- `value` `string`: 

**Returns** [ItemStackBuilder](itemstackbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `toString()`



**Returns** `string`

:api-badges{ since="0.2.0"}

### `unbreakable()`

标记为不可破坏（无参调用默认 true）。

**Returns** [ItemStackBuilder](itemstackbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `unbreakable(on: boolean)`

标记不可破坏的开或关。

**Parameters**

- `on` `boolean`: 

**Returns** [ItemStackBuilder](itemstackbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

