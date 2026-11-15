---
title: "dialog:close"
description: "对话框关闭事件载荷（打开的对话框关闭时触发）。"
---

::api-event-header{ event="dialog:close" direction="local" since="0.3.0" mc=">=1.21.6" loader="*"}
#payload
[`DialogCloseEvent`](../types/DialogCloseEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `kind` | `string` | 关闭的对话框类别 |

