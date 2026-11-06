---
title: "StonecutterInventory"
description: "A stonecutter screen: the input block and the selected recipe output."
---

::api-declaration{ kind="handle" name="StonecutterInventory" wraps="net.minecraft.world.inventory.StonecutterMenu"}
#extends
[`Inventory`](inventory)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `input` | [ItemStack](itemstack) | The input stack, or undefined. :api-badge{kind="readonly"} |
| `recipeCount` | `number` | How many recipes the visible set offers. :api-badge{kind="readonly"} |
| `selectedRecipeIndex` | `number` | The selected recipe index, or undefined without input. :api-badge{kind="readonly"} |

