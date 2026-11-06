---
title: "world"
description: "neo.world 门面：对已加载客户端世界的查询。位置使用普通世界坐标；结果为纯时点对象。"
---

Category: 世界 · Since: 0.1.0 · MC availability: * · Loader availability: * · Exposed as `neo.world` and `@neomacros/world`

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `age` | `number` | 世界总龄（tick）。 (read-only) |
| `bossBars` | `Array<Record<string, unknown>>` | 当前显示的 Boss 条数组 [{uuid, name, progress, color}]；无 Boss 条时为空数组。 (read-only) |
| `day` | `number` | 当前天数。 (read-only) |
| `difficulty` | `string` | 难度标识，如 normal。 (read-only) |
| `dimension` | `string` | 当前维度标识，如 minecraft:overworld。 (read-only) |
| `levelName` | `string` | 当前存档或服务器名称；未加载世界时为空字符串。 (read-only) |
| `moonPhase` | `number` | 当前月相序号（0 为满月，4 为新月）。 (read-only) |
| `raining` | `boolean` | 当前是否在下雨。 (read-only) |
| `scoreboards` | `Record<string, unknown>` | 客户端记分板 {objectives, scores}；objectives 条目含 name, displayName, criteria, renderType，scores 条目含 objective, owner, value；无世界时为 null。 (read-only) |
| `tabList` | `Record<string, unknown>` | 客户端 Tab 列表 {header, footer, entries}；条目含 uuid, name, latency, gamemode, displayName；无世界时为 null。 (read-only) |
| `thundering` | `boolean` | 当前是否在打雷。 (read-only) |
| `time` | `number` | 当前世界时间（tick）。 (read-only) |
| `tps` | `Record<string, unknown>` | 由时间同步包采样得到的远端 tick 速率估计 {instant, m1, m5, m15}（每秒 tick 数）；尚无采样时为 null。 (read-only) |

## Methods

### `biomeAt(x: number, y: number, z: number)`

查询坐标处群系标识。

**Parameters**

- `x` `number`: 
- `y` `number`: 
- `z` `number`: 

**Returns** `string`

Since: 0.1.0 · MC: * · Loader: *

### `blockAt(x: number, y: number, z: number)`

查询坐标处方块；不在已加载世界内时返回 null。

**Parameters**

- `x` `number`: 世界坐标 X
- `y` `number`: 世界坐标 Y
- `z` `number`: 世界坐标 Z

**Returns** [Block](../../classes/block) — {id, pos:{x,y,z}} 或 null

Since: 0.1.0 · MC: * · Loader: *

### `chunkLoaded(chunk: ChunkPos)`

判断区块是否已加载。

**Parameters**

- `chunk` [ChunkPos](../../classes/chunkpos): 区块坐标

**Returns** `boolean`

Since: 0.2.0 · MC: * · Loader: *

### `loaded(x: number, y: number, z: number)`

判断坐标所在区块是否已加载。

**Parameters**

- `x` `number`: 
- `y` `number`: 
- `z` `number`: 

**Returns** `boolean`

Since: 0.1.0 · MC: * · Loader: *

### `playSound(soundId: string, x: number, y: number, z: number, volume: number, pitch: number)`

本地播放声音：给出坐标且世界已加载时按世界位置播放，否则走 UI 声音通道；未知的 soundId 抛错。

**Parameters**

- `soundId` `string`: 声音标识，可省略 minecraft: 命名空间
- `x` `number`: 世界坐标 X
- `y` `number`: 世界坐标 Y
- `z` `number`: 世界坐标 Z
- `volume` `number`: 音量，默认 1
- `pitch` `number`: 音调，默认 1

Since: 0.2.0 · MC: * · Loader: *

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

Since: 0.1.0 · MC: * · Loader: *

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

Since: 0.2.0 · MC: * · Loader: *


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
