---
title: "chat:send"
description: "发出聊天消息事件载荷；同步订阅可取消发送。"
---

::api-event-header{ event="chat:send" direction="c2s" cancellable="true" since="0.1.0" mc="*" loader="*"}
#payload
[`ChatSendEvent`](../types/ChatSendEvent.html)
::

**方向**：`c2s` — 客户端上行动作拦截：取消即抑制该动作（按键/聊天/交互）。

| Field | Type | Description |
| --- | --- | --- |
| `message` | `string` | 待发送的消息文本（同步通道可改写） |

