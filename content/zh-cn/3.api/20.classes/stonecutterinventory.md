---
title: "StonecutterInventory"
description: "切石机界面：输入方块与所选配方产出。"
---

Handle · Wraps: `net.minecraft.world.inventory.StonecutterMenu` · Extends: [`Inventory`](inventory)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `input` | [ItemStack](itemstack) | 输入物品；为空时 undefined。 (read-only) |
| `recipeCount` | `number` | 可见配方数量。 (read-only) |
| `selectedRecipeIndex` | `number` | 所选配方序号；无输入为 undefined。 (read-only) |

