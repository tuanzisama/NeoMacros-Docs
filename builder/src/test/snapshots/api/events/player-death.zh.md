---
title: "player:death"
description: "本地玩家死亡事件载荷。"
---

::api-event-header{ event="player:death" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerDeathEvent`](../types/PlayerDeathEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `player` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} | 玩家的时点快照 |

