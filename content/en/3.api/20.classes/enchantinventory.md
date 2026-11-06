---
title: "EnchantInventory"
description: "An enchanting table screen: the item, lapis, and the three cost rows."
---

::api-declaration{ kind="handle" name="EnchantInventory" wraps="net.minecraft.world.inventory.EnchantmentMenu"}
#extends
[`Inventory`](inventory)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `costs` | `unknown` | The three enchantment level costs shown on the table. :api-badge{kind="readonly"} |
| `goldCount` | `number` | The lapis count the table reports. :api-badge{kind="readonly"} |
| `item` | [ItemStack](itemstack) | The item being enchanted, or undefined. :api-badge{kind="readonly"} |
| `lapis` | [ItemStack](itemstack) | The lapis stack, or undefined. :api-badge{kind="readonly"} |

