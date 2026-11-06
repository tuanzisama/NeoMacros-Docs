---
title: "EntitySpawnEvent"
description: "实体进入/离开跟踪范围时触发。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`entity:spawn`](../events/entity/entity-spawn)
::

| Field | Type | Description |
| --- | --- | --- |
| `entityTypeId` | `string` | 实体类型标识 |
| `uuid` | `string` | 实体 UUID |

