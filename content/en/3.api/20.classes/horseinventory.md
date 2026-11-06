---
title: "HorseInventory"
description: "A mount inventory screen: the saddle and body armor slots over the ordinary slot face."
---

::api-declaration{ kind="handle" name="HorseInventory" wraps="net.minecraft.world.inventory.HorseInventoryMenu"}
#extends
[`Inventory`](inventory)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `armor` | [ItemStack](itemstack) | The stack in the body armor slot. :api-badge{kind="readonly"} |
| `saddle` | [ItemStack](itemstack) | The stack in the saddle slot. :api-badge{kind="readonly"} |

