---
title: "EntityUnloadEvent"
description: "Payload of the entity unload event; fires when an entity leaves the client's tracked range."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`entity:unload`](../events/entity/entity-unload.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `entity` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} |  |

