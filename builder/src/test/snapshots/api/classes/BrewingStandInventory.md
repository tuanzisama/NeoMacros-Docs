---
title: "BrewingStandInventory"
description: "A brewing stand screen: the three bottles, ingredient, fuel, and the live brew progress."
---

::api-declaration{ kind="handle" name="BrewingStandInventory" wraps="net.minecraft.world.inventory.BrewingStandMenu"}
#extends
[`Inventory`](Inventory.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `bottles` | :api-type{text='Array<ItemStack>' refs='ItemStack=classes/itemstack'} | The three bottle stacks (slots 0-2). |
| `brewingTicks` | `number` | The remaining brewing ticks. :api-badge{kind="readonly"} |
| `fuel` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The blaze fuel stack (slot 4), or undefined. :api-badge{kind="readonly"} |
| `fuelUses` | `number` | The remaining fuel uses. :api-badge{kind="readonly"} |
| `ingredient` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The ingredient stack (slot 3), or undefined. :api-badge{kind="readonly"} |
| `totalBrewingTicks` | `number` | The total brewing ticks per batch. :api-badge{kind="readonly"} |
| `totalFuelUses` | `number` | The total fuel uses a full blaze rod charges. :api-badge{kind="readonly"} |

