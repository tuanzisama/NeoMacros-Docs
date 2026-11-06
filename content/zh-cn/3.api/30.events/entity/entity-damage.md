---
title: "entity:damage"
description: "实体受伤时触发。"
---

::api-event-header{ event="entity:damage" since="0.1.0" mc="*" loader="*"}
#payload
[`EntityDamageEvent`](../../classes/entitydamageevent)
::

| Field | Type | Description |
| --- | --- | --- |
| `amount` | `number` | 伤害数值 |
| `entity` | [EntitySnapshot](../classes/entitysnapshot) | 实体快照 |

