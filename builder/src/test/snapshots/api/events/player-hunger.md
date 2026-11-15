---
title: "player:hunger"
description: "Payload of the local player hunger change event."
---

::api-event-header{ event="player:hunger" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerHungerEvent`](../types/PlayerHungerEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `hunger` | `number` |  |

