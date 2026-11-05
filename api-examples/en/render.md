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
