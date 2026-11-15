---
title: "chat:actionbar"
description: "Payload of the action-bar display event; synchronous subscribers may cancel the message (true) or return {text: \"...\"} to replace it."
---

::api-event-header{ event="chat:actionbar" direction="s2c" cancellable="true" since="0.4.0" mc="*" loader="*"}
#payload
[`ChatActionbarEvent`](../types/ChatActionbarEvent.html)
::

**Direction**: `s2c` — server-to-client display interception: cancelling suppresses the display; whitelisted fields may be rewritten locally.

| Field | Type | Description |
| --- | --- | --- |
| `source` | `string` |  |
| `text` | :api-type{text='TextComponent' refs='TextComponent=classes/textcomponent'} |  (rewritable on the sync channel) |

