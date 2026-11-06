---
title: "Ws"
description: "活的 WebSocket 连接。事件经 on 订阅：open、message（字符串载荷）、close、error（错误消息）。"
---

::api-declaration{ kind="handle" name="Ws"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `url` | `string` | 连接的 URL。 :api-badge{kind="readonly"} |

## Methods

### `close()`

优雅地关闭连接。

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `on(name: string, handler: (arg: unknown) => void)`

订阅事件（open/message/close/error）。

**Parameters**

- `name` `string`: 事件名
- `handler` `(arg: unknown) => void`: 

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `send(data: string)`

发送一帧文本。

**Parameters**

- `data` `string`: 文本内容

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `toString()`



**Returns** `string`

