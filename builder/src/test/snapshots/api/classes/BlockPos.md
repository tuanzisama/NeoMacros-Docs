---
title: "BlockPos"
description: "Immutable block-grid position: an integer with directional offsets. new BlockPos(10.7, 64.2, 200.9) floors onto the grid."
---

::api-declaration{ kind="data" name="BlockPos" ctor="new BlockPos(x: number, y: number, z: number)"}
#extends
[`Pos3D`](Pos3D.html)
::

## Methods

::api-method

### `center`

The center of the block as a world-coordinate point.

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `down`

One block down.

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `down`

n blocks down.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `n` | `number` |  | — | — |

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `east`

One block east (positive X).

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `east`

n blocks east (positive X).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `n` | `number` |  | — | — |

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `north`

One block north (negative Z).

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `north`

n blocks north (negative Z).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `n` | `number` |  | — | — |

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `offset`

Offsets by n steps along one of the six cardinal directions.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `direction` | `string` |  | — | — |
| `n` | `number` |  | — | — |

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `south`

One block south (positive Z).

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `south`

n blocks south (positive Z).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `n` | `number` |  | — | — |

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `up`

One block up.

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `up`

n blocks up.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `n` | `number` |  | — | — |

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `west`

One block west (negative X).

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `west`

n blocks west (negative X).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `n` | `number` |  | — | — |

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

