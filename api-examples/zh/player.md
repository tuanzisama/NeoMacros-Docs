self 是本地玩家的活句柄（离开世界时读取为 undefined），opened 是当前打开的容器界面。

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
```
