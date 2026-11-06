---
title: "ChatSendEvent"
description: "发出聊天消息事件载荷；同步订阅可取消发送。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`chat:send`](../events/chat/chat-send)
::

| Field | Type | Description |
| --- | --- | --- |
| `message` | `string` | 待发送的消息文本 |

