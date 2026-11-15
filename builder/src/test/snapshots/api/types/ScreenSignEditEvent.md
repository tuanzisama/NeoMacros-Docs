---
title: "ScreenSignEditEvent"
description: "Payload of the sign-edit open event; synchronous subscribers may cancel the editor, rewrite the four lines, or set closeScreen to submit the (possibly replaced) text directly instead of opening the editor."
---

::api-type-header{ since="0.4.0" mc="*" loader="*"}
#extends
[`DisplayEvent`](DisplayEvent.html)
#raised-by
[`screen:signEdit`](../events/screen/screen-signedit.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `closeScreen` | `boolean` |  |
| `front` | `boolean` |  |
| `lines` | `Array<string>` |  |
| `x` | `number` |  |
| `y` | `number` |  |
| `z` | `number` |  |

## Sync-channel mutable face（`MutableScreenSignEditEvent`）

The `events.onSync` handler receives a mutable view of this same payload: the members below are writable/callable and the engine commits their values back to the publisher; payload fields not listed stay read-only (strict-mode writes throw a `TypeError`). The object the async channel delivers is the frozen snapshot without these members.

| Member | Type | Description |
| --- | --- | --- |
| `closeScreen` | `boolean` | rewritable on the sync channel; the committed value travels back to the publisher. |
| `lines` | `Array<string>` | rewritable on the sync channel; the committed value travels back to the publisher. |
| `cancel()` | `() => void` | marks the event canceled; later priorities may undo it via `cancelled = false` (last write wins). |
| `cancelled` | `boolean` | current cancellation state; writable — the last write wins. |

