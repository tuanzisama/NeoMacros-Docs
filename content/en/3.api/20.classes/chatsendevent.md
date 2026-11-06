---
title: "ChatSendEvent"
description: "Payload of the outgoing chat message event; synchronous subscribers may cancel the send."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`chat:send`](../events/chat/chat-send)
::

| Field | Type | Description |
| --- | --- | --- |
| `message` | `string` |  |

