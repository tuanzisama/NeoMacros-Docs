---
title: "ScreenChangeEvent"
description: "Payload of the screen change event, fired on every screen transition: opens, closes, and direct switches between screens. The generic channel for anything on screen (inventory, dialog, and menu screens included); domain events add their own detail."
---

::api-type-header{ since="0.3.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`screen:change`](../events/screen/screen-change.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `kind` | `string` |  |
| `phase` | `string` |  |
| `screen` | `string` |  |
| `title` | `string` |  |

