---
title: "player:health"
description: "本地玩家生命值变化事件载荷。"
---

::api-event-header{ event="player:health" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerHealthEvent`](../types/PlayerHealthEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `health` | `number` | 变化后的生命值 |

