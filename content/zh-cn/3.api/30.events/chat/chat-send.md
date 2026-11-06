---
title: "chat:send"
description: "发出聊天消息事件载荷；同步订阅可取消发送。"
---

::api-event-header{ event="chat:send" cancellable="true" since="0.1.0" mc="*" loader="*"}
#payload
[`ChatSendEvent`](../../classes/chatsendevent)
::

| Field | Type | Description |
| --- | --- | --- |
| `message` | `string` | 待发送的消息文本 |

