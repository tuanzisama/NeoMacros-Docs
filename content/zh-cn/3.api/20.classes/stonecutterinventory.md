---
title: "StonecutterInventory"
description: "切石机界面：输入方块与所选配方产出。"
---

::api-declaration{ kind="handle" name="StonecutterInventory" wraps="net.minecraft.world.inventory.StonecutterMenu"}
#extends
[`Inventory`](inventory)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `input` | [ItemStack](itemstack) | 输入物品；为空时 undefined。 :api-badge{kind="readonly"} |
| `recipeCount` | `number` | 可见配方数量。 :api-badge{kind="readonly"} |
| `selectedRecipeIndex` | `number` | 所选配方序号；无输入为 undefined。 :api-badge{kind="readonly"} |

