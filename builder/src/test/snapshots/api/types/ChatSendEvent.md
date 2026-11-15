---
title: "ChatSendEvent"
description: "Payload of the outgoing chat message event; synchronous subscribers may cancel the send."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`InputEvent`](InputEvent.html)
#raised-by
[`chat:send`](../events/chat/chat-send.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `message` | `string` |  |

## Sync-channel mutable face（`MutableChatSendEvent`）

The `events.onSync` handler receives a mutable view of this same payload: the members below are writable/callable and the engine commits their values back to the publisher; payload fields not listed stay read-only (strict-mode writes throw a `TypeError`). The object the async channel delivers is the frozen snapshot without these members.

| Member | Type | Description |
| --- | --- | --- |
| `message` | `string` | rewritable on the sync channel; the committed value travels back to the publisher. |
| `cancel()` | `() => void` | marks the event canceled; later priorities may undo it via `cancelled = false` (last write wins). |
| `cancelled` | `boolean` | current cancellation state; writable — the last write wins. |

