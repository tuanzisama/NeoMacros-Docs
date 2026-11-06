---
title: "net"
description: "The neo.net facade: HTTP client with fetch semantics. Requests run on a dedicated IO executor and require the net capability; the promise settles with a live whose body readers (text(), json(), bytes()) are async. Each settled request is also recorded through for the DevTools network panel — previews always, phase timings, and full bodies up to only while a sink listens. Recording is free when no dispatcher listens."
---

Category: System · Since: 0.1.0 · MC availability: * · Loader availability: * · Exposed as `neo.net` and `@neomacros/net`

**Classes**

[`Ws`](../../classes/ws)

## Methods

### `connect(url: string)`

Opens a WebSocket connection and resolves with the live socket once the handshake completes; handshake failures reject. Requires the net capability (module-level gate).

**Parameters**

- `url` `string`: ws(s):// URL

**Returns** `Promise<`[Ws](../../classes/ws)`>`

Since: 0.2.0 · MC: * · Loader: *

### `fetch(url: string, init: unknown)`

Performs an HTTP request with fetch semantics. The init object carries method (default GET), headers (map) and body (string).

**Parameters**

- `url` `string`: 绝对 http(s) URL
- `init` `unknown`: 请求初始化对象（可省略）

**Returns** `Promise<Response>`

Since: 0.1.0 · MC: * · Loader: * · Permission: `net`

### `get(url: string)`

Performs an HTTP GET; convenience form of .

**Parameters**

- `url` `string`: 

**Returns** `Promise<Response>`

Since: 0.1.0 · MC: * · Loader: * · Permission: `net`

### `post(url: string, body: string)`

Performs an HTTP POST with a string body; convenience form of .

**Parameters**

- `url` `string`: 
- `body` `string`: 

**Returns** `Promise<Response>`

Since: 0.1.0 · MC: * · Loader: * · Permission: `net`


## Examples

Perform HTTP requests with fetch semantics; this needs the net capability, and response body readers are async.

```js
const { net } = neo;

// Requires the net capability; body readers are async
const res = await net.get('https://api.example.com/status');
if (res.ok) {
  const data = await res.json(); // parsed body
}

// POST with full fetch semantics: method, headers, string body
await net.fetch('https://api.example.com/hook', {
  method: 'POST',
  headers: { 'content-type': 'application/json' },
  body: JSON.stringify({ event: 'joined' }),
});
```
