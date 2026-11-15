---
title: "PlayerHeldItemEvent"
description: "Payload of the held item change event."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`player:heldItem`](../events/player/player-helditem.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `current` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} |  |
| `previous` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} |  |

