---
title: "render"
description: "The neo.render facade: world-space shape drawing on top of the vanilla gizmo pipeline. Shapes persist across frames until cleared or the module unloads; coordinates are world coordinates."
---

:api-module-header{ category="UI" global="true" neo-name="neo.render" esm-name="@neomacros/render" since="0.1.0" mc="*" loader="*"}

## Methods

### `clearLayer(layerId: string)`

Removes all shapes on one layer.

**Parameters**

- `layerId` `string`: 

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `drawBox(layerId: string, min: Pos3D, max: Pos3D, argbColor: number)`

Draws a wireframe box between two world positions on one layer.

**Parameters**

- `layerId` `string`: layer identifier; shapes accumulate per layer until
- `min` [Pos3D](../../classes/pos3d): first corner (world coordinates)
- `max` [Pos3D](../../classes/pos3d): opposite corner (world coordinates)
- `argbColor` `number`: ARGB color (e.g. 0xFF00FF00 for opaque green)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `drawLine(layerId: string, from: Pos3D, to: Pos3D, argbColor: number)`

Draws a line between two world positions on one layer.

**Parameters**

- `layerId` `string`: 
- `from` [Pos3D](../../classes/pos3d): 
- `to` [Pos3D](../../classes/pos3d): 
- `argbColor` `number`: 

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `layerIds()`

Lists all layers that currently hold shapes.

**Returns** `Array<string>`

:api-badges{ since="0.1.0" mc="*" loader="*"}


## Examples

Outline a block in world coordinates; shapes persist on their layer until cleared or the module unloads.

```js
const { render, world } = neo;

// Outline a block with a wireframe box on its own layer
const base = world.blockAt(128, 64, -212).pos; // BlockPos extends Pos3D
const top = base.up().east().south(); // opposite corner

render.drawBox('marker', base, top, 0xFF00FFAA); // ARGB color

// Shapes persist across frames until the layer is cleared
render.drawLine('marker', base, base.up(8), 0xFF00FFAA);
render.clearLayer('marker');
```
