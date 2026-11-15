---
title: "player:sneak"
description: "潜行状态变化时触发。"
---

::api-event-header{ event="player:sneak" direction="local" since="0.2.0" mc="*" loader="*"}
#payload
[`PlayerSneakEvent`](../types/PlayerSneakEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `sneaking` | `boolean` | 当前的潜行状态 |

