---
title: "player:attackEntity"
description: "Payload of the entity attack event; synchronous subscribers may cancel the attack."
---

::api-event-header{ event="player:attackEntity" cancellable="true" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerAttackEntityEvent`](../../classes/playerattackentityevent)
::

| Field | Type | Description |
| --- | --- | --- |
| `target` | [EntitySnapshot](../classes/entitysnapshot) |  |

