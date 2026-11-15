---
title: "tick"
description: "每客户端 tick 事件载荷；高流量事件，默认不进通配分发。"
---

::api-event-header{ event="tick" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`TickEvent`](../types/TickEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `count` | `number` | 本次会话的累计 tick 计数 |

