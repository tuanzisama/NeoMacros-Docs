---
title: "player:riding"
description: "Payload of the riding change event; the vehicle snapshot is null when the player dismounted."
---

::api-event-header{ event="player:riding" direction="local" since="0.2.0" mc="*" loader="*"}
#payload
[`PlayerRidingEvent`](../types/PlayerRidingEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `vehicle` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} |  |

