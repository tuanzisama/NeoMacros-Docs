---
title: "player:heldItem"
description: "Payload of the held item change event."
---

::api-event-header{ event="player:heldItem" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerHeldItemEvent`](../types/PlayerHeldItemEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `current` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} |  |
| `previous` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} |  |

