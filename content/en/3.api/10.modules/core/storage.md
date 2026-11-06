---
title: "storage"
description: "The neo.storage facade: persistent per-script key-value storage. Values must be JSON-serializable plain data (objects, arrays, strings, numbers, booleans); each script owns an isolated store keyed by its source file name, surviving reloads and game restarts."
---

:api-module-header{ category="Core" global="true" neo-name="neo.storage" esm-name="@neomacros/storage" since="0.1.0" mc="*" loader="*"}

## Methods

### `get(key: string)`

Reads one value, or null when absent.

**Parameters**

- `key` `string`: 

**Returns** `unknown`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `has(key: string)`

Returns whether the key exists.

**Parameters**

- `key` `string`: 

**Returns** `boolean`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `put(key: string, value: unknown)`

Writes one value (JSON-serializable plain data); null deletes the key.

**Parameters**

- `key` `string`: 
- `value` `unknown`: 

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `remove(key: string)`

Removes one key.

**Parameters**

- `key` `string`: 

:api-badges{ since="0.1.0" mc="*" loader="*"}


## Examples

Persist script state across reloads: read, write, check and remove keys whose values are JSON-serializable.

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
