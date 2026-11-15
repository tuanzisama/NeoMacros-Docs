---
title: "world:time"
description: "世界时间跳变事件载荷；仅时间被不连续修改（设置时间/跳过夜晚）时触发， 正常每 tick 推进不触发。"
---

::api-event-header{ event="world:time" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`WorldTimeEvent`](../types/WorldTimeEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `time` | `number` | 跳变后的世界时间 |

