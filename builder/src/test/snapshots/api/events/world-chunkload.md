---
title: "world:chunkLoad"
description: "Payload of the client chunk load event; fires when a chunk arrives from the server."
---

::api-event-header{ event="world:chunkLoad" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`WorldChunkLoadEvent`](../types/WorldChunkLoadEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `chunk` | :api-type{text='ChunkPos' refs='ChunkPos=classes/chunkpos'} |  |

