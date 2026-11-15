---
title: "CraftingInventory"
description: "工作台界面：3x3 格与结果槽。"
---

::api-declaration{ kind="handle" name="CraftingInventory" wraps="net.minecraft.world.inventory.CraftingMenu"}
#extends
[`Inventory`](Inventory.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `grid` | :api-type{text='Array<ItemStack>' refs='ItemStack=classes/itemstack'} | 3x3 合成格（菜单槽 1-9）。 |
| `result` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | 合成产出物品；为空时 undefined。 :api-badge{kind="readonly"} |

