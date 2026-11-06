---
title: "VillagerInventory"
description: "村民交易界面：交易等级与经验进度。交易报价随交易数据批落地。"
---

Handle · Wraps: `net.minecraft.world.inventory.MerchantMenu` · Extends: [`Inventory`](inventory)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `futureTraderXp` | `number` | 升到下一交易等级所需经验。 (read-only) |
| `traderLevel` | `number` | 交易等级（1-5）。 (read-only) |
| `traderXp` | `number` | 交易者累计经验。 (read-only) |
| `trades` | `Array<`[TradeOffer](tradeoffer)`>` | 当前显示的交易报价。 (read-only) |

