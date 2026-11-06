---
title: "BeaconInventory"
description: "A beacon screen: the payment slot, effect selection, and power level."
---

Handle · Wraps: `net.minecraft.world.inventory.BeaconMenu` · Extends: [`Inventory`](inventory)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `levels` | `number` | The beacon power level (1-4), or undefined. (read-only) |
| `payment` | [ItemStack](itemstack) | The payment stack, or undefined. (read-only) |
| `primaryEffect` | `string` | The primary effect id, or undefined. (read-only) |
| `secondaryEffect` | `string` | The secondary effect id, or undefined. (read-only) |

