---
title: "InputKeyPressEvent"
description: "Payload of the raw keyboard event; synchronous subscribers may cancel the key press before the game processes it."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`InputEvent`](InputEvent.html)
#raised-by
[`input:keyPress`](../events/input/input-keypress.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `action` | `string` |  |
| `code` | `number` |  |
| `key` | `string` |  |
| `modifiers` | `Array<string>` |  |

## Sync-channel mutable face（`MutableInputKeyPressEvent`）

The `events.onSync` handler receives a mutable view of this same payload: the members below are writable/callable and the engine commits their values back to the publisher; payload fields not listed stay read-only (strict-mode writes throw a `TypeError`). The object the async channel delivers is the frozen snapshot without these members.

| Member | Type | Description |
| --- | --- | --- |
| `cancel()` | `() => void` | marks the event canceled; later priorities may undo it via `cancelled = false` (last write wins). |
| `cancelled` | `boolean` | current cancellation state; writable — the last write wins. |

