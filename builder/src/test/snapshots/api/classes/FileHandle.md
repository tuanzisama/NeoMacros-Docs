---
title: "FileHandle"
description: "Live handle over one file inside the game directory. Reads run on the IO executor; raw exposes the host path behind the java permission."
---

::api-declaration{ kind="handle" name="FileHandle"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `attributes` | :api-type{text='FileStat' refs='FileStat=classes/filestat'} | The file attributes as {size, mtimeMs, isDir, isFile}. :api-badge{kind="readonly"} |
| `raw` | :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'} | The raw host Path object. Requires the java permission. |

## Methods

::api-method

### `readBytes`

Reads the whole file as bytes.

**Returns** `Promise<Uint8Array>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

