---
title: "CartographyInventory"
description: "A cartography table screen: the map, the material, and the result."
---

::api-declaration{ kind="handle" name="CartographyInventory" wraps="net.minecraft.world.inventory.CartographyTableMenu"}
#extends
[`Inventory`](inventory)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `map` | [ItemStack](itemstack) | The map stack, or undefined. :api-badge{kind="readonly"} |
| `material` | [ItemStack](itemstack) | The material stack, or undefined. :api-badge{kind="readonly"} |
| `result` | [ItemStack](itemstack) | The cartography result stack, or undefined. :api-badge{kind="readonly"} |

