---
title: "InventoryOpenEvent"
description: "Payload of the inventory open event, fired when a container screen opens (the player inventory screen included, kind player)."
---

::api-type-header{ since="0.3.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`inventory:open`](../events/inventory/inventory-open.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `containerId` | `number` |  |
| `kind` | `string` |  |
| `size` | `number` |  |
| `title` | `string` |  |

