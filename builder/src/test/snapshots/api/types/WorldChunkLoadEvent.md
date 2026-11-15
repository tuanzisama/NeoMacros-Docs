---
title: "WorldChunkLoadEvent"
description: "Payload of the client chunk load event; fires when a chunk arrives from the server."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`world:chunkLoad`](../events/world/world-chunkload.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `chunk` | :api-type{text='ChunkPos' refs='ChunkPos=classes/chunkpos'} |  |

