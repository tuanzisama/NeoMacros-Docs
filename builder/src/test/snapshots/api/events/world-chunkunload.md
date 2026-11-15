---
title: "world:chunkUnload"
description: "Payload of the client chunk unload event; fires when the server drops a chunk from the client's view."
---

::api-event-header{ event="world:chunkUnload" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`WorldChunkUnloadEvent`](../types/WorldChunkUnloadEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `chunk` | :api-type{text='ChunkPos' refs='ChunkPos=classes/chunkpos'} |  |

