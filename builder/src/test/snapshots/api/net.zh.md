---
title: "net"
description: "neo.net：fetch 语义的 HTTP 客户端。请求在专用 IO 线程池执行，需 net 能力授权；Promise 以活 Response 落定，其 body 读取器（text()、json()、bytes()）均为异步。每次请求落定会经 记录到 DevTools 网络面板——预览恒记，阶段计时与 ≤ 的完整 body 仅在有监听时保留；无监听时记录近乎零开销。"
---

:api-module-header{ category="系统" neo-name="neo.net" since="0.1.0" mc="*" loader="*"}

**Classes**

[`RequestInit`](classes/RequestInit.html) · [`Response`](classes/Response.html) · [`Ws`](classes/Ws.html)

## Methods

::api-method

### `connect`

打开 WebSocket 连接，握手完成后以活连接落定；握手失败 reject。需 net 能力授权。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `url` | `string` | ws(s):// URL | — | — |

**Returns** :api-type{text='Promise<Ws>' refs='Ws=classes/ws'} — Promise，以 Ws 落定

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `fetch`

以 fetch 语义发起 HTTP 请求；init 携带 method/headers/body。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `url` | `string` | 绝对 http(s) URL | — | — |
| `init` | :api-type{text='RequestInit' refs='RequestInit=classes/requestinit'} | 请求初始化对象（可省略） | ✓ | — |

**Returns** :api-type{text='Promise<Response>' refs='Response=classes/response'} — Promise，以 Response 落定

:api-badges{ since="0.1.0" mc="*" loader="*" permission="net"}

::

::api-method

### `get`

发起 HTTP GET（fetch 的便捷形式）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `url` | `string` |  | — | — |

**Returns** :api-type{text='Promise<Response>' refs='Response=classes/response'}

:api-badges{ since="0.1.0" mc="*" loader="*" permission="net"}

::

::api-method

### `post`

发起带文本请求体的 HTTP POST（fetch 的便捷形式）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `url` | `string` |  | — | — |
| `body` | `string` |  | — | — |

**Returns** :api-type{text='Promise<Response>' refs='Response=classes/response'}

:api-badges{ since="0.1.0" mc="*" loader="*" permission="net"}

::

