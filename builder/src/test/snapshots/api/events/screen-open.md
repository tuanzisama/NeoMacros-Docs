---
title: "screen:open"
description: "Payload of the screen open event."
---

::api-event-header{ event="screen:open" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`ScreenOpenEvent`](../types/ScreenOpenEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `kind` | `string` |  |
| `screen` | `string` |  |
| `title` | `string` |  |

