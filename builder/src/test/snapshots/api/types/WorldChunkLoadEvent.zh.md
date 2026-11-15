---
title: "WorldChunkLoadEvent"
description: "客户端区块加载时触发。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`world:chunkLoad`](../events/world/world-chunkload.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `chunk` | :api-type{text='ChunkPos' refs='ChunkPos=classes/chunkpos'} | 区块坐标（ChunkPos 实例） |

