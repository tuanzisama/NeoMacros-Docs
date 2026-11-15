---
title: "Chunk"
description: "Live chunk handle: coordinates, height bounds, primed heightmaps, block entity positions, and biome reads over the loaded chunk. Getters re-query the world on every access; an unloaded chunk reads back as undefined instead of raising."
---

::api-declaration{ kind="handle" name="Chunk" wraps="net.minecraft.world.level.chunk.LevelChunk"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `blockEntities` | :api-type{text='Array<BlockPos>' refs='BlockPos=classes/blockpos'} | The block entity positions inside the chunk, empty list when unloaded or without block entities. :api-badge{kind="readonly"} |
| `chunkX` | `number` | The chunk x coordinate. :api-badge{kind="readonly"} |
| `chunkZ` | `number` | The chunk z coordinate. :api-badge{kind="readonly"} |
| `heightmaps` | `Record<string, Array<number>>` | The primed heightmaps as {type: number[256]} indexed by localX + localZ * 16, or null when unloaded. :api-badge{kind="readonly"} |
| `inhabitedTime` | `number` | The inhabited ticks reported by the chunk, or null when unloaded. :api-badge{kind="readonly"} |
| `maxY` | `number` | The highest buildable y of the chunk, or null when unloaded. :api-badge{kind="readonly"} |
| `minY` | `number` | The lowest buildable y of the chunk, or null when unloaded. :api-badge{kind="readonly"} |

## Methods

::api-method

### `biomeAt`

The biome identifier at the position inside this chunk, or null when unloaded.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `x` | `number` |  | — | — |
| `y` | `number` |  | — | — |
| `z` | `number` |  | — | — |

**Returns** `string`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `contains`

Whether the world position lies inside this chunk.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `x` | `number` |  | — | — |
| `y` | `number` |  | — | — |
| `z` | `number` |  | — | — |

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `heightAt`

The surface height (world surface) at the world coordinates inside this chunk, or null when unloaded.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `x` | `number` |  | — | — |
| `z` | `number` |  | — | — |

**Returns** `number`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `toJSON`

Plain-object rendering used by JSON.stringify.

**Returns** `string`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

