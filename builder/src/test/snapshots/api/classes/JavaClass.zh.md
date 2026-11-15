---
title: "JavaClass"
description: "宿主类的代理：静态字段按值读取，静态方法按可调用分发，new 成员构造实例。"
---

::api-declaration{ kind="handle" name="JavaClass"}
::

## Methods

::api-method

### `className`



**Returns** `string`

::

::api-method

### `hasMember`



| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |

**Returns** `boolean`

::

::api-method

### `instanceOf`



| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `className` | `string` |  | — | — |

**Returns** `boolean`

::

::api-method

### `invoke`



| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |
| `args` | :api-type{text='Array<JsonValue \| JavaObject>' refs='JavaObject=classes/javaobject'} |  | — | — |

**Returns** :api-type{text='JsonValue \| JavaObject' refs='JavaObject=classes/javaobject'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `rawValue`

代理背后的原始宿主值。

**Returns** :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `readCallable`



| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |

**Returns** `Function`

::

::api-method

### `readValue`

读取纯值成员（仅字段）；缺失为 null。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |

**Returns** :api-type{text='JsonValue \| JavaObject' refs='JavaObject=classes/javaobject'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `write`

写公共字段；无可写字段时抛错。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |
| `value` | :api-type{text='JsonValue \| JavaObject' refs='JavaObject=classes/javaobject'} |  | — | — |

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

