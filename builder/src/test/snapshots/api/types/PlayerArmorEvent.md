---
title: "PlayerArmorEvent"
description: "Payload of the armor change event; the four slots ride in feet, legs, chest, head order and empty slots read as minecraft:air."
---

::api-type-header{ since="0.2.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`player:armor`](../events/player/player-armor.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `armor` | :api-type{text='Array<ItemStack>' refs='ItemStack=classes/itemstack'} |  |

