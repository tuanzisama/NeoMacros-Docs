---
title: "storage"
description: "neo.storage：按脚本隔离的持久键值存储。值必须是可 JSON 序列化的纯数据（对象/数组/字符串/数字/布尔）；每个脚本按源文件名拥有独立存储，跨重载与游戏重启保留。"
---

:api-module-header{ category="核心" neo-name="neo.storage" since="0.1.0" mc="*" loader="*"}

## Methods

::api-method

### `get`

读取一个值；不存在时返回 null。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `key` | `string` |  | — | — |

**Returns** `JsonValue`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `has`

判断键是否存在。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `key` | `string` |  | — | — |

**Returns** `boolean`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `put`

写入一个值；传 null 等同删除该键。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `key` | `string` |  | — | — |
| `value` | `JsonValue` |  | ✓ | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `remove`

删除一个键。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `key` | `string` |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

