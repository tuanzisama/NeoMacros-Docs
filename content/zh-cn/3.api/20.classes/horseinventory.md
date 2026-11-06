---
title: "HorseInventory"
description: "坐骑物品栏界面：在普通槽位面之上的鞍槽与马甲槽。"
---

::api-declaration{ kind="handle" name="HorseInventory" wraps="net.minecraft.world.inventory.HorseInventoryMenu"}
#extends
[`Inventory`](inventory)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `armor` | [ItemStack](itemstack) | 马甲槽中的物品堆。 :api-badge{kind="readonly"} |
| `saddle` | [ItemStack](itemstack) | 鞍槽中的物品堆。 :api-badge{kind="readonly"} |

