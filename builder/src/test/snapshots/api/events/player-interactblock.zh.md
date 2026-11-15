---
title: "player:interactBlock"
description: "玩家对方块使用物品事件载荷；同步订阅可取消交互。"
---

::api-event-header{ event="player:interactBlock" direction="c2s" cancellable="true" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerInteractBlockEvent`](../types/PlayerInteractBlockEvent.html)
::

**方向**：`c2s` — 客户端上行动作拦截：取消即抑制该动作（按键/聊天/交互）。

| Field | Type | Description |
| --- | --- | --- |
| `block` | :api-type{text='Block' refs='Block=classes/block'} | 被交互方块的句柄 |
| `face` | `string` | 交互面方向名（如 north） |

