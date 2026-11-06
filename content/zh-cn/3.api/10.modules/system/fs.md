---
title: "fs"
description: "neo.fs 门面：以游戏目录为根的文件系统访问。路径相对游戏目录解析；绝对路径与向上越界抛 SecurityException。全部函数异步返回 Promise，且需 fs 能力授权。"
---

:api-module-header{ category="系统" global="true" neo-name="neo.fs" esm-name="@neomacros/fs" since="0.1.0" mc="*" loader="*"}

**Classes**

[`FileHandle`](../../classes/filehandle)

## Methods

### `copy(from: string, to: string)`

复制文件；目标已存在时失败。

**Parameters**

- `from` `string`: 
- `to` `string`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `delete(path: string)`

删除文件或空目录。

**Parameters**

- `path` `string`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `exists(path: string)`

判断路径是否存在。

**Parameters**

- `path` `string`: 

**Returns** `Promise<boolean>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `list(path: string)`

列出目录下一级的条目名（排序后返回）。

**Parameters**

- `path` `string`: 

**Returns** `Promise<Array<string>>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `mkdir(path: string)`

创建目录（含父目录）。

**Parameters**

- `path` `string`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `move(from: string, to: string)`

移动文件或目录；目标已存在时失败。

**Parameters**

- `from` `string`: 
- `to` `string`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `open(path: string)`

打开一个文件句柄，用于流式读取、属性查询与 java 门控的原始路径。

**Parameters**

- `path` `string`: 游戏目录相对路径

**Returns** [FileHandle](../../classes/filehandle)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `readBytes(path: string)`

按字节读取文件（元素 0-255，引擎侧渲染为 Uint8Array）。

**Parameters**

- `path` `string`: 

**Returns** `Promise<Uint8Array>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `readJSON(path: string)`

读取 JSON 文件为中性值（对象/数组/字符串/数字/布尔）。

**Parameters**

- `path` `string`: 

**Returns** `Promise<any>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `readText(path: string)`

读取 UTF-8 文本文件，Promise 以文件内容落定。

**Parameters**

- `path` `string`: path relative to the game directory

**Returns** `Promise<string>` — promise of the file content

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `stat(path: string)`

返回文件元信息：size/mtimeMs/isDir/isFile。

**Parameters**

- `path` `string`: 

**Returns** `Promise<object>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `toRelative(path: string)`

返回相对游戏目录根的路径；越出根目录的路径抛错。

**Parameters**

- `path` `string`: 绝对或游戏目录相对路径

**Returns** `string`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `writeBytes(path: string, data: unknown)`

按字节写入文件（自动创建父目录），data 为字节值数组。

**Parameters**

- `path` `string`: 
- `data` `unknown`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `writeJSON(path: string, value: unknown)`

把中性值写入 JSON 文件（自动创建父目录）。

**Parameters**

- `path` `string`: 
- `value` `unknown`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}

### `writeText(path: string, content: string)`

写入 UTF-8 文本文件（自动创建父目录）。

**Parameters**

- `path` `string`: 
- `content` `string`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="fs"}


## Examples

读写游戏目录下的 JSON 文件：全部调用为异步，且需要 fs 能力（经 /neomacros trust 授予）。

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
