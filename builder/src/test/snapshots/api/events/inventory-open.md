---
title: "inventory:open"
description: "Payload of the inventory open event, fired when a container screen opens (the player inventory screen included, kind player)."
---

::api-event-header{ event="inventory:open" direction="local" since="0.3.0" mc="*" loader="*"}
#payload
[`InventoryOpenEvent`](../types/InventoryOpenEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `containerId` | `number` |  |
| `kind` | `string` |  |
| `size` | `number` |  |
| `title` | `string` |  |

