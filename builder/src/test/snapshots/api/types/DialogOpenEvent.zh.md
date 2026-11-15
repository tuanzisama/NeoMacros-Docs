---
title: "DialogOpenEvent"
description: "对话框打开事件载荷（服务端弹出对话框或脚本打开时触发）。"
---

::api-type-header{ since="0.3.0" mc=">=1.21.6" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`dialog:open`](../events/dialog/dialog-open.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `actions` | :api-type{text='Array<DialogAction>' refs='DialogAction=classes/dialogaction'} | 动作按钮列表 |
| `canCloseWithEscape` | `boolean` | 是否可按 Esc 关闭 |
| `kind` | `string` | 对话框类别（notice/confirmation/multi_action/list/server_links） |
| `title` | `string` | 对话框标题 |

