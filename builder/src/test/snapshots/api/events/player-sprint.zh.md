---
title: "player:sprint"
description: "疾跑状态变化时触发。"
---

::api-event-header{ event="player:sprint" direction="local" since="0.2.0" mc="*" loader="*"}
#payload
[`PlayerSprintEvent`](../types/PlayerSprintEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `sprinting` | `boolean` | 当前的疾跑状态 |

