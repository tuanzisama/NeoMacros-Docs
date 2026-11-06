---
title: "PlayerInteractEntityEvent"
description: "玩家与实体交互事件载荷；同步订阅可取消交互。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`player:interactEntity`](../events/player/player-interactentity)
::

| Field | Type | Description |
| --- | --- | --- |
| `target` | [EntitySnapshot](../classes/entitysnapshot) | 被交互实体的时点快照 |

