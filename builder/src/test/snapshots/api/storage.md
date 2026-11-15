---
title: "storage"
description: "The neo.storage module: persistent per-script key-value storage. Values must be JSON-serializable plain data (objects, arrays, strings, numbers, booleans); each script owns an isolated store keyed by its source file name, surviving reloads and game restarts."
---

:api-module-header{ category="Core" neo-name="neo.storage" since="0.1.0" mc="*" loader="*"}

## Methods

::api-method

### `get`

Reads one value, or null when absent.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `key` | `string` |  | — | — |

**Returns** `JsonValue`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `has`

Returns whether the key exists.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `key` | `string` |  | — | — |

**Returns** `boolean`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `put`

Writes one value (JSON-serializable plain data); null deletes the key.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `key` | `string` |  | — | — |
| `value` | `JsonValue` |  | ✓ | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `remove`

Removes one key.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `key` | `string` |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

