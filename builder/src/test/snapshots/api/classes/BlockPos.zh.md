---
title: "BlockPos"
description: "不可变的方块网格坐标：整数化的 ，带六个方向的偏移方法。new BlockPos(10.7, 64.2, 200.9) 会向下取整到网格。"
---

::api-declaration{ kind="data" name="BlockPos" ctor="new BlockPos(x: number, y: number, z: number)"}
#extends
[`Pos3D`](Pos3D.html)
::

## Methods

::api-method

### `center`

方块中心的世界坐标点。

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `down`

下移一格。

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `down`

下移 n 格。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `n` | `number` |  | — | — |

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `east`

东移一格（X 加一）。

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `east`

东移 n 格（X 加 n）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `n` | `number` |  | — | — |

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `north`

北移一格（Z 减一）。

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `north`

北移 n 格（Z 减 n）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `n` | `number` |  | — | — |

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `offset`

沿六个基本方向之一偏移 n 格。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `direction` | `string` |  | — | — |
| `n` | `number` |  | — | — |

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `south`

南移一格（Z 加一）。

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `south`

南移 n 格（Z 加 n）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `n` | `number` |  | — | — |

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `up`

上移一格。

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `up`

上移 n 格。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `n` | `number` |  | — | — |

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `west`

西移一格（X 减一）。

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `west`

西移 n 格（X 减 n）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `n` | `number` |  | — | — |

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

**Example**

```js
const base = new BlockPos(10, 64, 200);
const above = base.up(2); // (10, 66, 200)
```

