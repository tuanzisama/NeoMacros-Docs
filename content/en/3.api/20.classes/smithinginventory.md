---
title: "SmithingInventory"
description: "A smithing table screen: template, base, addition, and result."
---

::api-declaration{ kind="handle" name="SmithingInventory" wraps="net.minecraft.world.inventory.SmithingMenu"}
#extends
[`Inventory`](inventory)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `addition` | [ItemStack](itemstack) | The addition stack, or undefined. :api-badge{kind="readonly"} |
| `base` | [ItemStack](itemstack) | The base stack, or undefined. :api-badge{kind="readonly"} |
| `result` | [ItemStack](itemstack) | The smithed result stack, or undefined. :api-badge{kind="readonly"} |
| `template` | [ItemStack](itemstack) | The smithing template stack, or undefined. :api-badge{kind="readonly"} |

