---
title: "SmithingInventory"
description: "锻造台界面：模板、基材、添加材料与产出。"
---

::api-declaration{ kind="handle" name="SmithingInventory" wraps="net.minecraft.world.inventory.SmithingMenu"}
#extends
[`Inventory`](Inventory.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `addition` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | 添加材料物品；为空时 undefined。 :api-badge{kind="readonly"} |
| `base` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | 基材物品；为空时 undefined。 :api-badge{kind="readonly"} |
| `result` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | 锻造产出物品；为空时 undefined。 :api-badge{kind="readonly"} |
| `template` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | 锻造模板物品；为空时 undefined。 :api-badge{kind="readonly"} |

