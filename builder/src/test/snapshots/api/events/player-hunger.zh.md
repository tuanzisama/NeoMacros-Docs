---
title: "player:hunger"
description: "本地玩家饥饿值变化事件载荷。"
---

::api-event-header{ event="player:hunger" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerHungerEvent`](../types/PlayerHungerEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `hunger` | `number` | 变化后的饥饿值 |

