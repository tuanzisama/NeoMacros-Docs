---
title: "inventory:update"
description: "物品栏更新事件载荷（服务端槽位同步触发：单槽为 slot，全量重同步为 all；菜单 id 0 覆盖玩家背包，拾取与合成同样触发）。"
---

::api-event-header{ event="inventory:update" direction="local" since="0.3.0" mc="*" loader="*"}
#payload
[`InventoryUpdateEvent`](../types/InventoryUpdateEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `containerId` | `number` | 菜单 id |
| `kind` | `string` | 容器类别（背包为 player） |
| `mode` | `string` | 更新模式（slot/all） |
| `slot` | `number` | 变化槽位号（全量同步为 -1） |

