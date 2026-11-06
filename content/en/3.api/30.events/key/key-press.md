---
title: "key:press"
description: "Payload of the raw keyboard event; synchronous subscribers may cancel the key press before the game processes it."
---

::api-event-header{ event="key:press" cancellable="true" since="0.1.0" mc="*" loader="*"}
#payload
[`KeyPressEvent`](../../classes/keypressevent)
::

| Field | Type | Description |
| --- | --- | --- |
| `action` | `string` |  |
| `code` | `number` |  |
| `key` | `string` |  |
| `modifiers` | `Array<string>` |  |

