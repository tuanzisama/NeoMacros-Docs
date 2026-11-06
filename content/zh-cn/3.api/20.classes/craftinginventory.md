---
title: "CraftingInventory"
description: "工作台界面：3x3 格与结果槽。"
---

::api-declaration{ kind="handle" name="CraftingInventory" wraps="net.minecraft.world.inventory.CraftingMenu"}
#extends
[`Inventory`](inventory)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `grid` | `Array<`[ItemStack](itemstack)`>` | 3x3 合成格（菜单槽 1-9）。 |
| `result` | [ItemStack](itemstack) | 合成产出物品；为空时 undefined。 :api-badge{kind="readonly"} |

