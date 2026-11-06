---
title: "WorldWeatherEvent"
description: "天气变化事件载荷。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`world:weather`](../events/world/world-weather)
::

| Field | Type | Description |
| --- | --- | --- |
| `raining` | `boolean` | 是否在下雨 |
| `thundering` | `boolean` | 是否在打雷 |

