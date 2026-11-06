---
title: "BlockState"
description: "不可变方块状态：带命名空间的方块标识符加原版状态属性（facing、open 等）。"
---

::api-declaration{ kind="data" name="BlockState"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `burnable` | `boolean` | 岩浆是否可点燃该方块。 :api-badge{kind="readonly"} |
| `hardness` | `number` | 破坏硬度；不可破坏方块为 undefined。 :api-badge{kind="readonly"} |
| `id` | `string` | 带命名空间的方块标识符，如 minecraft:chest。 :api-badge{kind="readonly"} |
| `isAir` | `boolean` | 状态是否为空气类方块。 |
| `liquid` | `boolean` | 状态是否为液体（水/熔岩族）。 |
| `luminance` | `number` | 方块发光等级（0-15）。 :api-badge{kind="readonly"} |
| `opaque` | `boolean` | 该状态是否遮蔽天光与相邻面。 :api-badge{kind="readonly"} |
| `props` | `Record<string, string>` | 原版状态属性。 :api-badge{kind="readonly"} |
| `replaceable` | `boolean` | 该方块是否可被放置覆盖（如花草）。 :api-badge{kind="readonly"} |
| `toolRequired` | `boolean` | 掉落物是否需要正确工具。 :api-badge{kind="readonly"} |

## Methods

### `emitsRedstonePower()`

该状态是否发出红石信号。

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `hasBlockEntity()`

该状态是否带方块实体。

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `hasRandomTicks()`

该状态是否接收随机刻。

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `is(idOrPredicate: string)`

状态的方块是否匹配标识符（可省略命名空间）。

**Parameters**

- `idOrPredicate` `string`: 

**Returns** `boolean`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `isProps(props: Record<string, string>)`



**Parameters**

- `props` `Record<string, string>`: 

**Returns** `boolean`

### `toString()`



**Returns** `string`

