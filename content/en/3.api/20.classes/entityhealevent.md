---
title: "EntityHealEvent"
description: "Payload of the entity heal event."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`entity:heal`](../events/entity/entity-heal)
::

| Field | Type | Description |
| --- | --- | --- |
| `amount` | `number` |  |
| `entity` | [EntitySnapshot](../classes/entitysnapshot) |  |

