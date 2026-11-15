---
title: "chat:receive"
description: "Payload of the incoming chat message event; carries the message as a neutral chat component."
---

::api-event-header{ event="chat:receive" direction="s2c" since="0.1.0" mc="*" loader="*"}
#payload
[`ChatReceiveEvent`](../types/ChatReceiveEvent.html)
::

**Direction**: `s2c` — server-to-client display interception: cancelling suppresses the display; whitelisted fields may be rewritten locally.

| Field | Type | Description |
| --- | --- | --- |
| `message` | :api-type{text='TextComponent' refs='TextComponent=classes/textcomponent'} |  |

