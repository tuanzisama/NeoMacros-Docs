---
title: "player:gamemode"
description: "游戏模式变化事件载荷。"
---

::api-event-header{ event="player:gamemode" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerGamemodeEvent`](../types/PlayerGamemodeEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `current` | `string` | 当前模式 |
| `previous` | `string` | 先前模式（survival/creative/adventure/spectator） |

