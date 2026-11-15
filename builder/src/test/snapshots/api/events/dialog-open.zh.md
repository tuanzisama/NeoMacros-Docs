---
title: "dialog:open"
description: "对话框打开事件载荷（服务端弹出对话框或脚本打开时触发）。"
---

::api-event-header{ event="dialog:open" direction="local" since="0.3.0" mc=">=1.21.6" loader="*"}
#payload
[`DialogOpenEvent`](../types/DialogOpenEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `actions` | :api-type{text='Array<DialogAction>' refs='DialogAction=classes/dialogaction'} | 动作按钮列表 |
| `canCloseWithEscape` | `boolean` | 是否可按 Esc 关闭 |
| `kind` | `string` | 对话框类别（notice/confirmation/multi_action/list/server_links） |
| `title` | `string` | 对话框标题 |

