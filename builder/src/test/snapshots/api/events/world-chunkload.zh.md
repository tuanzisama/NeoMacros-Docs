---
title: "world:chunkLoad"
description: "客户端区块加载时触发。"
---

::api-event-header{ event="world:chunkLoad" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`WorldChunkLoadEvent`](../types/WorldChunkLoadEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `chunk` | :api-type{text='ChunkPos' refs='ChunkPos=classes/chunkpos'} | 区块坐标（ChunkPos 实例） |

