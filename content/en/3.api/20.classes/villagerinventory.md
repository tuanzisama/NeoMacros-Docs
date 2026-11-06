---
title: "VillagerInventory"
description: "A villager trade screen: trader level and experience progress. Trade offers ride the trade-offer data batch."
---

::api-declaration{ kind="handle" name="VillagerInventory" wraps="net.minecraft.world.inventory.MerchantMenu"}
#extends
[`Inventory`](inventory)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `futureTraderXp` | `number` | The experience needed for the next trade level. :api-badge{kind="readonly"} |
| `traderLevel` | `number` | The trader's current trade level (1-5). :api-badge{kind="readonly"} |
| `traderXp` | `number` | The trader's accumulated experience. :api-badge{kind="readonly"} |
| `trades` | `Array<`[TradeOffer](tradeoffer)`>` | The trade offers currently shown. :api-badge{kind="readonly"} |

