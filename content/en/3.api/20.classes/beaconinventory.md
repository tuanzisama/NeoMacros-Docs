---
title: "BeaconInventory"
description: "A beacon screen: the payment slot, effect selection, and power level."
---

::api-declaration{ kind="handle" name="BeaconInventory" wraps="net.minecraft.world.inventory.BeaconMenu"}
#extends
[`Inventory`](inventory)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `levels` | `number` | The beacon power level (1-4), or undefined. :api-badge{kind="readonly"} |
| `payment` | [ItemStack](itemstack) | The payment stack, or undefined. :api-badge{kind="readonly"} |
| `primaryEffect` | `string` | The primary effect id, or undefined. :api-badge{kind="readonly"} |
| `secondaryEffect` | `string` | The secondary effect id, or undefined. :api-badge{kind="readonly"} |

