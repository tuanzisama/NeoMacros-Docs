---
title: "TickEvent"
description: "Payload of the per-client-tick event; high-traffic, so wildcard dispatch skips it by default (see the wildcard ignore list)."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`tick`](../events/tick/tick)
::

| Field | Type | Description |
| --- | --- | --- |
| `count` | `number` |  |

