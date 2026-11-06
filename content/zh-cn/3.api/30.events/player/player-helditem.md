---
title: "player:heldItem"
description: "手持物品变化事件载荷。"
---

::api-event-header{ event="player:heldItem" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerHeldItemEvent`](../../classes/playerhelditemevent)
::

| Field | Type | Description |
| --- | --- | --- |
| `current` | [ItemStackData](../classes/itemstackdata) | 当前手持物品快照（可为 null） |
| `previous` | [ItemStackData](../classes/itemstackdata) | 先前手持物品快照（可为 null） |

