---
title: "Player"
description: ""
---

::api-declaration{ kind="handle" name="Player" wraps="net.minecraft.world.entity.player.Player"}
#extends
[`LivingEntity`](livingentity)
#extended-by
[`LocalPlayer`](localplayer)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `air` | `number` | 氧气值；仅本地玩家有值。 :api-badge{kind="readonly"} |
| `gamemode` | `string` | 游戏模式标识（survival/creative/adventure/spectator）；仅本地玩家有值。 :api-badge{kind="readonly"} |
| `health` | `number` | 生命值；本地玩家经玩家端口读取（生命在玩家快照上），远端玩家回退到实体快照。 :api-badge{kind="readonly"} |
| `hunger` | `number` | 饥饿值；仅本地玩家有值。 :api-badge{kind="readonly"} |
| `inventory` | [PlayerInventory](playerinventory) | 玩家自己的物品栏；仅本地玩家有值。 :api-badge{kind="readonly"} |
| `saturation` | `number` | 饱和度；仅本地玩家有值。 :api-badge{kind="readonly"} |
| `xp` | `Record<string, unknown>` | 经验 {level, progress, total}；仅本地玩家有值。 :api-badge{kind="readonly"} |

## Methods

### `snapshot()`

返回时点快照；玩家未加载时返回 null。

**Returns** [EntitySnapshot](entitysnapshot)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `toJSON()`

JSON 形式；本地玩家经玩家视图输出。

**Returns** `Record<string, unknown>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `toString()`

人类可读形式。

**Returns** `string`

