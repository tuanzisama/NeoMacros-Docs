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

::api-method

### `close`

优雅地关闭连接。

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `on`

订阅事件（open/message/close/error）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `name` | `string` | 事件名 | — | — |
| `handler` | `(payload: string | undefined) => void` |  | — | — |

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `send`

发送一帧文本。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `data` | `string` | 文本内容 | — | — |

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

