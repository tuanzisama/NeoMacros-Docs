---
title: "chat:receive"
description: "收到聊天消息事件载荷；消息以中立聊天组件承载。"
---

::api-event-header{ event="chat:receive" direction="s2c" since="0.1.0" mc="*" loader="*"}
#payload
[`ChatReceiveEvent`](../types/ChatReceiveEvent.html)
::

**方向**：`s2c` — 服务器下行显示拦截：取消即抑制显示，白名单字段可本地改写。

| Field | Type | Description |
| --- | --- | --- |
| `message` | :api-type{text='TextComponent' refs='TextComponent=classes/textcomponent'} | 显示的消息内容 |

