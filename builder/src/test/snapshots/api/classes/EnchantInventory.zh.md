---
title: "EnchantInventory"
description: "附魔台界面：物品、青金石与三档费用。"
---

::api-declaration{ kind="handle" name="EnchantInventory" wraps="net.minecraft.world.inventory.EnchantmentMenu"}
#extends
[`Inventory`](Inventory.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `costs` | `Array<number>` | 附魔台展示的三档等级费用。 :api-badge{kind="readonly"} |
| `goldCount` | `number` | 附魔台报告的青金石数量。 :api-badge{kind="readonly"} |
| `item` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | 待附魔物品；为空时 undefined。 :api-badge{kind="readonly"} |
| `lapis` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | 青金石；为空时 undefined。 :api-badge{kind="readonly"} |

