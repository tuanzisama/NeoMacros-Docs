---
title: "WorldBlockUpdateEvent"
description: "Payload of the block update event; fires for each block state change the client receives. High-traffic event: the payload carries only the fields needed to locate the change, and it is excluded from wildcard matching by default."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`world:blockUpdate`](../events/world/world-blockupdate)
::

| Field | Type | Description |
| --- | --- | --- |
| `id` | `string` |  |
| `pos` | [BlockPos](../classes/blockpos) |  |

