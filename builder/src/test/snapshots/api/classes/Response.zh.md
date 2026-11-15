---
title: "Response"
description: "活的 HTTP 响应：状态/响应头属性加异步 body 读取器（text()、json()、bytes()）。"
---

::api-declaration{ kind="handle" name="Response"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `headers` | `Record<string, string>` | 响应头（键为小写名）。 :api-badge{kind="readonly"} |
| `ok` | `boolean` | 状态码是否在 2xx 区间。 :api-badge{kind="readonly"} |
| `status` | `number` | HTTP 状态码。 :api-badge{kind="readonly"} |

## Methods

::api-method

### `bytes`

按原始字节读取 body（渲染为 Uint8Array）。

**Returns** `Promise<Uint8Array>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `json`

把 body 解析为 JSON；非法 JSON 时 reject。

**Returns** `Promise<JsonValue>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `text`

以 UTF-8 文本读取 body。

**Returns** `Promise<string>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

