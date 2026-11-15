---
title: "player:attackBlock"
description: "玩家开始破坏方块事件载荷；同步订阅可取消破坏。"
---

::api-event-header{ event="player:attackBlock" direction="c2s" cancellable="true" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerAttackBlockEvent`](../types/PlayerAttackBlockEvent.html)
::

**方向**：`c2s` — 客户端上行动作拦截：取消即抑制该动作（按键/聊天/交互）。

| Field | Type | Description |
| --- | --- | --- |
| `block` | :api-type{text='Block' refs='Block=classes/block'} | 被攻击方块的句柄 |
| `face` | `string` | 交互面方向名（如 north） |

