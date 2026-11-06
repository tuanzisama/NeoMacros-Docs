---
title: "BlockPos"
description: "不可变的方块网格坐标：整数化的 ，带六个方向的偏移方法。new BlockPos(10.7, 64.2, 200.9) 会向下取整到网格。"
---

::api-declaration{ kind="data" name="BlockPos"}
#extends
[`Pos3D`](pos3d)
::

## Methods

### `center()`

方块中心的世界坐标点。

**Returns** [Pos3D](pos3d)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `construct(args: unknown)`



**Parameters**

- `args` `unknown`: 

**Returns** `unknown`

:api-badges{ since="0.2.0"}

### `down()`

下移一格。

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `down(n: number)`

下移 n 格。

**Parameters**

- `n` `number`: 

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `east()`

东移一格（X 加一）。

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `east(n: number)`

东移 n 格（X 加 n）。

**Parameters**

- `n` `number`: 

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `north()`

北移一格（Z 减一）。

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `north(n: number)`

北移 n 格（Z 减 n）。

**Parameters**

- `n` `number`: 

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `offset(direction: string, n: number)`

沿六个基本方向之一偏移 n 格。

**Parameters**

- `direction` `string`: 
- `n` `number`: 

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `south()`

南移一格（Z 加一）。

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `south(n: number)`

南移 n 格（Z 加 n）。

**Parameters**

- `n` `number`: 

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `toString()`



**Returns** `string`

:api-badges{ since="0.2.0"}

### `up()`

上移一格。

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `up(n: number)`

上移 n 格。

**Parameters**

- `n` `number`: 

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `west()`

西移一格（X 减一）。

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `west(n: number)`

西移 n 格（X 减 n）。

**Parameters**

- `n` `number`: 

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.2.0" mc="*" loader="*"}

