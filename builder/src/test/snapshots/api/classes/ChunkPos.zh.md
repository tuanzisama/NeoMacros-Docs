---
title: "ChunkPos"
description: "不可变区块坐标。刻意不与 发生继承关系：区块坐标与方块坐标分属两套坐标系，相互换算必须显式（x = blockX >> 4）。"
---

::api-declaration{ kind="data" name="ChunkPos" ctor="new ChunkPos(x: number, z: number)"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `minX` | `number` | 区块西（-X）边界方块坐标，等于 x << 4。 |
| `minZ` | `number` | 区块北（-Z）边界方块坐标，等于 z << 4。 |
| `x` | `number` | 区块 X（blockX >> 4）。 |
| `z` | `number` | 区块 Z。 |

## Methods

::api-method

### `contains`

判断方块坐标是否落在本区块内。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `pos` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `minBlock`

区块西北角的方块坐标（y=0，需要其他高度时用 withY 替换）。

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `offset`

按区块坐标系平移。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `dx` | `number` |  | — | — |
| `dz` | `number` |  | — | — |

**Returns** :api-type{text='ChunkPos' refs='ChunkPos=classes/chunkpos'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `toJSON`

JSON 形式，使 JSON.stringify 直接输出区块坐标。

**Returns** `string`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

**Example**

```js
const here = new ChunkPos(3, -2);
const east = here.offset(1, 0); // 区块 (4, -2)
```

