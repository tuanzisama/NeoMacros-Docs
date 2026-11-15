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
| `chunk` | :api-type{text='ChunkPos' refs='ChunkPos=classes/chunkpos'} | The chunk coordinate containing the block. :api-badge{kind="readonly"} |
| `pos` | :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'} | The block position. :api-badge{kind="readonly"} |
| `raw` | :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'} | Escape hatch: the raw host block state object. Requires the java permission. |
| `state` | :api-type{text='BlockState' refs='BlockState=classes/blockstate'} | The current block state; undefined outside the loaded world. :api-badge{kind="readonly"} |
| `valid` | `boolean` | Whether the block is still loaded in the world. |

## Methods

::api-method

### `relative`

The block n steps in one cardinal direction, or undefined outside the loaded world.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `direction` | `string` |  | — | — |
| `n` | `number` |  | — | — |

**Returns** :api-type{text='Block' refs='Block=classes/block'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

