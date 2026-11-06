---
title: "TradeOffer"
description: "一条交易报价：两项成本、结果物品堆与使用计数。"
---

::api-declaration{ kind="data" name="TradeOffer" wraps="net.minecraft.world.item.trading.MerchantOffer"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `baseCostA` | [ItemStack](itemstack) | 价格修饰前的固定第一成本。 :api-badge{kind="readonly"} |
| `costA` | [ItemStack](itemstack) | 经需求与声望调整后的实时第一成本。 :api-badge{kind="readonly"} |
| `costB` | [ItemStack](itemstack) | 可选第二成本；缺省为 undefined。 :api-badge{kind="readonly"} |
| `demand` | `number` | 影响价格的当前需求加成。 :api-badge{kind="readonly"} |
| `maxUses` | `number` | 该报价锁定前允许的交易次数。 :api-badge{kind="readonly"} |
| `result` | [ItemStack](itemstack) | 交易者售出的物品堆。 :api-badge{kind="readonly"} |
| `uses` | `number` | 该报价已被交易的次数。 :api-badge{kind="readonly"} |

