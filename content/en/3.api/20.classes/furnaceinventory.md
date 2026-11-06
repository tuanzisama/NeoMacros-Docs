---
title: "FurnaceInventory"
description: "A furnace-family container screen: input/fuel/output slots plus the live burn state read from the open menu."
---

::api-declaration{ kind="handle" name="FurnaceInventory" wraps="net.minecraft.world.inventory.AbstractFurnaceMenu"}
#extends
[`Inventory`](inventory)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `burnProgress` | `number` | The fuel burn progress (0-1), or undefined. :api-badge{kind="readonly"} |
| `fuel` | [ItemStack](itemstack) | The fuel stack, or undefined. :api-badge{kind="readonly"} |
| `input` | [ItemStack](itemstack) | The smelting input stack, or undefined. :api-badge{kind="readonly"} |
| `lit` | `boolean` | Whether the furnace is currently burning. :api-badge{kind="readonly"} |
| `litProgress` | `number` | The smelting arrow progress (0-1), or undefined. :api-badge{kind="readonly"} |
| `output` | [ItemStack](itemstack) | The smelted output stack, or undefined. :api-badge{kind="readonly"} |

