---
title: "WorldTimeEvent"
description: "世界时间跳变事件载荷；仅时间被不连续修改（设置时间/跳过夜晚）时触发， 正常每 tick 推进不触发。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`world:time`](../events/world/world-time)
::

| Field | Type | Description |
| --- | --- | --- |
| `time` | `number` | 跳变后的世界时间 |

