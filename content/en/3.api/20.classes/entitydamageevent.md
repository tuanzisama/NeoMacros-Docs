---
title: "EntityDamageEvent"
description: "Payload of the entity damage event; fires when a tracked entity takes damage."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`entity:damage`](../events/entity/entity-damage)
::

| Field | Type | Description |
| --- | --- | --- |
| `amount` | `number` |  |
| `entity` | [EntitySnapshot](../classes/entitysnapshot) |  |

