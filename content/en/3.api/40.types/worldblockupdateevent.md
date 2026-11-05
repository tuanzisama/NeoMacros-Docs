---
title: "WorldBlockUpdateEvent"
---

Extends: [`BaseEvent`](baseevent) · Raised by: [`world:blockUpdate`](../events/world/world-blockupdate) · Since: 0.1.0 · MC: * · Loader: *

Payload of the block update event; fires for each block state change the client receives. High-traffic event: the payload carries only the fields needed to locate the change, and it is excluded from wildcard matching by default.

| Field | Type | Description |
| --- | --- | --- |
| `id` | `string` |  |
| `pos` | [BlockPos](../classes/blockpos) |  |

