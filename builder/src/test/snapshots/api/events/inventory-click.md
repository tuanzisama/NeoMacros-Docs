---
title: "inventory:click"
description: "Payload of the inventory click event, fired after a container slot click is processed (manual clicks and script-issued clicks share the path)."
---

::api-event-header{ event="inventory:click" direction="local" since="0.3.0" mc="*" loader="*"}
#payload
[`InventoryClickEvent`](../types/InventoryClickEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `button` | `number` |  |
| `containerId` | `number` |  |
| `kind` | `string` |  |
| `shift` | `boolean` |  |
| `slot` | `number` |  |

