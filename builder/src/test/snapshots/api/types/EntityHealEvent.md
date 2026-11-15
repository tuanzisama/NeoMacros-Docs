---
title: "EntityHealEvent"
description: "Payload of the entity heal event."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`entity:heal`](../events/entity/entity-heal.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `amount` | `number` |  |
| `entity` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} |  |

