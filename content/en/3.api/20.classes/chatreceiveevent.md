---
title: "ChatReceiveEvent"
description: "Payload of the incoming chat message event; carries the message as a neutral chat component."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`chat:receive`](../events/chat/chat-receive)
::

| Field | Type | Description |
| --- | --- | --- |
| `message` | [ChatComponent](../classes/chatcomponent) |  |

