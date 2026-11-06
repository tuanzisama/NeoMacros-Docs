---
title: "storage"
description: "neo.storage 门面：按脚本隔离的持久键值存储。值必须是可 JSON 序列化的纯数据（对象/数组/字符串/数字/布尔）；每个脚本按源文件名拥有独立存储，跨重载与游戏重启保留。"
---

:api-module-header{ category="核心" global="true" neo-name="neo.storage" esm-name="@neomacros/storage" since="0.1.0" mc="*" loader="*"}

## Methods

### `get(key: string)`

读取一个值；不存在时返回 null。

**Parameters**

- `key` `string`: 

**Returns** `unknown`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `has(key: string)`

判断键是否存在。

**Parameters**

- `key` `string`: 

**Returns** `boolean`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `put(key: string, value: unknown)`

写入一个值；传 null 等同删除该键。

**Parameters**

- `key` `string`: 
- `value` `unknown`: 

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `remove(key: string)`

删除一个键。

**Parameters**

- `key` `string`: 

:api-badges{ since="0.1.0" mc="*" loader="*"}


## Examples

跨重载持久化脚本状态：读取、写入、检查与删除键值，值须为可 JSON 序列化的纯数据。

```js
const { storage } = neo;

// Values must be JSON-serializable; the store survives reloads and restarts
let stats = storage.get('stats') ?? { kills: 0, deaths: 0 };

stats.kills += 1;
storage.put('stats', stats);

if (storage.has('obsolete')) {
  storage.remove('obsolete'); // drop keys the new version no longer uses
}
```
