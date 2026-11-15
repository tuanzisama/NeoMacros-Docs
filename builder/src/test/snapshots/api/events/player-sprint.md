---
title: "player:sprint"
description: "Payload of the sprinting toggle event; fires on the enter/leave edge of the state."
---

::api-event-header{ event="player:sprint" direction="local" since="0.2.0" mc="*" loader="*"}
#payload
[`PlayerSprintEvent`](../types/PlayerSprintEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `sprinting` | `boolean` |  |

