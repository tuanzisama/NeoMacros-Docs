---
title: "GrindstoneInventory"
description: "A grindstone screen: the two input slots and the disenchanted result."
---

::api-declaration{ kind="handle" name="GrindstoneInventory" wraps="net.minecraft.world.inventory.GrindstoneMenu"}
#extends
[`Inventory`](Inventory.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `bottomInput` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The bottom input stack, or undefined. :api-badge{kind="readonly"} |
| `result` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The disenchanted result stack, or undefined. :api-badge{kind="readonly"} |
| `topInput` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The top input stack, or undefined. :api-badge{kind="readonly"} |

