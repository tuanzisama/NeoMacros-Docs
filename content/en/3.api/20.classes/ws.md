---
title: "Ws"
description: "Live WebSocket connection. Events surface through on with the names open, message (string payload), close, and error (message string)."
---

Handle

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `url` | `string` | The connected URL. (read-only) |

## Methods

### `close()`

Closes the connection gracefully.

Since: 0.2.0 · MC: * · Loader: *

### `on(name: string, handler: (arg: unknown) => void)`

Subscribes one event handler (open/message/ close/error).

**Parameters**

- `name` `string`: 事件名
- `handler` `(arg: unknown) => void`: 

Since: 0.2.0 · MC: * · Loader: *

### `send(data: string)`

Sends one text frame.

**Parameters**

- `data` `string`: 文本内容

Since: 0.2.0 · MC: * · Loader: *

### `toString()`



**Returns** `string`

