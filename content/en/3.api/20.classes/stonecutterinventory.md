---
title: "StonecutterInventory"
description: "A stonecutter screen: the input block and the selected recipe output."
---

Handle · Wraps: `net.minecraft.world.inventory.StonecutterMenu` · Extends: [`Inventory`](inventory)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `input` | [ItemStack](itemstack) | The input stack, or undefined. (read-only) |
| `recipeCount` | `number` | How many recipes the visible set offers. (read-only) |
| `selectedRecipeIndex` | `number` | The selected recipe index, or undefined without input. (read-only) |

