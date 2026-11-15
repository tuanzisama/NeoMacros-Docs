---
title: "WorldTimeEvent"
description: "Payload of the world time jump event; fires only for discontinuous changes (time set, day skip), not for the normal one-tick-per-tick advance."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`world:time`](../events/world/world-time.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `time` | `number` |  |

