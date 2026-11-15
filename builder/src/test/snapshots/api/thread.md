---
title: "thread"
description: "The neo.thread module: thread introspection, time-based and main-thread asynchronous primitives, and timers, each bound to the calling script's context event loop. Every scheduling function returns a promise or a cancellable timer handle."
---

:api-module-header{ category="Core" neo-name="neo.thread" since="0.1.0" mc="*" loader="*"}

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `main` | `boolean` | Whether the calling code is currently running on the game main thread. |

## Methods

::api-method

### `after`

Runs the function once on the script loop after millis of real time; the returned handle cancels the pending run.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `millis` | `number` |  | — | — |
| `task` | `() => void` |  | — | — |

**Returns** :api-type{text='TimerHandle' refs='TimerHandle=classes/timerhandle'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `afterTick`

Runs the function once on the script loop after count client tick boundaries; the returned handle cancels the pending run.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `count` | `number` |  | — | — |
| `task` | `() => void` |  | — | — |

**Returns** :api-type{text='TimerHandle' refs='TimerHandle=classes/timerhandle'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `every`

Runs the function on the script loop every millis of real time until the returned handle is cancelled.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `millis` | `number` |  | — | — |
| `task` | `() => void` |  | — | — |

**Returns** :api-type{text='TimerHandle' refs='TimerHandle=classes/timerhandle'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `everyTick`

Runs the function on the script loop every count client tick boundaries until the returned handle is cancelled.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `count` | `number` |  | — | — |
| `task` | `() => void` |  | — | — |

**Returns** :api-type{text='TimerHandle' refs='TimerHandle=classes/timerhandle'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `nextTick`

Resolves at the end of the current client tick (or the next one when called between ticks).

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `runOnMain`

Runs the function on the game main thread; the promise settles with its return value. Calling this from the main thread executes inline.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `task` | `() => any` |  | — | — |

**Returns** `Promise<any>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `sleep`

Resolves after the given delay in milliseconds; the delay is real time, independent of game ticks.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `millis` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `ticks`

Resolves after count client ticks have passed.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `count` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

