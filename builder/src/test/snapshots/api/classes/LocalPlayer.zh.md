---
title: "LocalPlayer"
description: "本地玩家动作面：attack/interact/swing/drop 经游戏主线程派发，处理完成后落定。"
---

::api-declaration{ kind="handle" name="LocalPlayer" wraps="net.minecraft.client.player.LocalPlayer"}
#extends
[`Player`](Player.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `abilities` | :api-type{text='Abilities' refs='Abilities=classes/abilities'} | 实时能力句柄：旗标与速度倍率，可读且客户端可写。 :api-badge{kind="readonly"} |
| `advancements` | :api-type{text='Advancements' refs='Advancements=classes/advancements'} | 客户端已知的进度：树查询加逐条进度。无服务器连接时为 null。 :api-badge{kind="readonly"} |
| `blockInteractionRange` | `number` | 方块交互距离（格）：生存基线 4.5；创造修饰提升到 5.0；属性修饰符生效。 :api-badge{kind="readonly"} |
| `breakingBlock` | `boolean` | 本地玩家是否正在挖掘方块。 :api-badge{kind="readonly"} |
| `entityInteractionRange` | `number` | 实体交互距离（格）：生存基线 3.0；创造修饰提升到 3.5；属性修饰符生效。 :api-badge{kind="readonly"} |
| `statistics` | :api-type{text='Statistics' refs='Statistics=classes/statistics'} | 客户端统计句柄：活统计计数器上的分类查询。无世界时为 null。 :api-badge{kind="readonly"} |
| `target` | :api-type{text='Target' refs='Target=classes/target'} | 准星选取：交互距离内的第一个方块或实体，每次访问实时回读。无世界时为 null。 :api-badge{kind="readonly"} |

## Methods

::api-method

### `attack`

攻击目标句柄背后的实体。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `target` | :api-type{text='Entity' refs='Entity=classes/entity'} |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `attackBlock`

开始破坏坐标处方块的指定面（默认 up）：挥手并进入破坏流程；瞬挖方块立即完成，更硬的方块开始挖掘进度（需要按住攻击键推进）；未知面抛错。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `pos` | :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'} |  | — | — |
| `face` | `string` |  | ✓ | — |

**Returns** `Promise<void>`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `dropHeld`

丢弃手持物品（all = 整组）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `all` | `boolean` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `interactBlock`

与坐标句柄背后的方块在指定面上交互（右键），面可选 up/down/north/south/east/west（默认 up），手可选 main/off（默认 main）；未知面抛错。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `pos` | :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'} |  | — | — |
| `face` | `string` |  | ✓ | — |
| `hand` | `string` |  | ✓ | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `interactEntity`

与目标句柄背后的实体交互（右键），可用手为 main/off（默认 main）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `target` | :api-type{text='Entity' refs='Entity=classes/entity'} |  | — | — |
| `hand` | `string` |  | ✓ | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `interactItem`

在空中对手持物品执行使用（右键），可用手为 main/off（默认 main）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `hand` | `string` |  | ✓ | — |

**Returns** `Promise<void>`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `itemCooldown`

物品 id 的冷却进度；无冷却（或物品未知）时为 0。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `itemId` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `look`

将视角转向指定 yaw（水平）与 pitch（垂直）角度（度）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `yaw` | `number` |  | — | — |
| `pitch` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `lookAt`

将视角转向目标句柄背后的实体。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `target` | :api-type{text='Entity' refs='Entity=classes/entity'} |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `setVelocity`

设置移动速度向量（客户端写）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `x` | `number` |  | — | — |
| `y` | `number` |  | — | — |
| `z` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `stopBreaking`

结束正在进行的方块破坏（与松开攻击键同路）。

**Returns** `Promise<void>`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `swingHand`

挥动手（offhand = 副手）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `offhand` | `boolean` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `teleport`

将本地玩家移动到该位置（客户端写；联机服务器会把位置纠正回去）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `x` | `number` |  | — | — |
| `y` | `number` |  | — | — |
| `z` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

