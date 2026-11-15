---
title: "Pos2D"
description: "Immutable two-dimensional point: rotations (yaw, pitch) and screen coordinates. Every operation returns a new instance."
---

::api-declaration{ kind="data" name="Pos2D" ctor="new Pos2D(x: number, y: number)"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `x` | `number` | The X coordinate. |
| `y` | `number` | The Y coordinate. |

## Methods

::api-method

### `add`

Adds another point.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos2D' refs='Pos2D=classes/pos2d'} |  | — | — |

**Returns** :api-type{text='Pos2D' refs='Pos2D=classes/pos2d'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `compare`

Component-wise lexicographic compare (x first, then y).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos2D' refs='Pos2D=classes/pos2d'} |  | — | — |

**Returns** `number`

:api-badges{ since="0.2.0"}

::

::api-method

### `mul`

Multiplies component-wise by another point.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos2D' refs='Pos2D=classes/pos2d'} |  | — | — |

**Returns** :api-type{text='Pos2D' refs='Pos2D=classes/pos2d'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `scale`

Scales by a factor.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `factor` | `number` |  | — | — |

**Returns** :api-type{text='Pos2D' refs='Pos2D=classes/pos2d'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `sub`

Subtracts another point.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos2D' refs='Pos2D=classes/pos2d'} |  | — | — |

**Returns** :api-type{text='Pos2D' refs='Pos2D=classes/pos2d'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `toJSON`

JSON form so JSON.stringify renders the point directly.

**Returns** `string`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

