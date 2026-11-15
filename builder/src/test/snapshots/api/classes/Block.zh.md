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
| `chunk` | :api-type{text='ChunkPos' refs='ChunkPos=classes/chunkpos'} | 方块所在区块坐标。 :api-badge{kind="readonly"} |
| `pos` | :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'} | 方块坐标。 :api-badge{kind="readonly"} |
| `raw` | :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'} | 穿透口：原始宿主方块状态对象（需 java 权限）。 |
| `state` | :api-type{text='BlockState' refs='BlockState=classes/blockstate'} | 当前方块状态；未加载世界内为 undefined。 :api-badge{kind="readonly"} |
| `valid` | `boolean` | 方块是否仍在世界中加载。 |

## Methods

::api-method

### `relative`

沿基本方向偏移 n 格的方块；未加载世界内为 undefined。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `direction` | `string` | 方向名（up/down/north/south/east/west） | — | — |
| `n` | `number` | 步数（可省略，默认 1） | — | — |

**Returns** :api-type{text='Block' refs='Block=classes/block'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

