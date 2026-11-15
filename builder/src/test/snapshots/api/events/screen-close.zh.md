---
title: "screen:close"
description: "屏幕关闭事件载荷。"
---

::api-event-header{ event="screen:close" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`ScreenCloseEvent`](../types/ScreenCloseEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `screen` | `string` | 关闭的屏幕 MC 类名 |
| `title` | `string` | 关闭的屏幕标题 |

