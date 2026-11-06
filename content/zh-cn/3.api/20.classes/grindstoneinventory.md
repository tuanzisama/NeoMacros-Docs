---
title: "GrindstoneInventory"
description: "砂轮界面：两输入槽与去魔结果。"
---

::api-declaration{ kind="handle" name="GrindstoneInventory" wraps="net.minecraft.world.inventory.GrindstoneMenu"}
#extends
[`Inventory`](inventory)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `bottomInput` | [ItemStack](itemstack) | 下侧输入物品；为空时 undefined。 :api-badge{kind="readonly"} |
| `result` | [ItemStack](itemstack) | 去魔结果物品；为空时 undefined。 :api-badge{kind="readonly"} |
| `topInput` | [ItemStack](itemstack) | 上侧输入物品；为空时 undefined。 :api-badge{kind="readonly"} |

