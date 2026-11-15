---
title: "PlayerHeldItemEvent"
description: "手持物品变化事件载荷。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`player:heldItem`](../events/player/player-helditem.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `current` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | 当前手持物品快照（可为 null） |
| `previous` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | 先前手持物品快照（可为 null） |

