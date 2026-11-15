---
title: "ItemFrameEntity"
description: "物品展示框：所展示的物品堆与旋转步进。"
---

::api-declaration{ kind="handle" name="ItemFrameEntity" wraps="net.minecraft.world.entity.decoration.ItemFrame"}
#extends
[`Entity`](Entity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `frameRotation` | `number` | 展示物品的旋转步进（0-3）。 :api-badge{kind="readonly"} |
| `item` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | 展示的物品堆；空框为 minecraft:air。 :api-badge{kind="readonly"} |

