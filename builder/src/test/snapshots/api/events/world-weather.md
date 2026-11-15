---
title: "world:weather"
description: "Payload of the weather change event."
---

::api-event-header{ event="world:weather" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`WorldWeatherEvent`](../types/WorldWeatherEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `raining` | `boolean` |  |
| `thundering` | `boolean` |  |

