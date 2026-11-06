---
title: "Abilities"
description: "本地玩家能力句柄：创造模式旗标与速度倍率，实时可读、客户端可写。联机服务器保有飞行决定权，写入可能被纠正。"
---

Handle · Wraps: `net.minecraft.world.entity.player.Abilities`

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `flySpeed` | `number` | 飞行速度倍率。 (read-only) |
| `flying` | `boolean` | 玩家当前是否飞行中。 (read-only) |
| `instabuild` | `boolean` | 玩家是否瞬间破坏方块。 (read-only) |
| `invulnerable` | `boolean` | 玩家是否免受伤害。 (read-only) |
| `walkingSpeed` | `number` | 行走速度倍率。 (read-only) |

## Methods

### `mayBuild()`

玩家是否可建造与破坏。

**Returns** `boolean`

Since: 0.2.0 · MC: * · Loader: *

### `mayFly()`

玩家是否允许切换飞行。

**Returns** `boolean`

Since: 0.2.0 · MC: * · Loader: *

### `setFlySpeed(value: number)`

设置飞行速度倍率（客户端写）。

**Parameters**

- `value` `number`: 

**Returns** `Promise<void>`

Since: 0.2.0 · MC: * · Loader: *

### `setFlying(value: boolean)`

切换飞行（客户端写；服务器可能收回）。

**Parameters**

- `value` `boolean`: 

**Returns** `Promise<void>`

Since: 0.2.0 · MC: * · Loader: *

### `setWalkingSpeed(value: number)`

设置行走速度倍率（客户端写）。

**Parameters**

- `value` `number`: 

**Returns** `Promise<void>`

Since: 0.2.0 · MC: * · Loader: *

