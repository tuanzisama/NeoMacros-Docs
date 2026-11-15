---
title: "player:gliding"
description: "Payload of the gliding toggle event; fires on the enter/leave edge of the state."
---

::api-event-header{ event="player:gliding" direction="local" since="0.2.0" mc="*" loader="*"}
#payload
[`PlayerGlidingEvent`](../types/PlayerGlidingEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `gliding` | `boolean` |  |

