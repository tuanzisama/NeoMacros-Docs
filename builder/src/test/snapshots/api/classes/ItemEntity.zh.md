---
title: "ItemEntity"
description: "掉落物句柄。"
---

::api-declaration{ kind="handle" name="ItemEntity" wraps="net.minecraft.world.entity.item.ItemEntity"}
#extends
[`Entity`](Entity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `stack` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | 掉落的物品堆；实体消失后为 undefined。 :api-badge{kind="readonly"} |

