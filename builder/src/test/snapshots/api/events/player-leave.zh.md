---
title: "player:leave"
description: "本地玩家离开世界事件载荷。"
---

::api-event-header{ event="player:leave" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerLeaveEvent`](../types/PlayerLeaveEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `name` | `string` | 玩家名称 |
| `uuid` | `string` | 玩家的 UUID |

