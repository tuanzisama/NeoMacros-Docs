---
title: "BeaconInventory"
description: "信标界面：付费槽、效果选择与能级。"
---

Handle · Wraps: `net.minecraft.world.inventory.BeaconMenu` · Extends: [`Inventory`](inventory)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `levels` | `number` | 信标能级（1-4）；未加载为 undefined。 (read-only) |
| `payment` | [ItemStack](itemstack) | 付费物品；为空时 undefined。 (read-only) |
| `primaryEffect` | `string` | 主效果标识；未选择为 undefined。 (read-only) |
| `secondaryEffect` | `string` | 副效果标识；未选择为 undefined。 (read-only) |

