---
title: "player:dimensionChange"
description: "Payload of the local player changing dimension event."
---

::api-event-header{ event="player:dimensionChange" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerDimensionChangeEvent`](../types/PlayerDimensionChangeEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `from` | `string` |  |
| `to` | `string` |  |

