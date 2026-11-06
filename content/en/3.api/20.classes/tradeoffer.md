---
title: "TradeOffer"
description: "One trade offer: its two costs, the result stack, and the use count."
---

Data · Wraps: `net.minecraft.world.item.trading.MerchantOffer`

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `baseCostA` | [ItemStack](itemstack) | The fixed first cost before price modifiers. (read-only) |
| `costA` | [ItemStack](itemstack) | The live first cost after demand and reputation adjustments. (read-only) |
| `costB` | [ItemStack](itemstack) | The optional second cost; undefined when absent. (read-only) |
| `demand` | `number` | The current demand bonus affecting the price. (read-only) |
| `maxUses` | `number` | How many trades this offer allows before locking. (read-only) |
| `result` | [ItemStack](itemstack) | The stack the trader sells. (read-only) |
| `uses` | `number` | How many times this offer has been traded. (read-only) |

