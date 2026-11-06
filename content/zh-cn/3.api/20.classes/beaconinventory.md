---
title: "BeaconInventory"
description: "信标界面：付费槽、效果选择与能级。"
---

::api-declaration{ kind="handle" name="BeaconInventory" wraps="net.minecraft.world.inventory.BeaconMenu"}
#extends
[`Inventory`](inventory)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `levels` | `number` | 信标能级（1-4）；未加载为 undefined。 :api-badge{kind="readonly"} |
| `payment` | [ItemStack](itemstack) | 付费物品；为空时 undefined。 :api-badge{kind="readonly"} |
| `primaryEffect` | `string` | 主效果标识；未选择为 undefined。 :api-badge{kind="readonly"} |
| `secondaryEffect` | `string` | 副效果标识；未选择为 undefined。 :api-badge{kind="readonly"} |

