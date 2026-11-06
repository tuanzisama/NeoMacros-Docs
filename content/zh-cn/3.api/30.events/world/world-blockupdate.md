---
title: "world:blockUpdate"
description: "方块更新时触发（高流量事件）。"
---

::api-event-header{ event="world:blockUpdate" since="0.1.0" mc="*" loader="*"}
#payload
[`WorldBlockUpdateEvent`](../../classes/worldblockupdateevent)
::

| Field | Type | Description |
| --- | --- | --- |
| `id` | `string` | 新方块标识（如 minecraft:stone） |
| `pos` | [BlockPos](../classes/blockpos) | 方块网格坐标（BlockPos 实例） |

