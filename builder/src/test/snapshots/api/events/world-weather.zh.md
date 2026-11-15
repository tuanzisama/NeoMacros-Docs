---
title: "world:weather"
description: "天气变化事件载荷。"
---

::api-event-header{ event="world:weather" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`WorldWeatherEvent`](../types/WorldWeatherEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `raining` | `boolean` | 是否在下雨 |
| `thundering` | `boolean` | 是否在打雷 |

