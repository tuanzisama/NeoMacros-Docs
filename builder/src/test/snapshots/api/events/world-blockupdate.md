---
title: "world:blockUpdate"
description: "Payload of the block update event; fires for each block state change the client receives. High-traffic event: the payload carries only the fields needed to locate the change, and it is excluded from wildcard matching by default."
---

::api-event-header{ event="world:blockUpdate" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`WorldBlockUpdateEvent`](../types/WorldBlockUpdateEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `id` | `string` |  |
| `pos` | :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'} |  |

