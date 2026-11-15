---
title: "thread"
description: "neo.thread：线程自省、基于时间与主线程的异步原语与定时器，各自绑定调用脚本的上下文事件循环；调度函数返回 Promise 或可取消的定时器句柄。"
---

:api-module-header{ category="核心" neo-name="neo.thread" since="0.1.0" mc="*" loader="*"}

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `main` | `boolean` | 当前代码是否在游戏主线程上执行。 |

## Methods

::api-method

### `after`

毫秒后在脚本事件循环上执行一次函数；返回句柄可取消。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `millis` | `number` |  | — | — |
| `task` | `() => void` |  | — | — |

**Returns** :api-type{text='TimerHandle' refs='TimerHandle=classes/timerhandle'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `afterTick`

指定数量的客户端 tick 后在脚本事件循环上执行一次函数；返回句柄可取消。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `count` | `number` |  | — | — |
| `task` | `() => void` |  | — | — |

**Returns** :api-type{text='TimerHandle' refs='TimerHandle=classes/timerhandle'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `every`

每隔指定毫秒在脚本事件循环上执行函数，直到句柄取消。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `millis` | `number` |  | — | — |
| `task` | `() => void` |  | — | — |

**Returns** :api-type{text='TimerHandle' refs='TimerHandle=classes/timerhandle'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `everyTick`

每隔指定数量的客户端 tick 在脚本事件循环上执行函数，直到句柄取消。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `count` | `number` |  | — | — |
| `task` | `() => void` |  | — | — |

**Returns** :api-type{text='TimerHandle' refs='TimerHandle=classes/timerhandle'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `nextTick`

等待当前 tick 结束。

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `runOnMain`

将函数投递到游戏主线程执行，Promise 以返回值落定。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `task` | `() => any` |  | — | — |

**Returns** `Promise<any>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `sleep`

毫秒级实时延时。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `millis` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `ticks`

等待指定数量的客户端 tick。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `count` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

