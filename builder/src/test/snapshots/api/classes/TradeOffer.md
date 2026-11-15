---
title: "TradeOffer"
description: "One trade offer: its two costs, the result stack, and the use count."
---

::api-declaration{ kind="data" name="TradeOffer" wraps="net.minecraft.world.item.trading.MerchantOffer"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `baseCostA` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The fixed first cost before price modifiers. :api-badge{kind="readonly"} |
| `costA` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The live first cost after demand and reputation adjustments. :api-badge{kind="readonly"} |
| `costB` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The optional second cost; undefined when absent. :api-badge{kind="readonly"} |
| `demand` | `number` | The current demand bonus affecting the price. :api-badge{kind="readonly"} |
| `maxUses` | `number` | How many trades this offer allows before locking. :api-badge{kind="readonly"} |
| `result` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The stack the trader sells. :api-badge{kind="readonly"} |
| `uses` | `number` | How many times this offer has been traded. :api-badge{kind="readonly"} |

