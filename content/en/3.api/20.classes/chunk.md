---
title: "Chunk"
description: "Live chunk handle: coordinates, height bounds, primed heightmaps, block entity positions, and biome reads over the loaded chunk. Getters re-query the world on every access; an unloaded chunk reads back as undefined instead of raising."
---

Handle · Wraps: `net.minecraft.world.level.chunk.LevelChunk`

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `blockEntities` | `Array<`[BlockPos](blockpos)`>` | The block entity positions inside the chunk, empty list when unloaded or without block entities. (read-only) |
| `chunkX` | `number` | The chunk x coordinate. (read-only) |
| `chunkZ` | `number` | The chunk z coordinate. (read-only) |
| `heightmaps` | `Record<string, unknown>` | The primed heightmaps as {type: number[256]} indexed by localX + localZ * 16, or null when unloaded. (read-only) |
| `inhabitedTime` | `number` | The inhabited ticks reported by the chunk, or null when unloaded. (read-only) |
| `maxY` | `number` | The highest buildable y of the chunk, or null when unloaded. (read-only) |
| `minY` | `number` | The lowest buildable y of the chunk, or null when unloaded. (read-only) |

## Methods

### `biomeAt(x: number, y: number, z: number)`

The biome identifier at the position inside this chunk, or null when unloaded.

**Parameters**

- `x` `number`: 世界坐标 X
- `y` `number`: 世界坐标 Y
- `z` `number`: 世界坐标 Z

**Returns** `string`

Since: 0.2.0 · MC: * · Loader: *

### `contains(x: number, y: number, z: number)`

Whether the world position lies inside this chunk.

**Parameters**

- `x` `number`: 世界坐标 X
- `y` `number`: 世界坐标 Y
- `z` `number`: 世界坐标 Z

**Returns** `boolean`

Since: 0.2.0 · MC: * · Loader: *

### `heightAt(x: number, z: number)`

The surface height (world surface) at the world coordinates inside this chunk, or null when unloaded.

**Parameters**

- `x` `number`: 世界坐标 X
- `z` `number`: 世界坐标 Z

**Returns** `number`

Since: 0.2.0 · MC: * · Loader: *

### `toJSON()`

Plain-object rendering used by JSON.stringify.

**Returns** `Record<string, unknown>`

Since: 0.2.0

### `toString()`



**Returns** `string`

Since: 0.2.0

