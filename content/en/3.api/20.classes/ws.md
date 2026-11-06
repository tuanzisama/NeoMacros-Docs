---
title: "Ws"
description: "Live WebSocket connection. Events surface through on with the names open, message (string payload), close, and error (message string)."
---

::api-declaration{ kind="handle" name="Ws"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `url` | `string` | The connected URL. :api-badge{kind="readonly"} |

## Methods

### `close()`

Closes the connection gracefully.

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `on(name: string, handler: (arg: unknown) => void)`

Subscribes one event handler (open/message/ close/error).

**Parameters**

- `name` `string`: 事件名
- `handler` `(arg: unknown) => void`: 

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `send(data: string)`

Sends one text frame.

**Parameters**

- `data` `string`: 文本内容

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `toString()`



**Returns** `string`

