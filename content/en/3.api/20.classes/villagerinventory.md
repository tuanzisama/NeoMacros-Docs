---
title: "VillagerInventory"
description: "A villager trade screen: trader level and experience progress. Trade offers ride the trade-offer data batch."
---

Handle · Wraps: `net.minecraft.world.inventory.MerchantMenu` · Extends: [`Inventory`](inventory)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `futureTraderXp` | `number` | The experience needed for the next trade level. (read-only) |
| `traderLevel` | `number` | The trader's current trade level (1-5). (read-only) |
| `traderXp` | `number` | The trader's accumulated experience. (read-only) |
| `trades` | `Array<`[TradeOffer](tradeoffer)`>` | The trade offers currently shown. (read-only) |

