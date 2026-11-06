---
title: "FileHandle"
description: "Live handle over one file inside the game directory. Reads run on the IO executor; raw exposes the host path behind the java permission."
---

::api-declaration{ kind="handle" name="FileHandle"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `attributes` | `Record<string, unknown>` | The file attributes as {size, mtimeMs, isDir, isFile}. :api-badge{kind="readonly"} |
| `raw` | `unknown` | The raw host Path object. Requires the java permission. |

## Methods

### `readBytes()`

Reads the whole file as bytes.

**Returns** `Promise<Uint8Array>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `toString()`



**Returns** `string`

