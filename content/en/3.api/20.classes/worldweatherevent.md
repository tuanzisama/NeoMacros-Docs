---
title: "WorldWeatherEvent"
description: "Payload of the weather change event."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`world:weather`](../events/world/world-weather)
::

| Field | Type | Description |
| --- | --- | --- |
| `raining` | `boolean` |  |
| `thundering` | `boolean` |  |

