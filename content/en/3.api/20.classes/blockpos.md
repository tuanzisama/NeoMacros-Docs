---
title: "BlockPos"
description: "Immutable block-grid position: an integer with directional offsets. new BlockPos(10.7, 64.2, 200.9) floors onto the grid."
---

::api-declaration{ kind="data" name="BlockPos"}
#extends
[`Pos3D`](pos3d)
::

## Methods

### `center()`

The center of the block as a world-coordinate point.

**Returns** [Pos3D](pos3d)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `construct(args: unknown)`



**Parameters**

- `args` `unknown`: 

**Returns** `unknown`

:api-badges{ since="0.2.0"}

### `down()`

One block down.

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `down(n: number)`

n blocks down.

**Parameters**

- `n` `number`: 

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `east()`

One block east (positive X).

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `east(n: number)`

n blocks east (positive X).

**Parameters**

- `n` `number`: 

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `north()`

One block north (negative Z).

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `north(n: number)`

n blocks north (negative Z).

**Parameters**

- `n` `number`: 

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `offset(direction: string, n: number)`

Offsets by n steps along one of the six cardinal directions.

**Parameters**

- `direction` `string`: 
- `n` `number`: 

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `south()`

One block south (positive Z).

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `south(n: number)`

n blocks south (positive Z).

**Parameters**

- `n` `number`: 

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `toString()`



**Returns** `string`

:api-badges{ since="0.2.0"}

### `up()`

One block up.

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `up(n: number)`

n blocks up.

**Parameters**

- `n` `number`: 

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `west()`

One block west (negative X).

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `west(n: number)`

n blocks west (negative X).

**Parameters**

- `n` `number`: 

**Returns** [BlockPos](blockpos)

:api-badges{ since="0.2.0" mc="*" loader="*"}

