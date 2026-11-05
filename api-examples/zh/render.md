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
