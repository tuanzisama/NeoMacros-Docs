---
title: "WorldChunkUnloadEvent"
description: "Payload of the client chunk unload event; fires when the server drops a chunk from the client's view."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`world:chunkUnload`](../events/world/world-chunkunload)
::

| Field | Type | Description |
| --- | --- | --- |
| `chunk` | [ChunkPos](../classes/chunkpos) |  |

