---
title: "CartographyInventory"
description: "制图台界面：地图、材料与产出。"
---

::api-declaration{ kind="handle" name="CartographyInventory" wraps="net.minecraft.world.inventory.CartographyTableMenu"}
#extends
[`Inventory`](inventory)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `map` | [ItemStack](itemstack) | 地图物品；为空时 undefined。 :api-badge{kind="readonly"} |
| `material` | [ItemStack](itemstack) | 材料物品；为空时 undefined。 :api-badge{kind="readonly"} |
| `result` | [ItemStack](itemstack) | 制图产出物品；为空时 undefined。 :api-badge{kind="readonly"} |

