---
title: "world:dimensionChange"
description: "Payload of the client world changing dimension event."
---

::api-event-header{ event="world:dimensionChange" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`WorldDimensionChangeEvent`](../types/WorldDimensionChangeEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `from` | `string` |  |
| `to` | `string` |  |

