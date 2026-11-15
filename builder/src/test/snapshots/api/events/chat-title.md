---
title: "chat:title"
description: "Payload of the title display event (main title or subtitle); synchronous subscribers may cancel the display (true) or return {text: \"...\"} to replace the text."
---

::api-event-header{ event="chat:title" direction="s2c" cancellable="true" since="0.4.0" mc="*" loader="*"}
#payload
[`ChatTitleEvent`](../types/ChatTitleEvent.html)
::

**Direction**: `s2c` — server-to-client display interception: cancelling suppresses the display; whitelisted fields may be rewritten locally.

| Field | Type | Description |
| --- | --- | --- |
| `kind` | `string` |  |
| `text` | :api-type{text='TextComponent' refs='TextComponent=classes/textcomponent'} |  (rewritable on the sync channel) |

