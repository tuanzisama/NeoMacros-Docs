---
title: "PlayerRidingEvent"
description: "乘坐状态变化事件载荷；vehicle 为 null 表示玩家已下车。"
---

::api-type-header{ since="0.2.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`player:riding`](../events/player/player-riding.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `vehicle` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} | 所乘坐实体的快照；下车时为 null |

