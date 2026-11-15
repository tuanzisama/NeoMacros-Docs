---
title: "InventoryUpdateEvent"
description: "物品栏更新事件载荷（服务端槽位同步触发：单槽为 slot，全量重同步为 all；菜单 id 0 覆盖玩家背包，拾取与合成同样触发）。"
---

::api-type-header{ since="0.3.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`inventory:update`](../events/inventory/inventory-update.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `containerId` | `number` | 菜单 id |
| `kind` | `string` | 容器类别（背包为 player） |
| `mode` | `string` | 更新模式（slot/all） |
| `slot` | `number` | 变化槽位号（全量同步为 -1） |

