---
title: "PlayerExpEvent"
description: "经验值变化事件载荷。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`player:exp`](../events/player/player-exp)
::

| Field | Type | Description |
| --- | --- | --- |
| `change` | `number` | 经验值增量 |
| `level` | `number` | 当前经验等级 |
| `progress` | `number` | 当前等级进度（0.0-1.0） |

