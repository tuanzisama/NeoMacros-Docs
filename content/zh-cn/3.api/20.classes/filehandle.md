---
title: "FileHandle"
description: "游戏目录内单个文件的活句柄。读取在 IO 线程池执行；raw 在 java 权限后暴露宿主路径。"
---

::api-declaration{ kind="handle" name="FileHandle"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `attributes` | `Record<string, unknown>` | 文件属性 {size, mtimeMs, isDir, isFile}。 :api-badge{kind="readonly"} |
| `raw` | `unknown` | 原始宿主 Path 对象。需 java 权限。 |

## Methods

### `readBytes()`

读取整个文件为字节。

**Returns** `Promise<Uint8Array>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `toString()`



**Returns** `string`

