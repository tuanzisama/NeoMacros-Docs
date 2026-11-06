---
title: "Block"
description: "活方块句柄：状态读取每次都重新查询世界；未加载世界的方块读取返回 undefined 而不是抛错。"
---

::api-declaration{ kind="handle" name="Block"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `biome` | `string` | 方块位置的群系标识。 :api-badge{kind="readonly"} |
| `chunk` | [ChunkPos](chunkpos) | 方块所在区块坐标。 :api-badge{kind="readonly"} |
| `pos` | [BlockPos](blockpos) | 方块坐标。 :api-badge{kind="readonly"} |
| `raw` | `unknown` | 穿透口：原始宿主方块状态对象（需 java 权限）。 |
| `state` | [BlockState](blockstate) | 当前方块状态；未加载世界内为 undefined。 :api-badge{kind="readonly"} |
| `valid` | `boolean` | 方块是否仍在世界中加载。 |

## Methods

### `relative(direction: string, n: number)`

沿基本方向偏移 n 格的方块；未加载世界内为 undefined。

**Parameters**

- `direction` `string`: 方向名（up/down/north/south/east/west）
- `n` `number`: 步数（可省略，默认 1）

**Returns** [Block](block)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `toString()`

人类可读形式。

**Returns** `string`

