---
title: "player:spawn"
description: "本地玩家出生事件载荷（世界会话的首次出生）。"
---

::api-event-header{ event="player:spawn" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerSpawnEvent`](../types/PlayerSpawnEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `player` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} | 玩家的时点快照 |

