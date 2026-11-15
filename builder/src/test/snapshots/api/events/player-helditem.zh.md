---
title: "player:heldItem"
description: "手持物品变化事件载荷。"
---

::api-event-header{ event="player:heldItem" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerHeldItemEvent`](../types/PlayerHeldItemEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `current` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | 当前手持物品快照（可为 null） |
| `previous` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | 先前手持物品快照（可为 null） |

