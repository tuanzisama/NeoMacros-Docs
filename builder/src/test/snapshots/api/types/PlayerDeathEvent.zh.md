---
title: "PlayerDeathEvent"
description: "本地玩家死亡事件载荷。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`player:death`](../events/player/player-death.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `player` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} | 玩家的时点快照 |

