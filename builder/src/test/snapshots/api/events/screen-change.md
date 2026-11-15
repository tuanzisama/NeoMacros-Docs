---
title: "screen:change"
description: "Payload of the screen change event, fired on every screen transition: opens, closes, and direct switches between screens. The generic channel for anything on screen (inventory, dialog, and menu screens included); domain events add their own detail."
---

::api-event-header{ event="screen:change" direction="local" since="0.3.0" mc="*" loader="*"}
#payload
[`ScreenChangeEvent`](../types/ScreenChangeEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `kind` | `string` |  |
| `phase` | `string` |  |
| `screen` | `string` |  |
| `title` | `string` |  |

