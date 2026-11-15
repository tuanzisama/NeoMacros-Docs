---
title: "ItemStackBuilder"
description: "本地 的构建器；脚本造物的唯一构造路径。产物是本地数据——进入世界只能靠特权写（创造物品栏）或仅作比较/展示——生存模式没有\"凭空给物品\"的路径（服务器权威）。"
---

::api-declaration{ kind="data" name="ItemStackBuilder" ctor="new ItemStackBuilder(itemId: string)"}
::

## Methods

::api-method

### `build`

校验并产出不可变物品堆。

**Returns** :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `copyFrom`

以现有物品堆为底稿拷贝全部字段，随后链式调用逐项覆盖。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `stack` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} |  | — | — |

**Returns** :api-type{text='ItemStackBuilder' refs='ItemStackBuilder=classes/itemstackbuilder'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `count`

设置物品数量。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `size` | `number` |  | — | — |

**Returns** :api-type{text='ItemStackBuilder' refs='ItemStackBuilder=classes/itemstackbuilder'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `damage`

设置当前耐久损伤。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `value` | `number` |  | — | — |

**Returns** :api-type{text='ItemStackBuilder' refs='ItemStackBuilder=classes/itemstackbuilder'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `enchant`

添加一条附魔（可链式重复）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `enchantId` | `string` |  | — | — |
| `level` | `number` |  | — | — |

**Returns** :api-type{text='ItemStackBuilder' refs='ItemStackBuilder=classes/itemstackbuilder'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `lore`

追加 Lore 行（变参形态）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `...lines` | `Array<string>` |  | — | — |

**Returns** :api-type{text='ItemStackBuilder' refs='ItemStackBuilder=classes/itemstackbuilder'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `loreLines`

以数组形态替换 Lore 行。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `lines` | `Array<string>` |  | — | — |

**Returns** :api-type{text='ItemStackBuilder' refs='ItemStackBuilder=classes/itemstackbuilder'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `maxDamage`

设置最大耐久。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `value` | `number` |  | — | — |

**Returns** :api-type{text='ItemStackBuilder' refs='ItemStackBuilder=classes/itemstackbuilder'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `name`

设置自定义显示名。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `value` | `string` |  | — | — |

**Returns** :api-type{text='ItemStackBuilder' refs='ItemStackBuilder=classes/itemstackbuilder'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `unbreakable`

标记为不可破坏（无参调用默认 true）。

**Returns** :api-type{text='ItemStackBuilder' refs='ItemStackBuilder=classes/itemstackbuilder'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `unbreakable`

标记不可破坏的开或关。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `on` | `boolean` |  | — | — |

**Returns** :api-type{text='ItemStackBuilder' refs='ItemStackBuilder=classes/itemstackbuilder'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

**Example**

```js
const stack = new ItemStackBuilder("diamond_sword")
  .name("Excalibur")
  .enchant("minecraft:sharpness", 5)
  .unbreakable()
  .count(1)
  .build();
```

