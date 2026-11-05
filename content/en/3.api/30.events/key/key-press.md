---
title: "key:press"
---

Payload: [`KeyPressEvent`](../types/keypressevent) · Cancellable · Since: 0.1.0 · MC: * · Loader: *

Payload of the raw keyboard event; synchronous subscribers may cancel the key press before the game processes it.

| Field | Type | Description |
| --- | --- | --- |
| `action` | `string` |  |
| `code` | `number` |  |
| `key` | `string` |  |
| `modifiers` | `Array<string>` |  |

