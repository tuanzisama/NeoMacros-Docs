---
title: "player:armor"
description: "盔甲变化事件载荷；四槽按脚/腿/胸/头排列，空槽读作 minecraft:air。"
---

::api-event-header{ event="player:armor" direction="local" since="0.2.0" mc="*" loader="*"}
#payload
[`PlayerArmorEvent`](../types/PlayerArmorEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `armor` | :api-type{text='Array<ItemStack>' refs='ItemStack=classes/itemstack'} | 四个盔甲槽的物品堆 |

