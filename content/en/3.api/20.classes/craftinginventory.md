---
title: "CraftingInventory"
description: "A crafting table screen: the 3x3 grid and the result slot."
---

Handle · Wraps: `net.minecraft.world.inventory.CraftingMenu` · Extends: [`Inventory`](inventory)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `grid` | `Array<`[ItemStack](itemstack)`>` | The 3x3 crafting grid (menu slots 1-9). |
| `result` | [ItemStack](itemstack) | The crafting result stack, or undefined. (read-only) |

