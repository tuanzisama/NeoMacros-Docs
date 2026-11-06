---
title: "PlayerHeldItemEvent"
description: "手持物品变化事件载荷。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`player:heldItem`](../events/player/player-helditem)
::

| Field | Type | Description |
| --- | --- | --- |
| `current` | [ItemStackData](../classes/itemstackdata) | 当前手持物品快照（可为 null） |
| `previous` | [ItemStackData](../classes/itemstackdata) | 先前手持物品快照（可为 null） |

