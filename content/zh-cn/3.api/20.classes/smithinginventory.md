---
title: "SmithingInventory"
description: "锻造台界面：模板、基材、添加材料与产出。"
---

::api-declaration{ kind="handle" name="SmithingInventory" wraps="net.minecraft.world.inventory.SmithingMenu"}
#extends
[`Inventory`](inventory)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `addition` | [ItemStack](itemstack) | 添加材料物品；为空时 undefined。 :api-badge{kind="readonly"} |
| `base` | [ItemStack](itemstack) | 基材物品；为空时 undefined。 :api-badge{kind="readonly"} |
| `result` | [ItemStack](itemstack) | 锻造产出物品；为空时 undefined。 :api-badge{kind="readonly"} |
| `template` | [ItemStack](itemstack) | 锻造模板物品；为空时 undefined。 :api-badge{kind="readonly"} |

