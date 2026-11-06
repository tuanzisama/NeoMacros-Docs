---
title: "TickEvent"
description: "每客户端 tick 事件载荷；高流量事件，默认不进通配分发。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`tick`](../events/tick/tick)
::

| Field | Type | Description |
| --- | --- | --- |
| `count` | `number` | 本次会话的累计 tick 计数 |

