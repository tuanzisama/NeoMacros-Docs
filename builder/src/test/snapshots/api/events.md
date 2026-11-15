---
title: "events"
description: "The neo.events module: EventEmitter-style subscription over the event bus. Subscriptions created while a module is loading are attributed to that module and auto-unsubscribed when the module unloads."
---

:api-module-header{ category="Core" neo-name="neo.events" since="0.1.0" mc="*" loader="*"}

## Methods

::api-method

### `emit`

Emits one custom event; the payload is a plain object (or undefined) and delivery is async. The name must be registered first; payload keys must not use the BaseEvent reserved words (type, timestamp, cancellable, direction).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |
| `payload` | `Record<string, JsonValue>` |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `off`

Unsubscribes by the handle returned from / , or by event name when a string is given.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `handleOrName` | :api-type{text='Subscription \| string' refs='Subscription=classes/subscription'} |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `on`

Subscribes asynchronously; the handler runs on the script context's event loop. Wildcard patterns (domain:*, *) are allowed.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |
| `handler` | `(arg: unknown) => void` |  | — | — |

**Returns** :api-type{text='Subscription' refs='Subscription=classes/subscription'} — the subscription handle passed back to

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `onSync`

Subscribes synchronously on the dispatch thread; only cancellable events accept sync subscriptions. The callback receives the mutable event face: rewrite whitelisted fields directly (e.text = ...), cancel with e.cancel() or the writable e.cancelled, and return nothing — the engine commits the writes back to the publisher. Later priorities observe and override earlier writes; MONITOR subscriptions are observation-only. Sync callbacks must stay short; they block the dispatch thread.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |
| `handler` | `Function` |  | — | — |
| `options` | `SyncOptions` | optional { priority: neo.EventPriority.*, ignoreCancelled: boolean } | — | — |

:api-badges{ since="0.5.0" mc="*" loader="*"}

::

::api-method

### `once`

Subscribes for exactly one firing; the subscription auto-unsubscribes.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |
| `handler` | `(arg: unknown) => void` |  | — | — |

**Returns** :api-type{text='Subscription' refs='Subscription=classes/subscription'} — the subscription handle

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `register`

Registers one custom event name owned by scripts. Names must be namespaced (domain:rest) and cannot shadow a built-in domain; custom events are non-cancellable and ride the async channel.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `waitFor`

Waits for one occurrence of the event; the promise settles with the event payload.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |

**Returns** :api-type{text='Promise<BaseEvent>' refs='BaseEvent=classes/baseevent'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `waitForUntil`

Waits for an occurrence matching filter; rejects (promise completes exceptionally) after timeoutMillis. The filter runs on the dispatch thread.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |
| `filter` | `(arg: unknown) => boolean` |  | — | — |
| `timeoutMillis` | `number` |  | — | — |

**Returns** :api-type{text='Promise<BaseEvent>' refs='BaseEvent=classes/baseevent'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

