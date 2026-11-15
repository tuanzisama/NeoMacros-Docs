---
title: "inventory:close"
description: "物品栏关闭事件载荷（打开的容器屏幕关闭时触发）。"
---

::api-event-header{ event="inventory:close" direction="local" since="0.3.0" mc="*" loader="*"}
#payload
[`InventoryCloseEvent`](../types/InventoryCloseEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `kind` | `string` | 关闭的容器类别 |
| `title` | `string` | 关闭的容器标题 |

