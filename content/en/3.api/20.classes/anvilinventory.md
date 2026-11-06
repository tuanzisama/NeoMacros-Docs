---
title: "AnvilInventory"
description: "An anvil screen: the two input slots, result, and the repair cost."
---

Handle · Wraps: `net.minecraft.world.inventory.AnvilMenu` · Extends: [`Inventory`](inventory)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `cost` | `number` | The repair/enchant level cost charged by the open anvil. (read-only) |
| `firstInput` | [ItemStack](itemstack) | The left (first) input stack, or undefined. (read-only) |
| `result` | [ItemStack](itemstack) | The combined result stack, or undefined. (read-only) |
| `secondInput` | [ItemStack](itemstack) | The right (second) input stack, or undefined. (read-only) |

