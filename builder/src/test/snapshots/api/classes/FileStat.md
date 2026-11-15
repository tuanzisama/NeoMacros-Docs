---
title: "FileStat"
description: "One file's metadata snapshot: byte size, last-modified epoch millis, and directory / regular-file flags."
---

::api-declaration{ kind="data" name="FileStat"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `isDir` | `boolean` |  :api-badge{kind="readonly"} |
| `isFile` | `boolean` |  :api-badge{kind="readonly"} |
| `mtimeMs` | `number` |  :api-badge{kind="readonly"} |
| `size` | `number` |  :api-badge{kind="readonly"} |

