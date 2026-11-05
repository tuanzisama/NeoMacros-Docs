Cast a ray between two world points and read snapshot facts about the loaded world.

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
