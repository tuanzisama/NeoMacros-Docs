---
title: "PlayerRidingEvent"
description: "Payload of the riding change event; the vehicle snapshot is null when the player dismounted."
---

::api-type-header{ since="0.2.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`player:riding`](../events/player/player-riding.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `vehicle` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} |  |

