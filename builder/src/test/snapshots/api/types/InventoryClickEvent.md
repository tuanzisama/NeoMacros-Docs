---
title: "InventoryClickEvent"
description: "Payload of the inventory click event, fired after a container slot click is processed (manual clicks and script-issued clicks share the path)."
---

::api-type-header{ since="0.3.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`inventory:click`](../events/inventory/inventory-click.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `button` | `number` |  |
| `containerId` | `number` |  |
| `kind` | `string` |  |
| `shift` | `boolean` |  |
| `slot` | `number` |  |

