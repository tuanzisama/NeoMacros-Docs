---
title: "Chunk"
description: "区块活句柄：区块坐标、高度界、已就绪的高度图、方块实体位置与群系读取，全部实时回读；区块卸载后属性回读为 undefined 而不报错。"
---

::api-declaration{ kind="handle" name="Chunk" wraps="net.minecraft.world.level.chunk.LevelChunk"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `blockEntities` | `Array<`[BlockPos](blockpos)`>` | 区块内方块实体位置；未加载或无方块实体时为空数组。 :api-badge{kind="readonly"} |
| `chunkX` | `number` | 区块 x 坐标。 :api-badge{kind="readonly"} |
| `chunkZ` | `number` | 区块 z 坐标。 :api-badge{kind="readonly"} |
| `heightmaps` | `Record<string, unknown>` | 已就绪高度图 {type: number[256]}，索引 localX + localZ * 16；未加载时为 null。 :api-badge{kind="readonly"} |
| `inhabitedTime` | `number` | 区块驻留 tick 数；未加载时为 null。 :api-badge{kind="readonly"} |
| `maxY` | `number` | 区块最高可建造 y；未加载时为 null。 :api-badge{kind="readonly"} |
| `minY` | `number` | 区块最低可建造 y；未加载时为 null。 :api-badge{kind="readonly"} |

## Methods

### `biomeAt(x: number, y: number, z: number)`

区块内坐标处的群系标识；未加载时为 null。

**Parameters**

- `x` `number`: 世界坐标 X
- `y` `number`: 世界坐标 Y
- `z` `number`: 世界坐标 Z

**Returns** `string`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `contains(x: number, y: number, z: number)`

判断世界坐标是否落在本区块内。

**Parameters**

- `x` `number`: 世界坐标 X
- `y` `number`: 世界坐标 Y
- `z` `number`: 世界坐标 Z

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `heightAt(x: number, z: number)`

区块内世界坐标处的地表高度（world surface）；未加载时为 null。

**Parameters**

- `x` `number`: 世界坐标 X
- `z` `number`: 世界坐标 Z

**Returns** `number`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `toJSON()`

Plain-object rendering used by JSON.stringify.

**Returns** `Record<string, unknown>`

:api-badges{ since="0.2.0"}

### `toString()`



**Returns** `string`

:api-badges{ since="0.2.0"}

