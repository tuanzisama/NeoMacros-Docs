---
title: "player:gamemode"
description: "Payload of the gamemode change event."
---

::api-event-header{ event="player:gamemode" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerGamemodeEvent`](../types/PlayerGamemodeEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `current` | `string` |  |
| `previous` | `string` |  |

