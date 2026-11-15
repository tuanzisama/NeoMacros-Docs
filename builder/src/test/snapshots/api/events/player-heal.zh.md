---
title: "player:heal"
description: "本地玩家治疗事件载荷；携带恢复量与治疗后的生命值。"
---

::api-event-header{ event="player:heal" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerHealEvent`](../types/PlayerHealEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `amount` | `number` | 恢复的生命值 |
| `health` | `number` | 治疗后的生命值 |

