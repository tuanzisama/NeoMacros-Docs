---
title: "inventory:close"
description: "Payload of the inventory close event, fired when an open container screen closes."
---

::api-event-header{ event="inventory:close" direction="local" since="0.3.0" mc="*" loader="*"}
#payload
[`InventoryCloseEvent`](../types/InventoryCloseEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `kind` | `string` |  |
| `title` | `string` |  |

