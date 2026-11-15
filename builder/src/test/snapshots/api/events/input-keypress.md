---
title: "input:keyPress"
description: "Payload of the raw keyboard event; synchronous subscribers may cancel the key press before the game processes it."
---

::api-event-header{ event="input:keyPress" direction="c2s" cancellable="true" since="0.1.0" mc="*" loader="*"}
#payload
[`InputKeyPressEvent`](../types/InputKeyPressEvent.html)
::

**Direction**: `c2s` — client-to-server action interception: cancelling suppresses the action.

| Field | Type | Description |
| --- | --- | --- |
| `action` | `string` |  |
| `code` | `number` |  |
| `key` | `string` |  |
| `modifiers` | `Array<string>` |  |

