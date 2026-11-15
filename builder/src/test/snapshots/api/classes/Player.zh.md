---
title: "Player"
description: "玩家句柄：实体读面经实体端口（远端玩家同样可用）；饥饿/氧气/游戏模式/经验等本地字段经玩家端口，远端玩家读为 undefined。"
---

::api-declaration{ kind="handle" name="Player" wraps="net.minecraft.world.entity.player.Player"}
#extends
[`LivingEntity`](LivingEntity.html)
#extended-by
[`LocalPlayer`](LocalPlayer.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `air` | `number` | 氧气值；仅本地玩家有值。 :api-badge{kind="readonly"} |
| `gamemode` | `string` | 游戏模式标识（survival/creative/adventure/spectator）；仅本地玩家有值。 :api-badge{kind="readonly"} |
| `health` | `number` | 生命值；本地玩家经玩家端口读取（生命在玩家快照上），远端玩家回退到实体快照。 :api-badge{kind="readonly"} |
| `hunger` | `number` | 饥饿值；仅本地玩家有值。 :api-badge{kind="readonly"} |
| `inventory` | :api-type{text='PlayerInventory' refs='PlayerInventory=classes/playerinventory'} | 玩家自己的物品栏；仅本地玩家有值。 :api-badge{kind="readonly"} |
| `saturation` | `number` | 饱和度；仅本地玩家有值。 :api-badge{kind="readonly"} |
| `xp` | :api-type{text='XpInfo' refs='XpInfo=classes/xpinfo'} | 经验 {level, progress, total}；仅本地玩家有值。 :api-badge{kind="readonly"} |

## Methods

::api-method

### `snapshot`

返回时点快照；玩家未加载时返回 null。

**Returns** :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `toJSON`

JSON 字符串；本地玩家经玩家视图输出。

**Returns** `string`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

