---
title: "player:interactEntity"
description: "玩家与实体交互事件载荷；同步订阅可取消交互。"
---

::api-event-header{ event="player:interactEntity" cancellable="true" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerInteractEntityEvent`](../../classes/playerinteractentityevent)
::

| Field | Type | Description |
| --- | --- | --- |
| `target` | [EntitySnapshot](../classes/entitysnapshot) | 被交互实体的时点快照 |

