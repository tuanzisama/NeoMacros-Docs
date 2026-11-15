---
title: "FileHandle"
description: "游戏目录内单个文件的活句柄。读取在 IO 线程池执行；raw 在 java 权限后暴露宿主路径。"
---

::api-declaration{ kind="handle" name="FileHandle"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `attributes` | :api-type{text='FileStat' refs='FileStat=classes/filestat'} | 文件属性 {size, mtimeMs, isDir, isFile}。 :api-badge{kind="readonly"} |
| `raw` | :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'} | 原始宿主 Path 对象。需 java 权限。 |

## Methods

::api-method

### `readBytes`

读取整个文件为字节。

**Returns** `Promise<Uint8Array>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

