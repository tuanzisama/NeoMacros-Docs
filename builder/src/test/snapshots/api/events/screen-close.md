---
title: "screen:close"
description: "Payload of the screen close event."
---

::api-event-header{ event="screen:close" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`ScreenCloseEvent`](../types/ScreenCloseEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `screen` | `string` |  |
| `title` | `string` |  |

