---
title: "fs"
description: "neo.fs：以游戏目录为根的文件系统访问。路径相对游戏目录解析；绝对路径与向上越界抛 SecurityException。全部函数异步返回 Promise，且需 fs 能力授权。"
---

:api-module-header{ category="系统" neo-name="neo.fs" since="0.1.0" mc="*" loader="*"}

**Classes**

[`FileHandle`](classes/FileHandle.html) · [`FileStat`](classes/FileStat.html)

## Methods

::api-method

### `copy`

复制文件；目标已存在时失败。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `from` | `string` |  | — | — |
| `to` | `string` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `delete`

删除文件或空目录。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `path` | `string` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `exists`

判断路径是否存在。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `path` | `string` |  | — | — |

**Returns** `Promise<boolean>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `list`

列出目录下一级的条目名（排序后返回）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `path` | `string` |  | — | — |

**Returns** `Promise<Array<string>>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `mkdir`

创建目录（含父目录）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `path` | `string` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `move`

移动文件或目录；目标已存在时失败。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `from` | `string` |  | — | — |
| `to` | `string` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `open`

打开一个文件句柄，用于流式读取、属性查询与 java 门控的原始路径。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `path` | `string` | 游戏目录相对路径 | — | — |

**Returns** :api-type{text='FileHandle' refs='FileHandle=classes/filehandle'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `readBytes`

按字节读取文件（元素 0-255，引擎侧渲染为 Uint8Array）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `path` | `string` |  | — | — |

**Returns** `Promise<Uint8Array>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `readJSON`

读取 JSON 文件为中性值（对象/数组/字符串/数字/布尔）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `path` | `string` |  | — | — |

**Returns** `Promise<JsonValue>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `readText`

读取 UTF-8 文本文件，Promise 以文件内容落定。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `path` | `string` | path relative to the game directory | — | — |

**Returns** `Promise<string>` — promise of the file content

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `stat`

返回文件元信息：size/mtimeMs/isDir/isFile。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `path` | `string` |  | — | — |

**Returns** :api-type{text='Promise<FileStat>' refs='FileStat=classes/filestat'}

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `toRelative`

返回相对游戏目录根的路径；越出根目录的路径抛错。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `path` | `string` | 绝对或游戏目录相对路径 | — | — |

**Returns** `string`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `writeBytes`

按字节写入文件（自动创建父目录），data 为字节值数组。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `path` | `string` |  | — | — |
| `data` | `Array<number> | string` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `writeJSON`

把中性值写入 JSON 文件（自动创建父目录）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `path` | `string` |  | — | — |
| `value` | `JsonValue` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

::api-method

### `writeText`

写入 UTF-8 文本文件（自动创建父目录）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `path` | `string` |  | — | — |
| `content` | `string` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

::

