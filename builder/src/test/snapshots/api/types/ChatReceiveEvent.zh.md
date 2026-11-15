---
title: "ChatReceiveEvent"
description: "收到聊天消息事件载荷；消息以中立聊天组件承载。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`DisplayEvent`](DisplayEvent.html)
#raised-by
[`chat:receive`](../events/chat/chat-receive.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `message` | :api-type{text='TextComponent' refs='TextComponent=classes/textcomponent'} | 显示的消息内容 |

