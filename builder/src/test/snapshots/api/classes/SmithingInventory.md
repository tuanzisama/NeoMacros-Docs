---
title: "SmithingInventory"
description: "A smithing table screen: template, base, addition, and result."
---

::api-declaration{ kind="handle" name="SmithingInventory" wraps="net.minecraft.world.inventory.SmithingMenu"}
#extends
[`Inventory`](Inventory.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `addition` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The addition stack, or undefined. :api-badge{kind="readonly"} |
| `base` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The base stack, or undefined. :api-badge{kind="readonly"} |
| `result` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The smithed result stack, or undefined. :api-badge{kind="readonly"} |
| `template` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The smithing template stack, or undefined. :api-badge{kind="readonly"} |

