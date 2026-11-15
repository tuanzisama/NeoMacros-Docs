---
title: "ScreenChangeEvent"
description: "屏幕变化事件载荷（任何屏幕切换都触发：打开、关闭与直接切换；背包、对话框与菜单界面同属此通道，领域事件另带细节）。"
---

::api-type-header{ since="0.3.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`screen:change`](../events/screen/screen-change.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `kind` | `string` | 屏幕类别 |
| `phase` | `string` | 变化相位（open/switch/close） |
| `screen` | `string` | 屏幕 MC 类名（关闭为 null） |
| `title` | `string` | 屏幕标题 |

