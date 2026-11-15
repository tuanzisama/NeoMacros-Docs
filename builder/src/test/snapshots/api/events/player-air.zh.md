---
title: "player:air"
description: "本地玩家氧气值变化事件载荷。"
---

::api-event-header{ event="player:air" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerAirEvent`](../types/PlayerAirEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `air` | `number` | 变化后的氧气值 |

