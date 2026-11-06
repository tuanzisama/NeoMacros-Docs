---
title: "PlayerDimensionChangeEvent"
description: "本地玩家切换维度事件载荷。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`player:dimensionChange`](../events/player/player-dimensionchange)
::

| Field | Type | Description |
| --- | --- | --- |
| `from` | `string` | 原维度标识 |
| `to` | `string` | 新维度标识 |

