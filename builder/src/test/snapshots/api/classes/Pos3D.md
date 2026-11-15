---
title: "Pos3D"
description: "Immutable three-dimensional point and direction: every operation returns a new instance. The script-facing workhorse for positions, directions, and offsets; JSON.stringify renders it as {\"x\":…,\"y\":…,\"z\":…}."
---

::api-declaration{ kind="data" name="Pos3D" ctor="new Pos3D(x: number, y: number, z: number)"}
#extended-by
[`BlockPos`](BlockPos.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `x` | `number` | The X coordinate. |
| `y` | `number` | The Y coordinate. |
| `z` | `number` | The Z coordinate. |

## Methods

::api-method

### `add`

Adds another point or vector.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `cross`

The cross product.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `distanceSq`

The squared distance to another point.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |

**Returns** `number`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `distanceTo`

The distance to another point.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |

**Returns** `number`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `div`

Divides component-wise by another vector.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `dot`

The dot product.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |

**Returns** `number`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `floor`

Floors the coordinates onto the block grid.

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `length`

The vector length.

**Returns** `number`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `lengthSq`

The squared vector length.

**Returns** `number`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `lerp`

Linear interpolation toward another point by t (0..1).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |
| `t` | `number` |  | — | — |

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `mul`

Multiplies component-wise by another vector.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `normalize`

The unit vector of the same direction (zero vector stays zero).

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `scale`

Scales by a factor.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `factor` | `number` |  | — | — |

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `sub`

Subtracts another point or vector.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `toJSON`

JSON form so JSON.stringify renders the point directly.

**Returns** `string`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `withX`

Returns a copy with the X coordinate replaced.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `value` | `number` |  | — | — |

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `withY`

Returns a copy with the Y coordinate replaced.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `value` | `number` |  | — | — |

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `withZ`

Returns a copy with the Z coordinate replaced.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `value` | `number` |  | — | — |

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

