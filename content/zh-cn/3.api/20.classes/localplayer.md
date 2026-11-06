---
title: "LocalPlayer"
description: "本地玩家动作面：attack/interact/swing/drop 经游戏主线程派发，处理完成后落定。"
---

::api-declaration{ kind="handle" name="LocalPlayer" wraps="net.minecraft.client.player.LocalPlayer"}
#extends
[`Player`](player)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `abilities` | [Abilities](abilities) | 实时能力句柄：旗标与速度倍率，可读且客户端可写。 :api-badge{kind="readonly"} |
| `blockInteractionRange` | `number` | 方块交互距离（格）。 :api-badge{kind="readonly"} |
| `breakingBlock` | `boolean` | 本地玩家是否正在挖掘方块。 :api-badge{kind="readonly"} |
| `entityInteractionRange` | `number` | 实体交互距离（格）。 :api-badge{kind="readonly"} |
| `statistics` | `Record<string, number>` | 客户端统计 类型id:条目id -> 数值；仅含非零值；无世界时为 null。 :api-badge{kind="readonly"} |

## Methods

### `attack(target: Entity)`

攻击目标句柄背后的实体。

**Parameters**

- `target` [Entity](entity): 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `dropHeld(all: boolean)`

丢弃手持物品（all = 整组）。

**Parameters**

- `all` `boolean`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `interactBlock(pos: BlockPos)`

与坐标句柄背后的方块交互（右键）。

**Parameters**

- `pos` [BlockPos](blockpos): 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `interactEntity(target: Entity)`

与目标句柄背后的实体交互（右键）。

**Parameters**

- `target` [Entity](entity): 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `itemCooldown(itemId: string)`

物品 id 的冷却进度；无冷却（或物品未知）时为 0。

**Parameters**

- `itemId` `string`: 

**Returns** `number`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `look(yaw: number, pitch: number)`

将视角转向指定 yaw（水平）与 pitch（垂直）角度（度）。

**Parameters**

- `yaw` `number`: 
- `pitch` `number`: 

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `lookAt(target: Entity)`

将视角转向目标句柄背后的实体。

**Parameters**

- `target` [Entity](entity): 

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `setVelocity(x: number, y: number, z: number)`

设置移动速度向量（客户端写）。

**Parameters**

- `x` `number`: 
- `y` `number`: 
- `z` `number`: 

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `swingHand(offhand: boolean)`

挥动手（offhand = 副手）。

**Parameters**

- `offhand` `boolean`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `teleport(x: number, y: number, z: number)`

将本地玩家移动到该位置（客户端写；联机服务器会把位置纠正回去）。

**Parameters**

- `x` `number`: 
- `y` `number`: 
- `z` `number`: 

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `toString()`

人类可读形式。

**Returns** `string`

