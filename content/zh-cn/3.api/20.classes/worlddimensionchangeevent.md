---
title: "WorldDimensionChangeEvent"
description: "客户端世界切换维度事件载荷。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`world:dimensionChange`](../events/world/world-dimensionchange)
::

| Field | Type | Description |
| --- | --- | --- |
| `from` | `string` | 原维度标识 |
| `to` | `string` | 新维度标识 |

