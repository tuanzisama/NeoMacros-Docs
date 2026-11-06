---
title: "FurnaceInventory"
description: "熔炉族容器界面：输入/燃料/输出槽位与打开菜单的实时燃烧状态。"
---

Handle · Wraps: `net.minecraft.world.inventory.AbstractFurnaceMenu` · Extends: [`Inventory`](inventory)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `burnProgress` | `number` | 燃料燃烧进度（0-1）；无则为 undefined。 (read-only) |
| `fuel` | [ItemStack](itemstack) | 燃料物品；为空时 undefined。 (read-only) |
| `input` | [ItemStack](itemstack) | 冶炼输入物品；为空时 undefined。 (read-only) |
| `lit` | `boolean` | 熔炉当前是否在燃烧。 (read-only) |
| `litProgress` | `number` | 冶炼箭头进度（0-1）；无则为 undefined。 (read-only) |
| `output` | [ItemStack](itemstack) | 冶炼产出物品；为空时 undefined。 (read-only) |

