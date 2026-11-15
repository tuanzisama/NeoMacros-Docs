---
title: "entity:spawn"
description: "实体进入/离开跟踪范围时触发。"
---

::api-event-header{ event="entity:spawn" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`EntitySpawnEvent`](../types/EntitySpawnEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `entityTypeId` | `string` | 实体类型标识 |
| `uuid` | `string` | 实体 UUID |

