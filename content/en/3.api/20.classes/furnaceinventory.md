---
title: "FurnaceInventory"
description: "A furnace-family container screen: input/fuel/output slots plus the live burn state read from the open menu."
---

Handle · Wraps: `net.minecraft.world.inventory.AbstractFurnaceMenu` · Extends: [`Inventory`](inventory)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `burnProgress` | `number` | The fuel burn progress (0-1), or undefined. (read-only) |
| `fuel` | [ItemStack](itemstack) | The fuel stack, or undefined. (read-only) |
| `input` | [ItemStack](itemstack) | The smelting input stack, or undefined. (read-only) |
| `lit` | `boolean` | Whether the furnace is currently burning. (read-only) |
| `litProgress` | `number` | The smelting arrow progress (0-1), or undefined. (read-only) |
| `output` | [ItemStack](itemstack) | The smelted output stack, or undefined. (read-only) |

