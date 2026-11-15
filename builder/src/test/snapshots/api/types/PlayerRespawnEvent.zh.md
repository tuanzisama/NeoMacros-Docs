---
title: "PlayerRespawnEvent"
description: "本地玩家重生事件载荷。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`player:respawn`](../events/player/player-respawn.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `player` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} | 玩家的时点快照 |

