---
title: "Abilities"
description: "本地玩家能力句柄：创造模式旗标与速度倍率，实时可读、客户端可写。联机服务器保有飞行决定权，写入可能被纠正。"
---

::api-declaration{ kind="handle" name="Abilities" wraps="net.minecraft.world.entity.player.Abilities"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `flySpeed` | `number` | 飞行速度倍率。 :api-badge{kind="readonly"} |
| `flying` | `boolean` | 玩家当前是否飞行中。 :api-badge{kind="readonly"} |
| `instabuild` | `boolean` | 玩家是否瞬间破坏方块。 :api-badge{kind="readonly"} |
| `invulnerable` | `boolean` | 玩家是否免受伤害。 :api-badge{kind="readonly"} |
| `walkingSpeed` | `number` | 行走速度倍率。 :api-badge{kind="readonly"} |

## Methods

### `mayBuild()`

玩家是否可建造与破坏。

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `mayFly()`

玩家是否允许切换飞行。

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `setFlySpeed(value: number)`

设置飞行速度倍率（客户端写）。

**Parameters**

- `value` `number`: 

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `setFlying(value: boolean)`

切换飞行（客户端写；服务器可能收回）。

**Parameters**

- `value` `boolean`: 

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `setWalkingSpeed(value: number)`

设置行走速度倍率（客户端写）。

**Parameters**

- `value` `number`: 

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

