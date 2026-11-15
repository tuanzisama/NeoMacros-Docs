---
title: "chat:actionbar"
description: "动作栏显示事件载荷；同步订阅返回 truthy 取消显示，或返回 {text:\"...\"} 替换文本。"
---

::api-event-header{ event="chat:actionbar" direction="s2c" cancellable="true" since="0.4.0" mc="*" loader="*"}
#payload
[`ChatActionbarEvent`](../types/ChatActionbarEvent.html)
::

**方向**：`s2c` — 服务器下行显示拦截：取消即抑制显示，白名单字段可本地改写。

| Field | Type | Description |
| --- | --- | --- |
| `source` | `string` | 来源：server（服务器动作栏包）或 local（客户端本地 overlay 提示） |
| `text` | :api-type{text='TextComponent' refs='TextComponent=classes/textcomponent'} | 显示的文本（同步通道可改写） |

