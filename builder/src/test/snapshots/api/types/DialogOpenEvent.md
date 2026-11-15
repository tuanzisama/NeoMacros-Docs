---
title: "DialogOpenEvent"
description: "Payload of the dialog open event, fired when the server shows a dialog or a script opens one."
---

::api-type-header{ since="0.3.0" mc=">=1.21.6" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`dialog:open`](../events/dialog/dialog-open.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `actions` | :api-type{text='Array<DialogAction>' refs='DialogAction=classes/dialogaction'} |  |
| `canCloseWithEscape` | `boolean` |  |
| `kind` | `string` |  |
| `title` | `string` |  |

