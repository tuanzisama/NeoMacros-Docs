---
title: "AnvilInventory"
description: "An anvil screen: the two input slots, result, and the repair cost."
---

::api-declaration{ kind="handle" name="AnvilInventory" wraps="net.minecraft.world.inventory.AnvilMenu"}
#extends
[`Inventory`](inventory)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `cost` | `number` | The repair/enchant level cost charged by the open anvil. :api-badge{kind="readonly"} |
| `firstInput` | [ItemStack](itemstack) | The left (first) input stack, or undefined. :api-badge{kind="readonly"} |
| `result` | [ItemStack](itemstack) | The combined result stack, or undefined. :api-badge{kind="readonly"} |
| `secondInput` | [ItemStack](itemstack) | The right (second) input stack, or undefined. :api-badge{kind="readonly"} |

