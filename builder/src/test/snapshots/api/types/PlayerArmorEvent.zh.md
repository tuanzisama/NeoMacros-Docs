---
title: "PlayerArmorEvent"
description: "盔甲变化事件载荷；四槽按脚/腿/胸/头排列，空槽读作 minecraft:air。"
---

::api-type-header{ since="0.2.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`player:armor`](../events/player/player-armor.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `armor` | :api-type{text='Array<ItemStack>' refs='ItemStack=classes/itemstack'} | 四个盔甲槽的物品堆 |

