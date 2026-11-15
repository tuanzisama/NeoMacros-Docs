---
title: "ScreenOpenEvent"
description: "屏幕打开事件载荷。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`screen:open`](../events/screen/screen-open.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `kind` | `string` | 屏幕类型 |
| `screen` | `string` | 屏幕 MC 类名 |
| `title` | `string` | 屏幕标题 |

