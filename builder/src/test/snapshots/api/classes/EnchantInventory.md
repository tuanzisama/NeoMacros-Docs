---
title: "EnchantInventory"
description: "An enchanting table screen: the item, lapis, and the three cost rows."
---

::api-declaration{ kind="handle" name="EnchantInventory" wraps="net.minecraft.world.inventory.EnchantmentMenu"}
#extends
[`Inventory`](Inventory.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `costs` | `Array<number>` | The three enchantment level costs shown on the table. :api-badge{kind="readonly"} |
| `goldCount` | `number` | The lapis count the table reports. :api-badge{kind="readonly"} |
| `item` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The item being enchanted, or undefined. :api-badge{kind="readonly"} |
| `lapis` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The lapis stack, or undefined. :api-badge{kind="readonly"} |

