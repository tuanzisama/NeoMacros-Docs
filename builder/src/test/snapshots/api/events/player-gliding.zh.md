---
title: "player:gliding"
description: "鞘翅滑翔状态变化时触发。"
---

::api-event-header{ event="player:gliding" direction="local" since="0.2.0" mc="*" loader="*"}
#payload
[`PlayerGlidingEvent`](../types/PlayerGlidingEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `gliding` | `boolean` | 当前的滑翔状态 |

