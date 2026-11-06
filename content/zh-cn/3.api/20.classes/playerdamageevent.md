---
title: "PlayerDamageEvent"
description: "本地玩家受伤事件载荷；携带损失量与受伤后的生命值。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`player:damage`](../events/player/player-damage)
::

| Field | Type | Description |
| --- | --- | --- |
| `amount` | `number` | 损失的生命值 |
| `health` | `number` | 受伤后的生命值 |

