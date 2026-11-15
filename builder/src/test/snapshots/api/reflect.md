---
title: "reflect"
description: "The neo.reflect module: meta-level tools for the escape layer. Where neo.java proxies objects, this module resolves exact signatures (including private members), invokes reflectively, and constructs instances. The whole module rides the java permission gate."
---

:api-module-header{ category="System" neo-name="neo.reflect" since="0.2.0" mc="*" loader="*"}

## Methods

::api-method

### `className`

The fully-qualified class name of any Java value (works on non-proxied values too), or undefined for undefined/null.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `value` | :api-type{text='JsonValue \| JavaObject' refs='JavaObject=classes/javaobject'} |  | — | — |

**Returns** `string`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `field`

Resolves one declared field, including private fields. Returns the java.lang.reflect.Field proxy, or undefined on a miss.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `target` | :api-type{text='JavaObject \| JavaClass' refs='JavaObject=classes/javaobject,JavaClass=classes/javaclass'} |  | — | — |
| `name` | `string` |  | — | — |

**Returns** :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `invoke`

Invokes one resolved reflect method. Omitting the target invokes a static method; numeric arguments convert to the declared parameter types.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `method` | :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'} |  | — | — |
| `target` | :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'} |  | ✓ | — |
| `args` | :api-type{text='Array<JsonValue \| JavaObject>' refs='JavaObject=classes/javaobject'} |  | ✓ | — |

**Returns** :api-type{text='JsonValue \| JavaObject' refs='JavaObject=classes/javaobject'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `method`

Resolves one declared method with an exact parameter signature, including private overloads. Parameter types arrive as an array of class-name strings or JavaClass values. Returns the java.lang.reflect.Method proxy, or undefined on a miss.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `target` | :api-type{text='JavaObject \| JavaClass' refs='JavaObject=classes/javaobject,JavaClass=classes/javaclass'} |  | — | — |
| `name` | `string` |  | — | — |
| `paramTypes` | :api-type{text='Array<string \| JavaClass>' refs='JavaClass=classes/javaclass'} |  | — | — |

**Returns** :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `newInstance`

Reflectively constructs one instance of the class with the matching constructor.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `cls` | :api-type{text='JavaClass \| string' refs='JavaClass=classes/javaclass'} |  | — | — |
| `args` | :api-type{text='Array<JsonValue \| JavaObject>' refs='JavaObject=classes/javaobject'} |  | ✓ | — |

**Returns** :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

