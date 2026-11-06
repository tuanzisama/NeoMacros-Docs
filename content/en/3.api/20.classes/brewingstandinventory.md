---
title: "BrewingStandInventory"
description: "A brewing stand screen: the three bottles, ingredient, fuel, and the live brew progress."
---

Handle · Wraps: `net.minecraft.world.inventory.BrewingStandMenu` · Extends: [`Inventory`](inventory)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `bottles` | `Array<`[ItemStack](itemstack)`>` | The three bottle stacks (slots 0-2). |
| `brewingTicks` | `number` | The remaining brewing ticks. (read-only) |
| `fuel` | [ItemStack](itemstack) | The blaze fuel stack (slot 4), or undefined. (read-only) |
| `fuelUses` | `number` | The remaining fuel uses. (read-only) |
| `ingredient` | [ItemStack](itemstack) | The ingredient stack (slot 3), or undefined. (read-only) |
| `totalBrewingTicks` | `number` | The total brewing ticks per batch. (read-only) |
| `totalFuelUses` | `number` | The total fuel uses a full blaze rod charges. (read-only) |

