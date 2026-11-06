---
title: "PlayerGamemodeEvent"
description: "游戏模式变化事件载荷。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`player:gamemode`](../events/player/player-gamemode)
::

| Field | Type | Description |
| --- | --- | --- |
| `current` | `string` | 当前模式 |
| `previous` | `string` | 先前模式（survival/creative/adventure/spectator） |

