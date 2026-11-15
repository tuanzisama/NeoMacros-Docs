---
title: "world:time"
description: "Payload of the world time jump event; fires only for discontinuous changes (time set, day skip), not for the normal one-tick-per-tick advance."
---

::api-event-header{ event="world:time" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`WorldTimeEvent`](../types/WorldTimeEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `time` | `number` |  |

