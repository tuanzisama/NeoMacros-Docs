---
title: "ChatReceiveEvent"
description: "收到聊天消息事件载荷；消息以中立聊天组件承载。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`chat:receive`](../events/chat/chat-receive)
::

| Field | Type | Description |
| --- | --- | --- |
| `message` | [ChatComponent](../classes/chatcomponent) | 显示的消息内容 |

