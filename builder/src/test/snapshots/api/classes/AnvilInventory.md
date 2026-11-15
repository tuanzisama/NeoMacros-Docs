---
title: "AnvilInventory"
description: "An anvil screen: the two input slots, result, and the repair cost."
---

::api-declaration{ kind="handle" name="AnvilInventory" wraps="net.minecraft.world.inventory.AnvilMenu"}
#extends
[`Inventory`](Inventory.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `cost` | `number` | The repair/enchant level cost charged by the open anvil. :api-badge{kind="readonly"} |
| `firstInput` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The left (first) input stack, or undefined. :api-badge{kind="readonly"} |
| `result` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The combined result stack, or undefined. :api-badge{kind="readonly"} |
| `secondInput` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The right (second) input stack, or undefined. :api-badge{kind="readonly"} |

