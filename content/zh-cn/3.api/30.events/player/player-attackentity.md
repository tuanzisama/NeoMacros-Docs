---
title: "player:attackEntity"
description: "玩家攻击实体事件载荷；同步订阅可取消攻击。"
---

::api-event-header{ event="player:attackEntity" cancellable="true" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerAttackEntityEvent`](../../classes/playerattackentityevent)
::

| Field | Type | Description |
| --- | --- | --- |
| `target` | [EntitySnapshot](../classes/entitysnapshot) | 被攻击实体的时点快照 |

