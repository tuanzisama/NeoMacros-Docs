---
title: "player"
description: "The neo.player facade: the local player plus the currently open container screen. self is a live handle reading current state through the player port; outside a world it reads back as undefined."
---

:api-module-header{ category="World" global="true" neo-name="neo.player" esm-name="@neomacros/player" since="0.1.0" mc="*" loader="*"}

**Classes**

[`Abilities`](../../classes/abilities) · [`AnvilInventory`](../../classes/anvilinventory) · [`BeaconInventory`](../../classes/beaconinventory) · [`BrewingStandInventory`](../../classes/brewingstandinventory) · [`CartographyInventory`](../../classes/cartographyinventory) · [`ContainerInventory`](../../classes/containerinventory) · [`CraftingInventory`](../../classes/craftinginventory) · [`EnchantInventory`](../../classes/enchantinventory) · [`FurnaceInventory`](../../classes/furnaceinventory) · [`GrindstoneInventory`](../../classes/grindstoneinventory) · [`HorseInventory`](../../classes/horseinventory) · [`Inventory`](../../classes/inventory) · [`LocalPlayer`](../../classes/localplayer) · [`Player`](../../classes/player) · [`PlayerInventory`](../../classes/playerinventory) · [`SmithingInventory`](../../classes/smithinginventory) · [`StonecutterInventory`](../../classes/stonecutterinventory) · [`TradeOffer`](../../classes/tradeoffer) · [`VillagerInventory`](../../classes/villagerinventory)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `opened` | [Inventory](../../classes/inventory) | The currently open container screen as an Inventory handle, or undefined when no container screen is open. :api-badge{kind="readonly"} |
| `self` | [LocalPlayer](../../classes/localplayer) | The local player handle, or undefined when not in a world. :api-badge{kind="readonly"} |


## Examples

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
