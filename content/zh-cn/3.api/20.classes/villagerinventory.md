---
title: "VillagerInventory"
description: "村民交易界面：交易等级与经验进度。交易报价随交易数据批落地。"
---

::api-declaration{ kind="handle" name="VillagerInventory" wraps="net.minecraft.world.inventory.MerchantMenu"}
#extends
[`Inventory`](inventory)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `futureTraderXp` | `number` | 升到下一交易等级所需经验。 :api-badge{kind="readonly"} |
| `traderLevel` | `number` | 交易等级（1-5）。 :api-badge{kind="readonly"} |
| `traderXp` | `number` | 交易者累计经验。 :api-badge{kind="readonly"} |
| `trades` | `Array<`[TradeOffer](tradeoffer)`>` | 当前显示的交易报价。 :api-badge{kind="readonly"} |

