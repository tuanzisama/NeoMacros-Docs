---
title: "ItemFrameEntity"
description: "An item frame: the displayed stack and its rotation step."
---

::api-declaration{ kind="handle" name="ItemFrameEntity" wraps="net.minecraft.world.entity.decoration.ItemFrame"}
#extends
[`Entity`](Entity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `frameRotation` | `number` | The rotation step of the displayed stack (0-3). :api-badge{kind="readonly"} |
| `item` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The displayed stack; empty air when the frame is empty. :api-badge{kind="readonly"} |

