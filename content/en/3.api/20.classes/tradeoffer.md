---
title: "TradeOffer"
description: "One trade offer: its two costs, the result stack, and the use count."
---

::api-declaration{ kind="data" name="TradeOffer" wraps="net.minecraft.world.item.trading.MerchantOffer"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `baseCostA` | [ItemStack](itemstack) | The fixed first cost before price modifiers. :api-badge{kind="readonly"} |
| `costA` | [ItemStack](itemstack) | The live first cost after demand and reputation adjustments. :api-badge{kind="readonly"} |
| `costB` | [ItemStack](itemstack) | The optional second cost; undefined when absent. :api-badge{kind="readonly"} |
| `demand` | `number` | The current demand bonus affecting the price. :api-badge{kind="readonly"} |
| `maxUses` | `number` | How many trades this offer allows before locking. :api-badge{kind="readonly"} |
| `result` | [ItemStack](itemstack) | The stack the trader sells. :api-badge{kind="readonly"} |
| `uses` | `number` | How many times this offer has been traded. :api-badge{kind="readonly"} |

