---
title: "fs"
description: "The neo.fs module: filesystem access relative to the game directory. Paths are resolved against the game directory; absolute paths and traversal above it raise . Every function is async (promise-returning) and requires the fs capability."
---

:api-module-header{ category="System" neo-name="neo.fs" since="0.1.0" mc="*" loader="*"}

**Classes**

[`FileHandle`](classes/FileHandle.html) · [`FileStat`](classes/FileStat.html)

## Methods

::api-method

### `copy`

Copies a file; fails when the target already exists.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `from` | `string` |  | — | — |
| `to` | `string` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `delete`

Deletes a file or empty directory.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `path` | `string` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `exists`

Returns whether a file or directory exists.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `path` | `string` |  | — | — |

**Returns** `Promise<boolean>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `list`

Lists one directory level as a sorted list of entry names.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `path` | `string` |  | — | — |

**Returns** `Promise<Array<string>>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `mkdir`

Creates a directory (including parents).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `path` | `string` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `move`

Moves a file or directory; fails when the target already exists.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `from` | `string` |  | — | — |
| `to` | `string` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `open`

Opens one file handle for streamed reads, attribute queries, and the java-gated raw path.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `path` | `string` |  | — | — |

**Returns** :api-type{text='FileHandle' refs='FileHandle=classes/filehandle'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `readBytes`

Reads one file as raw bytes (each element 0-255; the engine renders the result as a Uint8Array).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `path` | `string` |  | — | — |

**Returns** `Promise<Uint8Array>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `readJSON`

Reads a JSON file into neutral values (objects, arrays, strings, numbers, booleans).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `path` | `string` |  | — | — |

**Returns** `Promise<JsonValue>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `readText`

Reads a UTF-8 text file.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `path` | `string` | path relative to the game directory | — | — |

**Returns** `Promise<string>` — promise of the file content

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `stat`

Returns file metadata: size, mtimeMs, isDir, isFile.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `path` | `string` |  | — | — |

**Returns** :api-type{text='Promise<FileStat>' refs='FileStat=classes/filestat'}

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `toRelative`

Returns the path relative to the game directory root; paths outside the root throw.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `path` | `string` |  | — | — |

**Returns** `string`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `writeBytes`

Writes raw bytes to a file (creating parent directories). The data argument is an array-like of byte values.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `path` | `string` |  | — | — |
| `data` | `Array<number> | string` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `writeJSON`

Writes neutral values into a JSON file (creating parent directories).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `path` | `string` |  | — | — |
| `value` | `JsonValue` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `writeText`

Writes a UTF-8 text file (creating parent directories).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `path` | `string` |  | — | — |
| `content` | `string` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

