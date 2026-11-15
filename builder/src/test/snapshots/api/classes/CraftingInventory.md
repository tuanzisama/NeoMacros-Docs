---
title: "CraftingInventory"
description: "A crafting table screen: the 3x3 grid and the result slot."
---

::api-declaration{ kind="handle" name="CraftingInventory" wraps="net.minecraft.world.inventory.CraftingMenu"}
#extends
[`Inventory`](Inventory.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `grid` | :api-type{text='Array<ItemStack>' refs='ItemStack=classes/itemstack'} | The 3x3 crafting grid (menu slots 1-9). |
| `result` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The crafting result stack, or undefined. :api-badge{kind="readonly"} |

