---
title: "PlayerSpawnEvent"
description: "本地玩家出生事件载荷（世界会话的首次出生）。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`player:spawn`](../events/player/player-spawn.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `player` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} | 玩家的时点快照 |

