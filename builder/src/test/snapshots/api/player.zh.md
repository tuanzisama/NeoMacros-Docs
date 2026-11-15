---
title: "player"
description: "neo.player：本地玩家、打开的容器（inventory）、当前屏幕（screen）与当前对话框（dialog）。self 是经玩家端口回读当前状态的活句柄；不在世界内时回读为 undefined。"
---

:api-module-header{ category="世界" neo-name="neo.player" since="0.1.0" mc="*" loader="*"}

**Classes**

[`Abilities`](classes/Abilities.html) · [`Advancement`](classes/Advancement.html) · [`AdvancementProgress`](classes/AdvancementProgress.html) · [`Advancements`](classes/Advancements.html) · [`AnvilInventory`](classes/AnvilInventory.html) · [`BeaconInventory`](classes/BeaconInventory.html) · [`BookEditScreen`](classes/BookEditScreen.html) · [`BookViewScreen`](classes/BookViewScreen.html) · [`BrewingStandInventory`](classes/BrewingStandInventory.html) · [`CartographyInventory`](classes/CartographyInventory.html) · [`ChatScreen`](classes/ChatScreen.html) · [`CommandBlockScreen`](classes/CommandBlockScreen.html) · [`ConfirmScreen`](classes/ConfirmScreen.html) · [`ContainerInventory`](classes/ContainerInventory.html) · [`ContainerScreen`](classes/ContainerScreen.html) · [`CraftingInventory`](classes/CraftingInventory.html) · [`CreativeScreen`](classes/CreativeScreen.html) · [`DeathScreen`](classes/DeathScreen.html) · [`DialogAction`](classes/DialogAction.html) · [`DialogActionSpec`](classes/DialogActionSpec.html) · [`DialogConfig`](classes/DialogConfig.html) · [`DialogHandle`](classes/DialogHandle.html) · [`DialogInput`](classes/DialogInput.html) · [`DialogScreen`](classes/DialogScreen.html) · [`DisconnectedScreen`](classes/DisconnectedScreen.html) · [`EnchantInventory`](classes/EnchantInventory.html) · [`FurnaceInventory`](classes/FurnaceInventory.html) · [`GrindstoneInventory`](classes/GrindstoneInventory.html) · [`HorseInventory`](classes/HorseInventory.html) · [`Inventory`](classes/Inventory.html) · [`InventoryScreen`](classes/InventoryScreen.html) · [`JigsawScreen`](classes/JigsawScreen.html) · [`LocalPlayer`](classes/LocalPlayer.html) · [`PauseScreen`](classes/PauseScreen.html) · [`Player`](classes/Player.html) · [`PlayerInventory`](classes/PlayerInventory.html) · [`ProgressScreen`](classes/ProgressScreen.html) · [`Screen`](classes/Screen.html) · [`SignScreen`](classes/SignScreen.html) · [`SmithingInventory`](classes/SmithingInventory.html) · [`Statistics`](classes/Statistics.html) · [`StatisticsEntry`](classes/StatisticsEntry.html) · [`StonecutterInventory`](classes/StonecutterInventory.html) · [`StructureBlockScreen`](classes/StructureBlockScreen.html) · [`Target`](classes/Target.html) · [`TitleScreen`](classes/TitleScreen.html) · [`TradeOffer`](classes/TradeOffer.html) · [`VillagerInventory`](classes/VillagerInventory.html) · [`WinScreen`](classes/WinScreen.html) · [`XpInfo`](classes/XpInfo.html)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `dialog` | :api-type{text='DialogHandle' refs='DialogHandle=classes/dialoghandle'} | 当前打开的对话框句柄；无对话框屏幕时为 undefined。 :api-badge{kind="readonly"} |
| `inventory` | :api-type{text='Inventory' refs='Inventory=classes/inventory'} | 当前打开的容器句柄；未开容器屏幕时回退为玩家自己的背包（与 player.self.inventory 同形句柄）；不在世界内为 undefined。 :api-badge{kind="readonly"} |
| `screen` | :api-type{text='Screen' refs='Screen=classes/screen'} | 当前打开的屏幕句柄族成员（ChatScreen、InventoryScreen、ContainerScreen、DialogScreen 等；无专属类的屏幕回落基类 Screen）；无屏幕时为 undefined。 :api-badge{kind="readonly"} |
| `self` | :api-type{text='LocalPlayer' refs='LocalPlayer=classes/localplayer'} | 本地玩家句柄；不在世界内时为 undefined。 :api-badge{kind="readonly"} |

## Methods

::api-method

### `showDialog`

从普通配置对象打开一个客户端对话框，脚本调用 player.dialog.clickAction 后以所选动作 id 落定；按 Esc 或手动点击按钮关闭时以 null 落定。配置键：type（notice/confirmation/multi_action）、title、body（字符串或字符串数组）、canCloseWithEscape、actions（{label} 数组）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `config` | :api-type{text='DialogConfig' refs='DialogConfig=classes/dialogconfig'} |  | — | — |

**Returns** `Promise<string>`

:api-badges{ since="0.3.0" mc=">=1.21.6" loader="*"}

::

