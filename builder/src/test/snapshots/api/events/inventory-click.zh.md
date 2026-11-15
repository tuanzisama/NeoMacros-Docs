---
title: "inventory:click"
description: "物品栏点击事件载荷（容器槽位点击处理完成后触发，手动与脚本点击同路）。"
---

::api-event-header{ event="inventory:click" direction="local" since="0.3.0" mc="*" loader="*"}
#payload
[`InventoryClickEvent`](../types/InventoryClickEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `button` | `number` | 鼠标键（0 左键 1 右键） |
| `containerId` | `number` | 菜单 id |
| `kind` | `string` | 容器类别 |
| `shift` | `boolean` | 是否快速移动 |
| `slot` | `number` | 点击槽位号 |

