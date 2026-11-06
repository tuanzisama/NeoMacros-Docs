---
title: "player"
description: "neo.player 门面：本地玩家与当前打开的容器屏幕。self 是经玩家端口回读当前状态的活句柄；不在世界内时回读为 undefined。"
---

Category: 世界 · Since: 0.1.0 · MC availability: * · Loader availability: * · Exposed as `neo.player` and `@neomacros/player`

**Classes**

[`Abilities`](../../classes/abilities) · [`AnvilInventory`](../../classes/anvilinventory) · [`BeaconInventory`](../../classes/beaconinventory) · [`BrewingStandInventory`](../../classes/brewingstandinventory) · [`CartographyInventory`](../../classes/cartographyinventory) · [`ContainerInventory`](../../classes/containerinventory) · [`CraftingInventory`](../../classes/craftinginventory) · [`EnchantInventory`](../../classes/enchantinventory) · [`FurnaceInventory`](../../classes/furnaceinventory) · [`GrindstoneInventory`](../../classes/grindstoneinventory) · [`HorseInventory`](../../classes/horseinventory) · [`Inventory`](../../classes/inventory) · [`LocalPlayer`](../../classes/localplayer) · [`Player`](../../classes/player) · [`PlayerInventory`](../../classes/playerinventory) · [`SmithingInventory`](../../classes/smithinginventory) · [`StonecutterInventory`](../../classes/stonecutterinventory) · [`TradeOffer`](../../classes/tradeoffer) · [`VillagerInventory`](../../classes/villagerinventory)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `opened` | [Inventory](../../classes/inventory) | 当前打开的容器屏幕句柄；无屏幕时为 undefined。 (read-only) |
| `self` | [LocalPlayer](../../classes/localplayer) | 本地玩家句柄；不在世界内时为 undefined。 (read-only) |


## Examples

self 是本地玩家的活句柄（离开世界时读取为 undefined），opened 是当前打开的容器界面。

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
