---
title: "BlockState"
description: "不可变方块状态：带命名空间的方块标识符加原版状态属性（facing、open 等）。"
---

Data

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `burnable` | `boolean` | 岩浆是否可点燃该方块。 (read-only) |
| `hardness` | `number` | 破坏硬度；不可破坏方块为 undefined。 (read-only) |
| `id` | `string` | 带命名空间的方块标识符，如 minecraft:chest。 (read-only) |
| `isAir` | `boolean` | 状态是否为空气类方块。 |
| `liquid` | `boolean` | 状态是否为液体（水/熔岩族）。 |
| `luminance` | `number` | 方块发光等级（0-15）。 (read-only) |
| `opaque` | `boolean` | 该状态是否遮蔽天光与相邻面。 (read-only) |
| `props` | `Record<string, string>` | 原版状态属性。 (read-only) |
| `replaceable` | `boolean` | 该方块是否可被放置覆盖（如花草）。 (read-only) |
| `toolRequired` | `boolean` | 掉落物是否需要正确工具。 (read-only) |

## Methods

### `emitsRedstonePower()`

该状态是否发出红石信号。

**Returns** `boolean`

Since: 0.2.0 · MC: * · Loader: *

### `hasBlockEntity()`

该状态是否带方块实体。

**Returns** `boolean`

Since: 0.2.0 · MC: * · Loader: *

### `hasRandomTicks()`

该状态是否接收随机刻。

**Returns** `boolean`

Since: 0.2.0 · MC: * · Loader: *

### `is(idOrPredicate: string)`

状态的方块是否匹配标识符（可省略命名空间）。

**Parameters**

- `idOrPredicate` `string`: 

**Returns** `boolean`

Since: 0.1.0 · MC: * · Loader: *

### `isProps(props: Record<string, string>)`



**Parameters**

- `props` `Record<string, string>`: 

**Returns** `boolean`

### `toString()`



**Returns** `string`

