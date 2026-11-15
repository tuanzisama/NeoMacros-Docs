---
title: "player:interactEntity"
description: "Payload of the entity interaction event; synchronous subscribers may cancel the interaction."
---

::api-event-header{ event="player:interactEntity" direction="c2s" cancellable="true" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerInteractEntityEvent`](../types/PlayerInteractEntityEvent.html)
::

**Direction**: `c2s` — client-to-server action interception: cancelling suppresses the action.

| Field | Type | Description |
| --- | --- | --- |
| `target` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} |  |

