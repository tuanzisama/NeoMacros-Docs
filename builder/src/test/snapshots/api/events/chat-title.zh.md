---
title: "chat:title"
description: "标题显示事件载荷（大标题或副标题）；同步订阅返回 truthy 取消显示，或返回 {text:\"...\"} 替换文本。"
---

::api-event-header{ event="chat:title" direction="s2c" cancellable="true" since="0.4.0" mc="*" loader="*"}
#payload
[`ChatTitleEvent`](../types/ChatTitleEvent.html)
::

**方向**：`s2c` — 服务器下行显示拦截：取消即抑制显示，白名单字段可本地改写。

| Field | Type | Description |
| --- | --- | --- |
| `kind` | `string` | 显示类型：title（大标题）或 subtitle（副标题） |
| `text` | :api-type{text='TextComponent' refs='TextComponent=classes/textcomponent'} | 显示的文本（同步通道可改写） |

