---
title: "ChunkPos"
description: "Immutable chunk-grid coordinate. Deliberately unrelated to : chunk coordinates and block coordinates are different spaces and every conversion between them is explicit (x = blockX >> 4)."
---

::api-declaration{ kind="data" name="ChunkPos" ctor="new ChunkPos(x: number, z: number)"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `minX` | `number` | The west (-X) block-coordinate boundary, equal to x << 4. |
| `minZ` | `number` | The north (-Z) block-coordinate boundary, equal to z << 4. |
| `x` | `number` | The chunk X (blockX >> 4). |
| `z` | `number` | The chunk Z. |

## Methods

::api-method

### `contains`

Whether the block position falls inside this chunk.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `pos` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `minBlock`

The northwest corner block position on the world floor.

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `offset`

Translates by chunk-space offsets.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `dx` | `number` |  | — | — |
| `dz` | `number` |  | — | — |

**Returns** :api-type{text='ChunkPos' refs='ChunkPos=classes/chunkpos'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `toJSON`

JSON form so JSON.stringify renders the chunk directly.

**Returns** `string`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

