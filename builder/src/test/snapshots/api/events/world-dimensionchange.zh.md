---
title: "world:dimensionChange"
description: "客户端世界切换维度事件载荷。"
---

::api-event-header{ event="world:dimensionChange" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`WorldDimensionChangeEvent`](../types/WorldDimensionChangeEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `from` | `string` | 原维度标识 |
| `to` | `string` | 新维度标识 |

