---
title: "BrewingStandInventory"
description: "A brewing stand screen: the three bottles, ingredient, fuel, and the live brew progress."
---

::api-declaration{ kind="handle" name="BrewingStandInventory" wraps="net.minecraft.world.inventory.BrewingStandMenu"}
#extends
[`Inventory`](inventory)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `bottles` | `Array<`[ItemStack](itemstack)`>` | The three bottle stacks (slots 0-2). |
| `brewingTicks` | `number` | The remaining brewing ticks. :api-badge{kind="readonly"} |
| `fuel` | [ItemStack](itemstack) | The blaze fuel stack (slot 4), or undefined. :api-badge{kind="readonly"} |
| `fuelUses` | `number` | The remaining fuel uses. :api-badge{kind="readonly"} |
| `ingredient` | [ItemStack](itemstack) | The ingredient stack (slot 3), or undefined. :api-badge{kind="readonly"} |
| `totalBrewingTicks` | `number` | The total brewing ticks per batch. :api-badge{kind="readonly"} |
| `totalFuelUses` | `number` | The total fuel uses a full blaze rod charges. :api-badge{kind="readonly"} |

