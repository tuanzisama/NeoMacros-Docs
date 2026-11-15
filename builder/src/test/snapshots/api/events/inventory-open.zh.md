---
title: "inventory:open"
description: "物品栏打开事件载荷（容器屏幕打开时触发，玩家背包为 player）。"
---

::api-event-header{ event="inventory:open" direction="local" since="0.3.0" mc="*" loader="*"}
#payload
[`InventoryOpenEvent`](../types/InventoryOpenEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `containerId` | `number` | 菜单 id |
| `kind` | `string` | 容器类别 |
| `size` | `number` | 槽位总数 |
| `title` | `string` | 容器标题 |

