---
title: "screen:open"
description: "屏幕打开事件载荷。"
---

::api-event-header{ event="screen:open" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`ScreenOpenEvent`](../types/ScreenOpenEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `kind` | `string` | 屏幕类型 |
| `screen` | `string` | 屏幕 MC 类名 |
| `title` | `string` | 屏幕标题 |

