---
title: "BaseEvent"
description: "所有事件载荷共用的基类；分发到脚本的事件实例都是它的冻结子类实例。"
---

| Property | Type | Description |
| --- | --- | --- |
| `type` | `string` | 事件名，如 `chat:receive`。 |
| `direction` | `'c2s' | 's2c' | 'local'` | 事件流向：上行拦截 / 下行显示 / 本地状态。 |
| `timestamp` | `number` | 事件分发时的毫秒时间戳。 |
| `cancellable` | `boolean` | 本事件是否可取消。 |

## Methods

::api-method

### `toJSON()`

返回事件的普通对象形式，可直接 `JSON.stringify`。

::

