---
title: "InventoryUpdateEvent"
description: "Payload of the inventory update event, fired on every server slot sync: single-slot updates (mode slot) and full menu resyncs (mode all). Menu id 0 covers the player inventory while no container screen is open, so item pickup and crafting surface here too."
---

::api-type-header{ since="0.3.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`inventory:update`](../events/inventory/inventory-update.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `containerId` | `number` |  |
| `kind` | `string` |  |
| `mode` | `string` |  |
| `slot` | `number` |  |

