---
title: "player:leave"
description: "Payload of the local player leaving the world event."
---

::api-event-header{ event="player:leave" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerLeaveEvent`](../types/PlayerLeaveEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `name` | `string` |  |
| `uuid` | `string` |  |

