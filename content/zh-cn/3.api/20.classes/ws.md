---
title: "Ws"
description: "活的 WebSocket 连接。事件经 on 订阅：open、message（字符串载荷）、close、error（错误消息）。"
---

Handle

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `url` | `string` | 连接的 URL。 (read-only) |

## Methods

### `close()`

优雅地关闭连接。

Since: 0.2.0 · MC: * · Loader: *

### `on(name: string, handler: (arg: unknown) => void)`

订阅事件（open/message/close/error）。

**Parameters**

- `name` `string`: 事件名
- `handler` `(arg: unknown) => void`: 

Since: 0.2.0 · MC: * · Loader: *

### `send(data: string)`

发送一帧文本。

**Parameters**

- `data` `string`: 文本内容

Since: 0.2.0 · MC: * · Loader: *

### `toString()`



**Returns** `string`

