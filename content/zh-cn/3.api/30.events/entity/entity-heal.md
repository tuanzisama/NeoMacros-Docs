---
title: "entity:heal"
description: "实体恢复时触发。"
---

::api-event-header{ event="entity:heal" since="0.1.0" mc="*" loader="*"}
#payload
[`EntityHealEvent`](../../classes/entityhealevent)
::

| Field | Type | Description |
| --- | --- | --- |
| `amount` | `number` | 恢复数值 |
| `entity` | [EntitySnapshot](../classes/entitysnapshot) | 实体快照 |

