---
title: "world:blockUpdate"
description: "Payload of the block update event; fires for each block state change the client receives. High-traffic event: the payload carries only the fields needed to locate the change, and it is excluded from wildcard matching by default."
---

Payload: [`WorldBlockUpdateEvent`](../../classes/worldblockupdateevent) · Since: 0.1.0 · MC: * · Loader: *

| Field | Type | Description |
| --- | --- | --- |
| `id` | `string` |  |
| `pos` | [BlockPos](../classes/blockpos) |  |

