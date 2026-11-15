---
title: "player:attackEntity"
description: "玩家攻击实体事件载荷；同步订阅可取消攻击。"
---

::api-event-header{ event="player:attackEntity" direction="c2s" cancellable="true" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerAttackEntityEvent`](../types/PlayerAttackEntityEvent.html)
::

**方向**：`c2s` — 客户端上行动作拦截：取消即抑制该动作（按键/聊天/交互）。

| Field | Type | Description |
| --- | --- | --- |
| `target` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} | 被攻击实体的时点快照 |

