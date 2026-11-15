---
title: "dialog:open"
description: "Payload of the dialog open event, fired when the server shows a dialog or a script opens one."
---

::api-event-header{ event="dialog:open" direction="local" since="0.3.0" mc=">=1.21.6" loader="*"}
#payload
[`DialogOpenEvent`](../types/DialogOpenEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `actions` | :api-type{text='Array<DialogAction>' refs='DialogAction=classes/dialogaction'} |  |
| `canCloseWithEscape` | `boolean` |  |
| `kind` | `string` |  |
| `title` | `string` |  |

