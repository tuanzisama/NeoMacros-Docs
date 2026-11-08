Read current vitals off the live local-player handle, inspect the container screen the player has open, and work with statistics, advancements, and the crosshair target.

```js
const { player } = neo;

// self is a live handle; it reads as undefined outside a world
if (player.self) {
  const { health, hunger, gamemode } = player.self; // current vitals
}

// The container screen currently open, if any
if (player.inventory) {
  const pearls = player.inventory.countOf('ender_pearl'); // namespace optional
  if (pearls > 0) player.inventory.close(); // close it from the script
}

// Statistics: typed per-category queries over the live counters
const stats = player.self?.statistics;
if (stats) {
  const mined = stats.mined('stone');            // namespace optional
  const walked = stats.custom('walk_one_cm');    // custom stat
  const deaths = stats.value('minecraft:custom', 'minecraft:deaths');
}

// Advancements: tree queries plus per-advancement progress
const adv = player.self?.advancements;
if (adv) {
  const done = adv.completed.length;             // fully completed ids
  const root = adv.get('minecraft:story/root');
  if (root) {
    const { title, frame } = root;               // display data
    const { done: finished, remaining } = root.progress ?? {};
  }
}

// The crosshair pick: what the player is aiming at, within reach
const aim = player.self?.target;
if (aim?.hit) {
  if (aim.block) await player.self.interactBlock(aim.block.pos);
  else if (aim.entity) await player.self.interactEntity(aim.entity);
}
```
