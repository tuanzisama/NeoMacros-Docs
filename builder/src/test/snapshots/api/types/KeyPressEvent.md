---
title: "KeyPressEvent"
description: "Payload of the raw keyboard event; synchronous subscribers may cancel the key press before the game processes it."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](BaseEvent.html)
#raised-by
[`key:press`](../events/key/key-press.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `action` | `string` |  |
| `code` | `number` |  |
| `key` | `string` |  |
| `modifiers` | `Array<string>` |  |

