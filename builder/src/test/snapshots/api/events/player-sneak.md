---
title: "player:sneak"
description: "Payload of the sneaking toggle event; fires on the enter/leave edge of the state."
---

::api-event-header{ event="player:sneak" direction="local" since="0.2.0" mc="*" loader="*"}
#payload
[`PlayerSneakEvent`](../types/PlayerSneakEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `sneaking` | `boolean` |  |

