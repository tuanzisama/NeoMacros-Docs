---
title: "PlayerAttackBlockEvent"
description: "玩家开始破坏方块事件载荷；同步订阅可取消破坏。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`player:attackBlock`](../events/player/player-attackblock)
::

| Field | Type | Description |
| --- | --- | --- |
| `block` | [Block](../classes/block) | 被攻击方块的句柄 |
| `face` | `string` | 交互面方向名（如 north） |

