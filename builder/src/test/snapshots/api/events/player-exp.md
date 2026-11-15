---
title: "player:exp"
description: "Payload of the experience change event."
---

::api-event-header{ event="player:exp" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerExpEvent`](../types/PlayerExpEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `change` | `number` |  |
| `level` | `number` |  |
| `progress` | `number` |  |

