---
title: "PlayerAttackEntityEvent"
description: "Payload of the entity attack event; synchronous subscribers may cancel the attack."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`player:attackEntity`](../events/player/player-attackentity)
::

| Field | Type | Description |
| --- | --- | --- |
| `target` | [EntitySnapshot](../classes/entitysnapshot) |  |

