---
title: "render"
description: "The neo.render module: world-space shape drawing on top of the vanilla gizmo pipeline. Shapes persist across frames until cleared or the module unloads; coordinates are world coordinates."
---

:api-module-header{ category="UI" neo-name="neo.render" since="0.1.0" mc="*" loader="*"}

## Methods

::api-method

### `clearLayer`

Removes all shapes on one layer.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `layerId` | `string` |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `drawBox`

Draws a wireframe box between two world positions on one layer.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `layerId` | `string` | layer identifier; shapes accumulate per layer until | — | — |
| `min` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} | first corner (world coordinates) | — | — |
| `max` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} | opposite corner (world coordinates) | — | — |
| `argbColor` | `number` | ARGB color (e.g. 0xFF00FF00 for opaque green) | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `drawLine`

Draws a line between two world positions on one layer.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `layerId` | `string` |  | — | — |
| `from` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |
| `to` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |
| `argbColor` | `number` |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `layerIds`

Lists all layers that currently hold shapes.

**Returns** `Array<string>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `surface`

Draws a filled convex surface through three or more vertices (a fan from the first point on modern nodes; an outlined polygon on 1.x).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `layerId` | `string` |  | — | — |
| `points` | :api-type{text='Array<Pos3D>' refs='Pos3D=classes/pos3d'} |  | — | — |
| `argbColor` | `number` |  | — | — |

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `traceLine`

Draws a live line from the local player's eyes to the entity, kept aimed at it every frame while the entity stays loaded.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `layerId` | `string` |  | — | — |
| `target` | :api-type{text='Entity' refs='Entity=classes/entity'} |  | — | — |
| `argbColor` | `number` |  | — | — |

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

