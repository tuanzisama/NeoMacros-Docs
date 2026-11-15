---
title: "HorseInventory"
description: "A mount inventory screen: the saddle and body armor slots over the ordinary slot face."
---

::api-declaration{ kind="handle" name="HorseInventory" wraps="net.minecraft.world.inventory.HorseInventoryMenu"}
#extends
[`Inventory`](Inventory.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `armor` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The stack in the body armor slot. :api-badge{kind="readonly"} |
| `saddle` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The stack in the saddle slot. :api-badge{kind="readonly"} |

