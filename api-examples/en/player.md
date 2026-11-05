Read current vitals off the live local-player handle and inspect the container screen the player has open.

```js
const { player } = neo;

// self is a live handle; it reads as undefined outside a world
if (player.self) {
  const { health, hunger, gamemode } = player.self; // current vitals
}

// The container screen currently open, if any
if (player.opened) {
  const pearls = player.opened.countOf('ender_pearl'); // namespace optional
  if (pearls > 0) player.opened.close(); // close it from the script
}
```
