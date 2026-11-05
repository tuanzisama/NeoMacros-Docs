Find the nearest entity, resolve it again by UUID, and list every loaded player — all as live handles.

```js
const { entity } = neo;

// Nearest entity within 16 blocks of a point (undefined when none)
const mob = entity.nearest(128, 64, -212, 16);
if (mob) {
  // Live handle: pos, name and type re-read the world on every access
  const uuid = mob.uuid; // persist the uuid, find it again later
  const same = entity.lookup(uuid); // undefined once the entity is gone
}

// All loaded players, as live handles
const names = entity.players().map((p) => p.name);
```
