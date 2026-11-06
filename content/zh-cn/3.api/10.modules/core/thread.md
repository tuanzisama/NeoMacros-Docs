---
title: "thread"
description: "neo.thread 门面：线程自省、基于时间与主线程的异步原语与定时器，各自绑定调用脚本的上下文事件循环；调度函数返回 Promise 或可取消的定时器句柄。"
---

:api-module-header{ category="核心" global="true" neo-name="neo.thread" esm-name="@neomacros/thread" since="0.1.0" mc="*" loader="*"}

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `main` | `boolean` | 当前代码是否在游戏主线程上执行。 |

## Methods

### `after(millis: number, task: () => void)`

毫秒后在脚本事件循环上执行一次函数；返回句柄可取消。

**Parameters**

- `millis` `number`: 
- `task` `() => void`: 

**Returns** `TimerHandle`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `afterTick(count: number, task: () => void)`

指定数量的客户端 tick 后在脚本事件循环上执行一次函数；返回句柄可取消。

**Parameters**

- `count` `number`: 
- `task` `() => void`: 

**Returns** `TimerHandle`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `every(millis: number, task: () => void)`

每隔指定毫秒在脚本事件循环上执行函数，直到句柄取消。

**Parameters**

- `millis` `number`: 
- `task` `() => void`: 

**Returns** `TimerHandle`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `everyTick(count: number, task: () => void)`

每隔指定数量的客户端 tick 在脚本事件循环上执行函数，直到句柄取消。

**Parameters**

- `count` `number`: 
- `task` `() => void`: 

**Returns** `TimerHandle`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `nextTick()`

等待当前 tick 结束。

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `runOnMain(task: () => unknown)`

将函数投递到游戏主线程执行，Promise 以返回值落定。

**Parameters**

- `task` `() => unknown`: 

**Returns** `Promise<object>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `sleep(millis: number)`

毫秒级实时延时。

**Parameters**

- `millis` `number`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `ticks(count: number)`

等待指定数量的客户端 tick。

**Parameters**

- `count` `number`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}


## Examples

用 after 把一阵高频调用防抖合并成一次延迟执行，再用 sleep 在异步流程中按真实时间暂停。

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
