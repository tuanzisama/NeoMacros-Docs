---
title: "PlayerRespawnEvent"
description: "本地玩家重生事件载荷。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`player:respawn`](../events/player/player-respawn)
::

| Field | Type | Description |
| --- | --- | --- |
| `player` | [EntitySnapshot](../classes/entitysnapshot) | 玩家的时点快照 |

