---
title: "net"
description: "The neo.net module: HTTP client with fetch semantics. Requests run on a dedicated IO executor and require the net capability; the promise settles with a live whose body readers (text(), json(), bytes()) are async. Each settled request is also recorded through for the DevTools network panel — previews always, phase timings, and full bodies up to only while a sink listens. Recording is free when no dispatcher listens."
---

:api-module-header{ category="System" neo-name="neo.net" since="0.1.0" mc="*" loader="*"}

**Classes**

[`RequestInit`](classes/RequestInit.html) · [`Response`](classes/Response.html) · [`Ws`](classes/Ws.html)

## Methods

::api-method

### `connect`

Opens a WebSocket connection and resolves with the live socket once the handshake completes; handshake failures reject. Requires the net capability (module-level gate).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `url` | `string` |  | — | — |

**Returns** :api-type{text='Promise<Ws>' refs='Ws=classes/ws'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `fetch`

Performs an HTTP request with fetch semantics. The init object carries method (default GET), headers (map) and body (string).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `url` | `string` |  | — | — |
| `init` | :api-type{text='RequestInit' refs='RequestInit=classes/requestinit'} |  | ✓ | — |

**Returns** :api-type{text='Promise<Response>' refs='Response=classes/response'}

:api-badges{ since="0.1.0" mc="*" loader="*" permission="net"}

::

::api-method

### `get`

Performs an HTTP GET; convenience form of .

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `url` | `string` |  | — | — |

**Returns** :api-type{text='Promise<Response>' refs='Response=classes/response'}

:api-badges{ since="0.1.0" mc="*" loader="*" permission="net"}

::

::api-method

### `post`

Performs an HTTP POST with a string body; convenience form of .

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `url` | `string` |  | — | — |
| `body` | `string` |  | — | — |

**Returns** :api-type{text='Promise<Response>' refs='Response=classes/response'}

:api-badges{ since="0.1.0" mc="*" loader="*" permission="net"}

::

