---
title: "java"
description: "The neo.java module: the escape layer over the host JVM. Class lookup uses binary names (Mojmap for Minecraft classes, translated at the call site by the mapping layer); every capability of this module requires the java permission — granting it hands the script full host access with no class filtering. Construction happens through the class proxy's new(...) member; results wrap as object proxies whose members reach unwrapped Java fields and methods."
---

:api-module-header{ category="System" neo-name="neo.java" since="0.1.0" mc="*" loader="*"}

## Methods

::api-method

### `fromList`

Converts one host collection into a script array (element by element).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `javaCollection` | :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'} |  | — | — |

**Returns** :api-type{text='Array<JsonValue \| JavaObject>' refs='JavaObject=classes/javaobject'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `proxy`

Builds one host object implementing the named interfaces, dispatching method calls to the handler map's functions (void-return dispatch; unhandled methods raise).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `interfaces` | `Array<string> | string` |  | — | — |
| `handlers` | `Record<string, Function>` |  | — | — |

**Returns** :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `toArray`

Converts one script array into a host array of the named component type (empty name → Object[]).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `scriptArray` | :api-type{text='Array<JsonValue \| JavaObject>' refs='JavaObject=classes/javaobject'} |  | — | — |
| `componentTypeName` | `string` |  | — | — |

**Returns** :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `toList`

Converts one script array into a host list wrapped as an interop object, so it crosses back into Java APIs as a live java.util.List.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `scriptArray` | :api-type{text='Array<JsonValue \| JavaObject>' refs='JavaObject=classes/javaobject'} |  | — | — |

**Returns** :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `type`

Looks up one host class by its binary name, e.g. java.util.UUID. The returned class proxy exposes static fields and methods directly, and new(...) constructs instances.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `className` | `string` |  | — | — |
| `alternate` | `string` |  | — | — |

**Returns** :api-type{text='JavaClass' refs='JavaClass=classes/javaclass'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `wrap`

Wraps one raw host object into its registered handle (entity handles, block state data); unregistered types return null. The inverse of the handles' raw escape hatch.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `raw` | :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'} |  | — | — |

**Returns** `object`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

