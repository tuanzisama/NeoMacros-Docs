---
title: "WorldChunkUnloadEvent"
description: "Payload of the client chunk unload event; fires when the server drops a chunk from the client's view."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`world:chunkUnload`](../events/world/world-chunkunload.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `chunk` | :api-type{text='ChunkPos' refs='ChunkPos=classes/chunkpos'} |  |

