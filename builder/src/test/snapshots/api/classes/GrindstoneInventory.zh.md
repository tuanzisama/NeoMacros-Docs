---
title: "GrindstoneInventory"
description: "砂轮界面：两输入槽与去魔结果。"
---

::api-declaration{ kind="handle" name="GrindstoneInventory" wraps="net.minecraft.world.inventory.GrindstoneMenu"}
#extends
[`Inventory`](Inventory.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `bottomInput` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | 下侧输入物品；为空时 undefined。 :api-badge{kind="readonly"} |
| `result` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | 去魔结果物品；为空时 undefined。 :api-badge{kind="readonly"} |
| `topInput` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | 上侧输入物品；为空时 undefined。 :api-badge{kind="readonly"} |

