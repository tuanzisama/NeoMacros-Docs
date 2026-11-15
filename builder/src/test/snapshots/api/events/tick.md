---
title: "tick"
description: "Payload of the per-client-tick event; high-traffic, so wildcard dispatch skips it by default (see the wildcard ignore list)."
---

::api-event-header{ event="tick" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`TickEvent`](../types/TickEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `count` | `number` |  |

