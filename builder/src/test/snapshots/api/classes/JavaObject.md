---
title: "JavaObject"
description: "Proxy over one host object: public fields read and write as values, methods dispatch as callables bound to the instance."
---

::api-declaration{ kind="handle" name="JavaObject"}
::

## Methods

::api-method

### `className`



**Returns** `string`

::

::api-method

### `hasMember`



| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |

**Returns** `boolean`

::

::api-method

### `instanceOf`



| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `className` | `string` |  | — | — |

**Returns** `boolean`

::

::api-method

### `invoke`



| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |
| `args` | :api-type{text='Array<JsonValue \| JavaObject>' refs='JavaObject=classes/javaobject'} |  | — | — |

**Returns** :api-type{text='JsonValue \| JavaObject' refs='JavaObject=classes/javaobject'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `raw`

The wrapped host object (interop argument adaptation unwraps it).

**Returns** :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `rawValue`

The raw host value behind this proxy.

**Returns** :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `readCallable`



| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |

**Returns** `Function`

::

::api-method

### `readValue`

Reads a plain-value member (fields only), or null when absent.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |

**Returns** :api-type{text='JsonValue \| JavaObject' refs='JavaObject=classes/javaobject'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `write`

Writes a public field; throws when no writable field carries the name.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |
| `value` | :api-type{text='JsonValue \| JavaObject' refs='JavaObject=classes/javaobject'} |  | — | — |

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

