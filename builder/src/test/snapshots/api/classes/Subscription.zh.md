---
title: "Subscription"
description: "一条事件订阅的句柄；由 events.on / once / onSync 返回给脚本。经句柄退订即从分发中移除；模块卸载按同一方式遍历其句柄。"
---

::api-declaration{ kind="handle" name="Subscription"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `active` | `boolean` | 订阅是否仍在接收事件。 :api-badge{kind="readonly"} |
| `sync` | `boolean` | 是否为同步通道订阅。 :api-badge{kind="readonly"} |
| `wildcard` | `boolean` | 模式是否为通配而非精确名。 :api-badge{kind="readonly"} |

## Methods

::api-method

### `pattern`

订阅模式：精确事件名或通配（domain:*、*）。

**Returns** `string`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `unsubscribe`

退订；重复调用无副作用。

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

