---
title: "PlayerInteractBlockEvent"
description: "Payload of the block use (right-click) event; synchronous subscribers may cancel the interaction."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`InputEvent`](InputEvent.html)
#raised-by
[`player:interactBlock`](../events/player/player-interactblock.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `block` | :api-type{text='Block' refs='Block=classes/block'} |  |
| `face` | `string` |  |

## Sync-channel mutable face（`MutablePlayerInteractBlockEvent`）

The `events.onSync` handler receives a mutable view of this same payload: the members below are writable/callable and the engine commits their values back to the publisher; payload fields not listed stay read-only (strict-mode writes throw a `TypeError`). The object the async channel delivers is the frozen snapshot without these members.

| Member | Type | Description |
| --- | --- | --- |
| `cancel()` | `() => void` | marks the event canceled; later priorities may undo it via `cancelled = false` (last write wins). |
| `cancelled` | `boolean` | current cancellation state; writable — the last write wins. |

