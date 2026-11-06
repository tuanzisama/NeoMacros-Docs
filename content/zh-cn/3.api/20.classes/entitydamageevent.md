---
title: "EntityDamageEvent"
description: "实体受伤时触发。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`entity:damage`](../events/entity/entity-damage)
::

| Field | Type | Description |
| --- | --- | --- |
| `amount` | `number` | 伤害数值 |
| `entity` | [EntitySnapshot](../classes/entitysnapshot) | 实体快照 |

