---
title: "EntityDamageEvent"
description: "Payload of the entity damage event; fires when a tracked entity takes damage."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`entity:damage`](../events/entity/entity-damage.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `amount` | `number` |  |
| `entity` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} |  |

