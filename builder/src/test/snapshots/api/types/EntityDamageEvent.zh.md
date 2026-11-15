---
title: "EntityDamageEvent"
description: "实体受伤时触发。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`entity:damage`](../events/entity/entity-damage.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `amount` | `number` | 伤害数值 |
| `entity` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} | 实体快照 |

