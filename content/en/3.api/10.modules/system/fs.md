---
title: "fs"
description: "The neo.fs facade: filesystem access relative to the game directory. Paths are resolved against the game directory; absolute paths and traversal above it raise . Every function is async (promise-returning) and requires the fs capability."
---

:api-module-header{ category="System" global="true" neo-name="neo.fs" esm-name="@neomacros/fs" since="0.1.0" mc="*" loader="*"}

**Classes**

[`FileHandle`](../../classes/filehandle)

## Methods

### `copy(from: string, to: string)`

Copies a file; fails when the target already exists.

**Parameters**

- `from` `string`: 
- `to` `string`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `delete(path: string)`

Deletes a file or empty directory.

**Parameters**

- `path` `string`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `exists(path: string)`

Returns whether a file or directory exists.

**Parameters**

- `path` `string`: 

**Returns** `Promise<boolean>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `list(path: string)`

Lists one directory level as a sorted list of entry names.

**Parameters**

- `path` `string`: 

**Returns** `Promise<Array<string>>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `mkdir(path: string)`

Creates a directory (including parents).

**Parameters**

- `path` `string`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `move(from: string, to: string)`

Moves a file or directory; fails when the target already exists.

**Parameters**

- `from` `string`: 
- `to` `string`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `open(path: string)`

Opens one file handle for streamed reads, attribute queries, and the java-gated raw path.

**Parameters**

- `path` `string`: 游戏目录相对路径

**Returns** [FileHandle](../../classes/filehandle)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `readBytes(path: string)`

Reads one file as raw bytes (each element 0-255; the engine renders the result as a Uint8Array).

**Parameters**

- `path` `string`: 

**Returns** `Promise<Uint8Array>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `readJSON(path: string)`

Reads a JSON file into neutral values (objects, arrays, strings, numbers, booleans).

**Parameters**

- `path` `string`: 

**Returns** `Promise<any>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `readText(path: string)`

Reads a UTF-8 text file.

**Parameters**

- `path` `string`: path relative to the game directory

**Returns** `Promise<string>` — promise of the file content

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `stat(path: string)`

Returns file metadata: size, mtimeMs, isDir, isFile.

**Parameters**

- `path` `string`: 

**Returns** `Promise<object>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `toRelative(path: string)`

Returns the path relative to the game directory root; paths outside the root throw.

**Parameters**

- `path` `string`: 绝对或游戏目录相对路径

**Returns** `string`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `writeBytes(path: string, data: unknown)`

Writes raw bytes to a file (creating parent directories). The data argument is an array-like of byte values.

**Parameters**

- `path` `string`: 
- `data` `unknown`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `writeJSON(path: string, value: unknown)`

Writes neutral values into a JSON file (creating parent directories).

**Parameters**

- `path` `string`: 
- `value` `unknown`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `writeText(path: string, content: string)`

Writes a UTF-8 text file (creating parent directories).

**Parameters**

- `path` `string`: 
- `content` `string`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}


## Examples

Read and write JSON files under the game directory; every call is async and requires the fs capability.

```js
const { fs } = neo;

// Requires the fs capability; paths resolve against the game directory
const path = 'config/neomacros/my-macro.json';

if (await fs.exists(path)) {
  const config = await fs.readJSON(path); // neutral JSON values
  const info = await fs.stat(path); // { size, mtimeMs, isDir, isFile }
} else {
  await fs.writeJSON(path, { enabled: true, volume: 0.5 }); // parents created
}
```
