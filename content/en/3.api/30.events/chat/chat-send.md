---
title: "chat:send"
description: "Payload of the outgoing chat message event; synchronous subscribers may cancel the send."
---

::api-event-header{ event="chat:send" cancellable="true" since="0.1.0" mc="*" loader="*"}
#payload
[`ChatSendEvent`](../../classes/chatsendevent)
::

| Field | Type | Description |
| --- | --- | --- |
| `message` | `string` |  |

