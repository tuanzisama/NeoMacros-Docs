---
title: "BrewingStandInventory"
description: "酿造台界面：三药瓶、原料、燃料与实时酿造进度。"
---

Handle · Wraps: `net.minecraft.world.inventory.BrewingStandMenu` · Extends: [`Inventory`](inventory)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `bottles` | `Array<`[ItemStack](itemstack)`>` | 三个药瓶物品（槽 0-2）。 |
| `brewingTicks` | `number` | 剩余酿造 tick。 (read-only) |
| `fuel` | [ItemStack](itemstack) | 烈焰燃料物品（槽 4）；为空时 undefined。 (read-only) |
| `fuelUses` | `number` | 剩余燃料次数。 (read-only) |
| `ingredient` | [ItemStack](itemstack) | 原料物品（槽 3）；为空时 undefined。 (read-only) |
| `totalBrewingTicks` | `number` | 每批酿造总 tick。 (read-only) |
| `totalFuelUses` | `number` | 满燃料棒提供的总次数。 (read-only) |

