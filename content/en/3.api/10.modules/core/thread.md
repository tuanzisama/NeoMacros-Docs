---
title: "thread"
description: "The neo.thread facade: thread introspection, time-based and main-thread asynchronous primitives, and timers, each bound to the calling script's context event loop. Every scheduling function returns a promise or a cancellable timer handle."
---

:api-module-header{ category="Core" global="true" neo-name="neo.thread" esm-name="@neomacros/thread" since="0.1.0" mc="*" loader="*"}

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `main` | `boolean` | Whether the calling code is currently running on the game main thread. |

## Methods

### `after(millis: number, task: () => void)`

Runs the function once on the script loop after millis of real time; the returned handle cancels the pending run.

**Parameters**

- `millis` `number`: 
- `task` `() => void`: 

**Returns** `TimerHandle`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `afterTick(count: number, task: () => void)`

Runs the function once on the script loop after count client tick boundaries; the returned handle cancels the pending run.

**Parameters**

- `count` `number`: 
- `task` `() => void`: 

**Returns** `TimerHandle`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `every(millis: number, task: () => void)`

Runs the function on the script loop every millis of real time until the returned handle is cancelled.

**Parameters**

- `millis` `number`: 
- `task` `() => void`: 

**Returns** `TimerHandle`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `everyTick(count: number, task: () => void)`

Runs the function on the script loop every count client tick boundaries until the returned handle is cancelled.

**Parameters**

- `count` `number`: 
- `task` `() => void`: 

**Returns** `TimerHandle`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `nextTick()`

Resolves at the end of the current client tick (or the next one when called between ticks).

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `runOnMain(task: () => unknown)`

Runs the function on the game main thread; the promise settles with its return value. Calling this from the main thread executes inline.

**Parameters**

- `task` `() => unknown`: 

**Returns** `Promise<object>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `sleep(millis: number)`

Resolves after the given delay in milliseconds; the delay is real time, independent of game ticks.

**Parameters**

- `millis` `number`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `ticks(count: number)`

Resolves after count client ticks have passed.

**Parameters**

- `count` `number`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}


## Examples

Debounce a burst of calls into one delayed run, and pause an async flow in real time.

```js
const { thread } = neo;

let scheduled = false;

// Debounce: collapse a burst of calls into one delayed run
function request() {
  if (scheduled) return;
  scheduled = true;
  thread.after(250, () => {
    scheduled = false; // do the coalesced work here
  });
}

request(); // schedules the run 250 ms out
await thread.sleep(5000); // timers double as promises
```
