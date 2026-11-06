---
title: "GrindstoneInventory"
description: "A grindstone screen: the two input slots and the disenchanted result."
---

::api-declaration{ kind="handle" name="GrindstoneInventory" wraps="net.minecraft.world.inventory.GrindstoneMenu"}
#extends
[`Inventory`](inventory)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `bottomInput` | [ItemStack](itemstack) | The bottom input stack, or undefined. :api-badge{kind="readonly"} |
| `result` | [ItemStack](itemstack) | The disenchanted result stack, or undefined. :api-badge{kind="readonly"} |
| `topInput` | [ItemStack](itemstack) | The top input stack, or undefined. :api-badge{kind="readonly"} |

