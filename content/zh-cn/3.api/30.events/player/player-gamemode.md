---
title: "player:gamemode"
description: "游戏模式变化事件载荷。"
---

::api-event-header{ event="player:gamemode" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerGamemodeEvent`](../../classes/playergamemodeevent)
::

| Field | Type | Description |
| --- | --- | --- |
| `current` | `string` | 当前模式 |
| `previous` | `string` | 先前模式（survival/creative/adventure/spectator） |

