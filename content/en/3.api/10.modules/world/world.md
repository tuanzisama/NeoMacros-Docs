---
title: "world"
description: "The neo.world facade: world queries over the loaded client world. Positions use plain world coordinates; results are plain point-in-time objects."
---

:api-module-header{ category="World" global="true" neo-name="neo.world" esm-name="@neomacros/world" since="0.1.0" mc="*" loader="*"}

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `age` | `number` | The total world age in ticks. :api-badge{kind="readonly"} |
| `bossBars` | `Array<Record<string, unknown>>` | The boss bars currently displayed as [{uuid, name, progress, color}]; empty list when none. :api-badge{kind="readonly"} |
| `day` | `number` | The current day count. :api-badge{kind="readonly"} |
| `difficulty` | `string` | The difficulty identifier, e.g. normal. :api-badge{kind="readonly"} |
| `dimension` | `string` | The dimension identifier of the loaded world, e.g. minecraft:overworld. :api-badge{kind="readonly"} |
| `levelName` | `string` | The loaded save or server name; an empty string without a world. :api-badge{kind="readonly"} |
| `moonPhase` | `number` | The current moon phase index (0 = full moon, 4 = new moon). :api-badge{kind="readonly"} |
| `raining` | `boolean` | Whether rain is currently falling. :api-badge{kind="readonly"} |
| `scoreboards` | `Record<string, unknown>` | The client scoreboard as {objectives, scores}; objectives carry name, displayName, criteria, renderType, scores carry objective, owner, value, or null without a world. :api-badge{kind="readonly"} |
| `tabList` | `Record<string, unknown>` | The client tab list as {header, footer, entries}; entries carry uuid, name, latency, gamemode, displayName, or null without a world. :api-badge{kind="readonly"} |
| `thundering` | `boolean` | Whether thunder is currently falling. :api-badge{kind="readonly"} |
| `time` | `number` | The world time of day in ticks. :api-badge{kind="readonly"} |
| `tps` | `Record<string, unknown>` | The remote tick rate estimate sampled from time sync packets: {instant, m1, m5, m15} in ticks per second, or null before the first sample. :api-badge{kind="readonly"} |

## Methods

### `biomeAt(x: number, y: number, z: number)`

The biome identifier at the position.

**Parameters**

- `x` `number`: 
- `y` `number`: 
- `z` `number`: 

**Returns** `string`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `blockAt(x: number, y: number, z: number)`

Returns the block at the coordinates, or null when outside the loaded world.

**Parameters**

- `x` `number`: 世界坐标 X
- `y` `number`: 世界坐标 Y
- `z` `number`: 世界坐标 Z

**Returns** [Block](../../classes/block)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `chunkAt(x: number, y: number, z: number)`

The loaded chunk containing the coordinates as a Chunk handle, or null when unloaded.

**Parameters**

- `x` `number`: 世界坐标 X
- `y` `number`: 世界坐标 Y（决定所在子区块高度，通常取 64）
- `z` `number`: 世界坐标 Z

**Returns** [Chunk](../../classes/chunk)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `chunkLoaded(chunk: ChunkPos)`

Whether the chunk is loaded.

**Parameters**

- `chunk` [ChunkPos](../../classes/chunkpos): 区块坐标

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `findBlocks(options: Record<string, unknown>)`

Scans the cube around the center for blocks matching one of the given block ids and returns their positions as Block handles. The scan range is capped at 32 blocks and the result at 512 entries to keep the main thread responsive; unknown ids are ignored.

**Parameters**

- `options` `Record<string, unknown>`: 扫描选项：{types: string|string[], center: {x,y,z}, range?: number, limit?: number}

**Returns** `Array<`[Block](../../classes/block)`>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `loaded(x: number, y: number, z: number)`

Whether the chunk containing the position is loaded.

**Parameters**

- `x` `number`: 
- `y` `number`: 
- `z` `number`: 

**Returns** `boolean`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `playSound(soundId: string, x: number, y: number, z: number, volume: number, pitch: number)`

Plays a sound locally. With coordinates the sound plays at the world position (requires a loaded world); otherwise it plays through the UI sound channel. Unknown identifiers throw.

**Parameters**

- `soundId` `string`: 声音标识，可省略 minecraft: 命名空间
- `x` `number`: 世界坐标 X
- `y` `number`: 世界坐标 Y
- `z` `number`: 世界坐标 Z
- `volume` `number`: 音量，默认 1
- `pitch` `number`: 音调，默认 1

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `raycast(fromX: number, fromY: number, fromZ: number, toX: number, toY: number, toZ: number)`

Casts a ray from one point toward another and returns the first hit, or null when unobstructed or no world is loaded.

**Parameters**

- `fromX` `number`: 起点坐标 X
- `fromY` `number`: 起点坐标 Y
- `fromZ` `number`: 起点坐标 Z
- `toX` `number`: 终点坐标 X
- `toY` `number`: 终点坐标 Y
- `toZ` `number`: 终点坐标 Z

**Returns** [RayHit](../../classes/rayhit)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `spawnParticle(particleId: string, x: number, y: number, z: number, count: number, offsetX: number, offsetY: number, offsetZ: number, speed: number)`

Spawns particles locally around the position; unknown identifiers or data-carrying particle types throw.

**Parameters**

- `particleId` `string`: 粒子类型标识，可省略 minecraft: 命名空间
- `x` `number`: 世界坐标 X
- `y` `number`: 世界坐标 Y
- `z` `number`: 世界坐标 Z
- `count` `number`: 粒子数量
- `offsetX` `number`: 粒子散布半径 X
- `offsetY` `number`: 粒子散布半径 Y
- `offsetZ` `number`: 粒子散布半径 Z
- `speed` `number`: 粒子初速

:api-badges{ since="0.2.0" mc="*" loader="*"}


## Examples

Cast a ray between two world points and read snapshot facts about the loaded world.

```js
const { world } = neo;

// Cast a ray straight down between two world points
const hit = world.raycast(128, 320, -212, 128, -64, -212);
if (hit && hit.hit) {
  // hit.pos is the exact impact point; block/entity are mutually exclusive
  const blockId = hit.block?.state?.id; // e.g. 'minecraft:grass_block'
}

// Point-in-time lookups and world facts
const biome = world.biomeAt(128, 64, -212);
const raining = world.raining;
```
