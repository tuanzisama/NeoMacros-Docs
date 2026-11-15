---
title: "player:damage"
description: "Payload of the local player damage event; carries the lost amount and the resulting health."
---

::api-event-header{ event="player:damage" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerDamageEvent`](../types/PlayerDamageEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `amount` | `number` |  |
| `health` | `number` |  |

