---
title: "Pos2D"
description: "Immutable two-dimensional point: rotations (yaw, pitch) and screen coordinates. Every operation returns a new instance."
---

::api-declaration{ kind="data" name="Pos2D"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `x` | `number` | The X coordinate. |
| `y` | `number` | The Y coordinate. |

## Methods

### `add(other: Pos2D)`

Adds another point.

**Parameters**

- `other` [Pos2D](pos2d): 

**Returns** [Pos2D](pos2d)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `compare(other: Pos2D)`

Component-wise lexicographic compare (x first, then y).

**Parameters**

- `other` [Pos2D](pos2d): 

**Returns** `number`

:api-badges{ since="0.2.0"}

### `construct(args: unknown)`



**Parameters**

- `args` `unknown`: 

**Returns** `unknown`

:api-badges{ since="0.2.0"}

### `equals(other: unknown)`



**Parameters**

- `other` `unknown`: 

**Returns** `boolean`

:api-badges{ since="0.2.0"}

### `hashCode()`



**Returns** `number`

:api-badges{ since="0.2.0"}

### `mul(other: Pos2D)`

Multiplies component-wise by another point.

**Parameters**

- `other` [Pos2D](pos2d): 

**Returns** [Pos2D](pos2d)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `scale(factor: number)`

Scales by a factor.

**Parameters**

- `factor` `number`: 

**Returns** [Pos2D](pos2d)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `sub(other: Pos2D)`

Subtracts another point.

**Parameters**

- `other` [Pos2D](pos2d): 

**Returns** [Pos2D](pos2d)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `toJSON()`

JSON form so JSON.stringify renders the point directly.

**Returns** `Record<string, unknown>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `toString()`



**Returns** `string`

:api-badges{ since="0.2.0"}

