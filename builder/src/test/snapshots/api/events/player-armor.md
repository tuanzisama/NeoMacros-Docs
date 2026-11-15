---
title: "player:armor"
description: "Payload of the armor change event; the four slots ride in feet, legs, chest, head order and empty slots read as minecraft:air."
---

::api-event-header{ event="player:armor" direction="local" since="0.2.0" mc="*" loader="*"}
#payload
[`PlayerArmorEvent`](../types/PlayerArmorEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `armor` | :api-type{text='Array<ItemStack>' refs='ItemStack=classes/itemstack'} |  |

