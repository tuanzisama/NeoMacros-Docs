---
title: "InventoryCloseEvent"
description: "物品栏关闭事件载荷（打开的容器屏幕关闭时触发）。"
---

::api-type-header{ since="0.3.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`inventory:close`](../events/inventory/inventory-close.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `kind` | `string` | 关闭的容器类别 |
| `title` | `string` | 关闭的容器标题 |

