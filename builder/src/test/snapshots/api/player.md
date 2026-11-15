---
title: "player"
description: "The neo.player module: the local player, the open container (inventory), the open screen (screen), and the open dialog (dialog). self is a live handle reading current state through the player port; outside a world it reads back as undefined."
---

:api-module-header{ category="World" neo-name="neo.player" since="0.1.0" mc="*" loader="*"}

**Classes**

[`Abilities`](classes/Abilities.html) · [`Advancement`](classes/Advancement.html) · [`AdvancementProgress`](classes/AdvancementProgress.html) · [`Advancements`](classes/Advancements.html) · [`AnvilInventory`](classes/AnvilInventory.html) · [`BeaconInventory`](classes/BeaconInventory.html) · [`BookEditScreen`](classes/BookEditScreen.html) · [`BookViewScreen`](classes/BookViewScreen.html) · [`BrewingStandInventory`](classes/BrewingStandInventory.html) · [`CartographyInventory`](classes/CartographyInventory.html) · [`ChatScreen`](classes/ChatScreen.html) · [`CommandBlockScreen`](classes/CommandBlockScreen.html) · [`ConfirmScreen`](classes/ConfirmScreen.html) · [`ContainerInventory`](classes/ContainerInventory.html) · [`ContainerScreen`](classes/ContainerScreen.html) · [`CraftingInventory`](classes/CraftingInventory.html) · [`CreativeScreen`](classes/CreativeScreen.html) · [`DeathScreen`](classes/DeathScreen.html) · [`DialogAction`](classes/DialogAction.html) · [`DialogActionSpec`](classes/DialogActionSpec.html) · [`DialogConfig`](classes/DialogConfig.html) · [`DialogHandle`](classes/DialogHandle.html) · [`DialogInput`](classes/DialogInput.html) · [`DialogScreen`](classes/DialogScreen.html) · [`DisconnectedScreen`](classes/DisconnectedScreen.html) · [`EnchantInventory`](classes/EnchantInventory.html) · [`FurnaceInventory`](classes/FurnaceInventory.html) · [`GrindstoneInventory`](classes/GrindstoneInventory.html) · [`HorseInventory`](classes/HorseInventory.html) · [`Inventory`](classes/Inventory.html) · [`InventoryScreen`](classes/InventoryScreen.html) · [`JigsawScreen`](classes/JigsawScreen.html) · [`LocalPlayer`](classes/LocalPlayer.html) · [`PauseScreen`](classes/PauseScreen.html) · [`Player`](classes/Player.html) · [`PlayerInventory`](classes/PlayerInventory.html) · [`ProgressScreen`](classes/ProgressScreen.html) · [`Screen`](classes/Screen.html) · [`SignScreen`](classes/SignScreen.html) · [`SmithingInventory`](classes/SmithingInventory.html) · [`Statistics`](classes/Statistics.html) · [`StatisticsEntry`](classes/StatisticsEntry.html) · [`StonecutterInventory`](classes/StonecutterInventory.html) · [`StructureBlockScreen`](classes/StructureBlockScreen.html) · [`Target`](classes/Target.html) · [`TitleScreen`](classes/TitleScreen.html) · [`TradeOffer`](classes/TradeOffer.html) · [`VillagerInventory`](classes/VillagerInventory.html) · [`WinScreen`](classes/WinScreen.html) · [`XpInfo`](classes/XpInfo.html)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `dialog` | :api-type{text='DialogHandle' refs='DialogHandle=classes/dialoghandle'} | The currently open dialog as a DialogHandle, or undefined when no dialog screen is open. :api-badge{kind="readonly"} |
| `inventory` | :api-type{text='Inventory' refs='Inventory=classes/inventory'} | The currently open container as an Inventory handle, or the player's own inventory when no container screen is open (the same handle shape as player.self.inventory); undefined outside a world. :api-badge{kind="readonly"} |
| `screen` | :api-type{text='Screen' refs='Screen=classes/screen'} | The currently open screen as a Screen handle family member (ChatScreen, InventoryScreen, ContainerScreen, DialogScreen, ...; every screen without a dedicated class falls back to the base Screen), or undefined when no screen is open. :api-badge{kind="readonly"} |
| `self` | :api-type{text='LocalPlayer' refs='LocalPlayer=classes/localplayer'} | The local player handle, or undefined when not in a world. :api-badge{kind="readonly"} |

## Methods

::api-method

### `showDialog`

Opens a client-side dialog from a plain config map and resolves with the chosen action id once player.dialog.clickAction runs; Esc or a manual button click resolves with null when the dialog closes. Config keys: type (notice, confirmation, multi_action), title, body (string or string array), canCloseWithEscape, actions (array of {label}).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `config` | :api-type{text='DialogConfig' refs='DialogConfig=classes/dialogconfig'} |  | — | — |

**Returns** `Promise<string>`

:api-badges{ since="0.3.0" mc=">=1.21.6" loader="*"}

::

