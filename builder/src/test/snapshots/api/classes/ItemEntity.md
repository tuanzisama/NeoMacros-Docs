---
title: "ItemEntity"
description: "Dropped item stack handle."
---

::api-declaration{ kind="handle" name="ItemEntity" wraps="net.minecraft.world.entity.item.ItemEntity"}
#extends
[`Entity`](Entity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `stack` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The dropped item stack; undefined once the entity is gone. :api-badge{kind="readonly"} |

