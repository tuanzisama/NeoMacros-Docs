---
title: "render"
description: "neo.render 门面：基于原版 gizmo 管线的世界坐标图形绘制。图形跨帧保留，直到清空或模块卸载；坐标为世界坐标。"
---

Category: 界面 · Since: 0.1.0 · MC availability: * · Loader availability: * · Exposed as `neo.render` and `@neomacros/render`

## Methods

### `clearLayer(layerId: string)`

清空一个图层上的全部形状。

**Parameters**

- `layerId` `string`: 

Since: 0.1.0 · MC: * · Loader: *

### `drawBox(layerId: string, min: Pos3D, max: Pos3D, argbColor: number)`

在世界内绘制线框方块。

**Parameters**

- `layerId` `string`: layer identifier; shapes accumulate per layer until
- `min` [Pos3D](../../classes/pos3d): first corner (world coordinates)
- `max` [Pos3D](../../classes/pos3d): opposite corner (world coordinates)
- `argbColor` `number`: ARGB color (e.g. 0xFF00FF00 for opaque green)

Since: 0.1.0 · MC: * · Loader: *

### `drawLine(layerId: string, from: Pos3D, to: Pos3D, argbColor: number)`

在世界内绘制线段。

**Parameters**

- `layerId` `string`: 
- `from` [Pos3D](../../classes/pos3d): 
- `to` [Pos3D](../../classes/pos3d): 
- `argbColor` `number`: 

Since: 0.1.0 · MC: * · Loader: *

### `layerIds()`

列出当前持有形状的图层。

**Returns** `Array<string>`

Since: 0.1.0 · MC: * · Loader: *


## Examples

在世界坐标中用线框标记方块：图层上的形状跨帧保留，直到清除图层或模块卸载。

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
