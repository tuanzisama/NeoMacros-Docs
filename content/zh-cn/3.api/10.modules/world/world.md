---
title: "world"
description: "neo.world 门面：对已加载客户端世界的查询。位置使用普通世界坐标；结果为纯时点对象。"
---

:api-module-header{ category="世界" global="true" neo-name="neo.world" esm-name="@neomacros/world" since="0.1.0" mc="*" loader="*"}

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `age` | `number` | 世界总龄（tick）。 :api-badge{kind="readonly"} |
| `bossBars` | `Array<Record<string, unknown>>` | 当前显示的 Boss 条数组 [{uuid, name, progress, color}]；无 Boss 条时为空数组。 :api-badge{kind="readonly"} |
| `day` | `number` | 当前天数。 :api-badge{kind="readonly"} |
| `difficulty` | `string` | 难度标识，如 normal。 :api-badge{kind="readonly"} |
| `dimension` | `string` | 当前维度标识，如 minecraft:overworld。 :api-badge{kind="readonly"} |
| `levelName` | `string` | 当前存档或服务器名称；未加载世界时为空字符串。 :api-badge{kind="readonly"} |
| `moonPhase` | `number` | 当前月相序号（0 为满月，4 为新月）。 :api-badge{kind="readonly"} |
| `raining` | `boolean` | 当前是否在下雨。 :api-badge{kind="readonly"} |
| `scoreboards` | `Record<string, unknown>` | 客户端记分板 {objectives, scores}；objectives 条目含 name, displayName, criteria, renderType，scores 条目含 objective, owner, value；无世界时为 null。 :api-badge{kind="readonly"} |
| `tabList` | `Record<string, unknown>` | 客户端 Tab 列表 {header, footer, entries}；条目含 uuid, name, latency, gamemode, displayName；无世界时为 null。 :api-badge{kind="readonly"} |
| `thundering` | `boolean` | 当前是否在打雷。 :api-badge{kind="readonly"} |
| `time` | `number` | 当前世界时间（tick）。 :api-badge{kind="readonly"} |
| `tps` | `Record<string, unknown>` | 由时间同步包采样得到的远端 tick 速率估计 {instant, m1, m5, m15}（每秒 tick 数）；尚无采样时为 null。 :api-badge{kind="readonly"} |

## Methods

### `biomeAt(x: number, y: number, z: number)`

查询坐标处群系标识。

**Parameters**

- `x` `number`: 
- `y` `number`: 
- `z` `number`: 

**Returns** `string`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `blockAt(x: number, y: number, z: number)`

查询坐标处方块；不在已加载世界内时返回 null。

**Parameters**

- `x` `number`: 世界坐标 X
- `y` `number`: 世界坐标 Y
- `z` `number`: 世界坐标 Z

**Returns** [Block](../../classes/block) — {id, pos:{x,y,z}} 或 null

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `chunkAt(x: number, y: number, z: number)`

坐标所在已加载区块的 Chunk 句柄；未加载时为 null。

**Parameters**

- `x` `number`: 世界坐标 X
- `y` `number`: 世界坐标 Y（决定所在子区块高度，通常取 64）
- `z` `number`: 世界坐标 Z

**Returns** [Chunk](../../classes/chunk)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `chunkLoaded(chunk: ChunkPos)`

判断区块是否已加载。

**Parameters**

- `chunk` [ChunkPos](../../classes/chunkpos): 区块坐标

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `findBlocks(options: Record<string, unknown>)`

在中心周围立方体范围内扫描匹配方块 id 的方块，返回 Block 句柄数组。扫描半径上限 32、结果上限 512 以保持主线程响应；未知 id 忽略。

**Parameters**

- `options` `Record<string, unknown>`: 扫描选项：{types: string|string[], center: {x,y,z}, range?: number, limit?: number}

**Returns** `Array<`[Block](../../classes/block)`>` — Block[] 数组

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `loaded(x: number, y: number, z: number)`

判断坐标所在区块是否已加载。

**Parameters**

- `x` `number`: 
- `y` `number`: 
- `z` `number`: 

**Returns** `boolean`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `playSound(soundId: string, x: number, y: number, z: number, volume: number, pitch: number)`

本地播放声音：给出坐标且世界已加载时按世界位置播放，否则走 UI 声音通道；未知的 soundId 抛错。

**Parameters**

- `soundId` `string`: 声音标识，可省略 minecraft: 命名空间
- `x` `number`: 世界坐标 X
- `y` `number`: 世界坐标 Y
- `z` `number`: 世界坐标 Z
- `volume` `number`: 音量，默认 1
- `pitch` `number`: 音调，默认 1

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `raycast(fromX: number, fromY: number, fromZ: number, toX: number, toY: number, toZ: number)`

从起点向终点方向投射射线，返回第一个命中；无命中或无世界时返回 null。

**Parameters**

- `fromX` `number`: 起点坐标 X
- `fromY` `number`: 起点坐标 Y
- `fromZ` `number`: 起点坐标 Z
- `toX` `number`: 终点坐标 X
- `toY` `number`: 终点坐标 Y
- `toZ` `number`: 终点坐标 Z

**Returns** [RayHit](../../classes/rayhit) — {block|entity, pos, distance} 或 null

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `spawnParticle(particleId: string, x: number, y: number, z: number, count: number, offsetX: number, offsetY: number, offsetZ: number, speed: number)`

在坐标附近本地生成粒子；未知 particleId 或需要附加数据的粒子类型抛错。

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

在两个世界坐标点之间做射线检测，并读取已加载世界的快照信息（生物群系、天气等）。

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
