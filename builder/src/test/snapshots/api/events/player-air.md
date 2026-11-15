---
title: "player:air"
description: "Payload of the local player air (breath) change event."
---

::api-event-header{ event="player:air" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerAirEvent`](../types/PlayerAirEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `air` | `number` |  |

