---
title: "PlayerHeldItemEvent"
description: "Payload of the held item change event."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`player:heldItem`](../events/player/player-helditem)
::

| Field | Type | Description |
| --- | --- | --- |
| `current` | [ItemStackData](../classes/itemstackdata) |  |
| `previous` | [ItemStackData](../classes/itemstackdata) |  |

