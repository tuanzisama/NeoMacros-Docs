---
title: "WorldBlockUpdateEvent"
description: "方块更新时触发（高流量事件）。"
---

Extends: [`BaseEvent`](baseevent) · Raised by: [`world:blockUpdate`](../events/world/world-blockupdate) · Since: 0.1.0 · MC: * · Loader: *

| Field | Type | Description |
| --- | --- | --- |
| `id` | `string` | 新方块标识（如 minecraft:stone） |
| `pos` | [BlockPos](../classes/blockpos) | 方块网格坐标（BlockPos 实例） |

