---
title: "world:blockUpdate"
description: "方块更新时触发（高流量事件）。"
---

::api-event-header{ event="world:blockUpdate" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`WorldBlockUpdateEvent`](../types/WorldBlockUpdateEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `id` | `string` | 新方块标识（如 minecraft:stone） |
| `pos` | :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'} | 方块网格坐标（BlockPos 实例） |

