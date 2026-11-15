---
title: "player:exp"
description: "经验值变化事件载荷。"
---

::api-event-header{ event="player:exp" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerExpEvent`](../types/PlayerExpEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `change` | `number` | 经验值增量 |
| `level` | `number` | 当前经验等级 |
| `progress` | `number` | 当前等级进度（0.0-1.0） |

