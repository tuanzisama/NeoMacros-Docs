---
title: "events"
description: "neo.events：事件总线上的 EventEmitter 风格订阅。模块装载期创建的订阅归属该模块，模块卸载时自动退订。"
---

:api-module-header{ category="核心" neo-name="neo.events" since="0.1.0" mc="*" loader="*"}

## Methods

::api-method

### `emit`

触发一个自定义事件；载荷须为普通对象（或 undefined），走异步通道。名称须先注册；载荷键不得占用 BaseEvent 保留字（type、timestamp、cancellable、direction）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |
| `payload` | `Record<string, JsonValue>` |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `off`

按句柄或事件名注销订阅。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `handleOrName` | :api-type{text='Subscription \| string' refs='Subscription=classes/subscription'} |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `on`

异步订阅事件；处理器在脚本上下文的事件循环线程上执行。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `name` | `string` | 事件名，支持 domain:* 与 * 通配 | — | — |
| `handler` | `(arg: unknown) => void` | 事件载荷处理器 | — | — |

**Returns** :api-type{text='Subscription' refs='Subscription=classes/subscription'} — 传回 的订阅句柄

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `onSync`

在分发线程上同步订阅；仅可取消事件可用。回调收到可变事件面：直接改写白名单字段、用 e.cancel() 或可写的 e.cancelled 取消，无需返回值——引擎把修改提交回发布方。后执行的优先级能看到并覆盖先前修改；MONITOR 仅作观测。同步回调必须短小，会阻塞分发线程。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `name` | `string` | 事件名（仅可取消事件） | — | — |
| `handler` | `Function` | 处理回调：通过事件对象提交修改与取消；须短小 | — | — |
| `options` | `SyncOptions` | 可选 { priority: neo.EventPriority.*, ignoreCancelled: 布尔 } | — | — |

:api-badges{ since="0.5.0" mc="*" loader="*"}

::

::api-method

### `once`

订阅一次触发后自动注销的事件。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |
| `handler` | `(arg: unknown) => void` |  | — | — |

**Returns** :api-type{text='Subscription' refs='Subscription=classes/subscription'} — 订阅句柄

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `register`

注册脚本自定义事件；名称必须带命名空间，且不能占用内置域。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `waitFor`

等待事件的下一次触发，Promise 以载荷落定。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |

**Returns** :api-type{text='Promise<BaseEvent>' refs='BaseEvent=classes/baseevent'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `waitForUntil`

按过滤谓词等待事件；超时后 Promise 以异常落定。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |
| `filter` | `(arg: unknown) => boolean` |  | — | — |
| `timeoutMillis` | `number` |  | — | — |

**Returns** :api-type{text='Promise<BaseEvent>' refs='BaseEvent=classes/baseevent'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

