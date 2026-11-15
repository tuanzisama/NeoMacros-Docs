---
title: "player:effect"
description: "Payload of the status effect change event; fires when the local player gains or loses a status effect."
---

::api-event-header{ event="player:effect" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerEffectEvent`](../types/PlayerEffectEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `added` | `boolean` |  |
| `amplifier` | `number` |  |
| `effectId` | `string` |  |

