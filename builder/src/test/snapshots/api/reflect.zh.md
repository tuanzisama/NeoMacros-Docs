---
title: "reflect"
description: "neo.reflect：穿透层的元级工具箱。neo.java 代理对象，本模块解析精确签名（含私有成员）、反射调用与构造实例。整模块走 java 权限闸。"
---

:api-module-header{ category="系统" neo-name="neo.reflect" since="0.2.0" mc="*" loader="*"}

## Methods

::api-method

### `className`

任意 Java 值的全限定类名（非代理值同样可用）；undefined/null 返回 undefined。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `value` | :api-type{text='JsonValue \| JavaObject' refs='JavaObject=classes/javaobject'} |  | — | — |

**Returns** `string`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `field`

解析已声明字段（含私有）。返回 java.lang.reflect.Field 代理；未命中为 undefined。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `target` | :api-type{text='JavaObject \| JavaClass' refs='JavaObject=classes/javaobject,JavaClass=classes/javaclass'} | 实例或类（JavaClass） | — | — |
| `name` | `string` | 字段名 | — | — |

**Returns** :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `invoke`

反射调用已解析的方法。target 省略（undefined）即静态调用；数字参数按声明类型自动转换。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `method` | :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'} | method() 返回的 Method | — | — |
| `target` | :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'} | 接收者实例；静态调用省略 | ✓ | — |
| `args` | :api-type{text='Array<JsonValue \| JavaObject>' refs='JavaObject=classes/javaobject'} | 参数数组（可省略） | ✓ | — |

**Returns** :api-type{text='JsonValue \| JavaObject' refs='JavaObject=classes/javaobject'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `method`

按精确参数签名解析已声明方法（含私有重载）。参数类型为数组（类名字符串或 JavaClass）。返回 java.lang.reflect.Method 代理；未命中为 undefined。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `target` | :api-type{text='JavaObject \| JavaClass' refs='JavaObject=classes/javaobject,JavaClass=classes/javaclass'} | 实例或类（JavaClass） | — | — |
| `name` | `string` | 方法名 | — | — |
| `paramTypes` | :api-type{text='Array<string \| JavaClass>' refs='JavaClass=classes/javaclass'} | 参数类型数组（可省略） | — | — |

**Returns** :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `newInstance`

反射构造类实例（按参数匹配构造器）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `cls` | :api-type{text='JavaClass \| string' refs='JavaClass=classes/javaclass'} | JavaClass 或类名字符串 | — | — |
| `args` | :api-type{text='Array<JsonValue \| JavaObject>' refs='JavaObject=classes/javaobject'} | 构造参数数组（可省略） | ✓ | — |

**Returns** :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

