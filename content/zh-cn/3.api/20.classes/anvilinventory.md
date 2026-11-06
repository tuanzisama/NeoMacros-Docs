---
title: "AnvilInventory"
description: "铁砧界面：两输入槽、产出与修复费用。"
---

::api-declaration{ kind="handle" name="AnvilInventory" wraps="net.minecraft.world.inventory.AnvilMenu"}
#extends
[`Inventory`](inventory)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `cost` | `number` | 打开的铁砧收取的修复/附魔等级费用。 :api-badge{kind="readonly"} |
| `firstInput` | [ItemStack](itemstack) | 左侧输入物品；为空时 undefined。 :api-badge{kind="readonly"} |
| `result` | [ItemStack](itemstack) | 合成结果物品；为空时 undefined。 :api-badge{kind="readonly"} |
| `secondInput` | [ItemStack](itemstack) | 右侧输入物品；为空时 undefined。 :api-badge{kind="readonly"} |

