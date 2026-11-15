---
title: "InventoryOpenEvent"
description: "物品栏打开事件载荷（容器屏幕打开时触发，玩家背包为 player）。"
---

::api-type-header{ since="0.3.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`inventory:open`](../events/inventory/inventory-open.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `containerId` | `number` | 菜单 id |
| `kind` | `string` | 容器类别 |
| `size` | `number` | 槽位总数 |
| `title` | `string` | 容器标题 |

