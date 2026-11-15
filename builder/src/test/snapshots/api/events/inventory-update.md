---
title: "inventory:update"
description: "Payload of the inventory update event, fired on every server slot sync: single-slot updates (mode slot) and full menu resyncs (mode all). Menu id 0 covers the player inventory while no container screen is open, so item pickup and crafting surface here too."
---

::api-event-header{ event="inventory:update" direction="local" since="0.3.0" mc="*" loader="*"}
#payload
[`InventoryUpdateEvent`](../types/InventoryUpdateEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `containerId` | `number` |  |
| `kind` | `string` |  |
| `mode` | `string` |  |
| `slot` | `number` |  |

