---
title: "AnvilInventory"
description: "铁砧界面：两输入槽、产出与修复费用。"
---

::api-declaration{ kind="handle" name="AnvilInventory" wraps="net.minecraft.world.inventory.AnvilMenu"}
#extends
[`Inventory`](Inventory.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `cost` | `number` | 打开的铁砧收取的修复/附魔等级费用。 :api-badge{kind="readonly"} |
| `firstInput` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | 左侧输入物品；为空时 undefined。 :api-badge{kind="readonly"} |
| `result` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | 合成结果物品；为空时 undefined。 :api-badge{kind="readonly"} |
| `secondInput` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | 右侧输入物品；为空时 undefined。 :api-badge{kind="readonly"} |

