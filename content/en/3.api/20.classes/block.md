---
title: "Block"
description: "Live block handle: state reads re-query the world on every access; a block outside the loaded world reads back as undefined instead of raising."
---

::api-declaration{ kind="handle" name="Block"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `biome` | `string` | The biome identifier at the block position. :api-badge{kind="readonly"} |
| `chunk` | [ChunkPos](chunkpos) | The chunk coordinate containing the block. :api-badge{kind="readonly"} |
| `pos` | [BlockPos](blockpos) | The block position. :api-badge{kind="readonly"} |
| `raw` | `unknown` | Escape hatch: the raw host block state object. Requires the java permission. |
| `state` | [BlockState](blockstate) | The current block state; undefined outside the loaded world. :api-badge{kind="readonly"} |
| `valid` | `boolean` | Whether the block is still loaded in the world. |

## Methods

### `relative(direction: string, n: number)`

The block n steps in one cardinal direction, or undefined outside the loaded world.

**Parameters**

- `direction` `string`: 方向名（up/down/north/south/east/west）
- `n` `number`: 步数（可省略，默认 1）

**Returns** [Block](block)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `toString()`

Human-readable form.

**Returns** `string`

