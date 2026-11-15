---
title: "chat:send"
description: "Payload of the outgoing chat message event; synchronous subscribers may cancel the send."
---

::api-event-header{ event="chat:send" direction="c2s" cancellable="true" since="0.1.0" mc="*" loader="*"}
#payload
[`ChatSendEvent`](../types/ChatSendEvent.html)
::

**Direction**: `c2s` — client-to-server action interception: cancelling suppresses the action.

| Field | Type | Description |
| --- | --- | --- |
| `message` | `string` |  (rewritable on the sync channel) |

