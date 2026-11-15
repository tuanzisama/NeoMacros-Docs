---
title: "player:interactEntity"
description: "玩家与实体交互事件载荷；同步订阅可取消交互。"
---

::api-event-header{ event="player:interactEntity" direction="c2s" cancellable="true" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerInteractEntityEvent`](../types/PlayerInteractEntityEvent.html)
::

**方向**：`c2s` — 客户端上行动作拦截：取消即抑制该动作（按键/聊天/交互）。

| Field | Type | Description |
| --- | --- | --- |
| `target` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} | 被交互实体的时点快照 |

