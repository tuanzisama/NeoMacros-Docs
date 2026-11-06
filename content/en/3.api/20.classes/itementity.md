---
title: "ItemEntity"
description: "Dropped item stack handle."
---

::api-declaration{ kind="handle" name="ItemEntity" wraps="net.minecraft.world.entity.item.ItemEntity"}
#extends
[`Entity`](entity)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `stack` | [ItemStack](itemstack) | The dropped item stack; undefined once the entity is gone. :api-badge{kind="readonly"} |

