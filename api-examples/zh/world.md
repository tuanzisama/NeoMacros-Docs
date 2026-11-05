在两个世界坐标点之间做射线检测，并读取已加载世界的快照信息（生物群系、天气等）。

```js
const { world } = neo;

// Cast a ray straight down between two world points
const hit = world.raycast(128, 320, -212, 128, -64, -212);
if (hit && hit.hit) {
  // hit.pos is the exact impact point; block/entity are mutually exclusive
  const blockId = hit.block?.state?.id; // e.g. 'minecraft:grass_block'
}

// Point-in-time lookups and world facts
const biome = world.biomeAt(128, 64, -212);
const raining = world.raining;
```
