---
title: "LocalPlayer"
description: "本地玩家动作面：attack/interact/swing/drop 经游戏主线程派发，处理完成后落定。"
---

Handle · Wraps: `net.minecraft.client.player.LocalPlayer` · Extends: [`Player`](player)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `blockInteractionRange` | `number` | 方块交互距离（格）。 (read-only) |
| `breakingBlock` | `boolean` | 本地玩家是否正在挖掘方块。 (read-only) |
| `entityInteractionRange` | `number` | 实体交互距离（格）。 (read-only) |
| `statistics` | `Record<string, number>` | 客户端统计 类型id:条目id -> 数值；仅含非零值；无世界时为 null。 (read-only) |

## Methods

### `attack(target: Entity)`

攻击目标句柄背后的实体。

**Parameters**

- `target` [Entity](entity): 

**Returns** `Promise<void>`

Since: 0.1.0 · MC: * · Loader: *

### `dropHeld(all: boolean)`

丢弃手持物品（all = 整组）。

**Parameters**

- `all` `boolean`: 

**Returns** `Promise<void>`

Since: 0.1.0 · MC: * · Loader: *

### `interactBlock(pos: BlockPos)`

与坐标句柄背后的方块交互（右键）。

**Parameters**

- `pos` [BlockPos](blockpos): 

**Returns** `Promise<void>`

Since: 0.1.0 · MC: * · Loader: *

### `interactEntity(target: Entity)`

与目标句柄背后的实体交互（右键）。

**Parameters**

- `target` [Entity](entity): 

**Returns** `Promise<void>`

Since: 0.1.0 · MC: * · Loader: *

### `swingHand(offhand: boolean)`

挥动手（offhand = 副手）。

**Parameters**

- `offhand` `boolean`: 

**Returns** `Promise<void>`

Since: 0.1.0 · MC: * · Loader: *

### `toString()`

人类可读形式。

**Returns** `string`

