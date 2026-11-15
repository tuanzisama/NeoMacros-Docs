---
title: "ChatActionbarEvent"
description: "Payload of the action-bar display event; synchronous subscribers may cancel the message (true) or return {text: \"...\"} to replace it."
---

::api-type-header{ since="0.4.0" mc="*" loader="*"}
#extends
[`DisplayEvent`](DisplayEvent.html)
#raised-by
[`chat:actionbar`](../events/chat/chat-actionbar.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `source` | `string` |  |
| `text` | :api-type{text='TextComponent' refs='TextComponent=classes/textcomponent'} |  |

## Sync-channel mutable face（`MutableChatActionbarEvent`）

The `events.onSync` handler receives a mutable view of this same payload: the members below are writable/callable and the engine commits their values back to the publisher; payload fields not listed stay read-only (strict-mode writes throw a `TypeError`). The object the async channel delivers is the frozen snapshot without these members.

| Member | Type | Description |
| --- | --- | --- |
| `text` | :api-type{text='TextComponent' refs='TextComponent=classes/textcomponent'} | rewritable on the sync channel; the committed value travels back to the publisher. |
| `cancel()` | `() => void` | marks the event canceled; later priorities may undo it via `cancelled = false` (last write wins). |
| `cancelled` | `boolean` | current cancellation state; writable — the last write wins. |

