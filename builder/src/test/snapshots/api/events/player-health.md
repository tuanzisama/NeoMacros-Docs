---
title: "player:health"
description: "Payload of the local player health change event."
---

::api-event-header{ event="player:health" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerHealthEvent`](../types/PlayerHealthEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `health` | `number` |  |

