---
title: "player:damage"
description: "本地玩家受伤事件载荷；携带损失量与受伤后的生命值。"
---

::api-event-header{ event="player:damage" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerDamageEvent`](../types/PlayerDamageEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `amount` | `number` | 损失的生命值 |
| `health` | `number` | 受伤后的生命值 |

