---
title: "Allay"
description: "An allay: jukebox dance and held-item state."
---

::api-declaration{ kind="handle" name="Allay" wraps="net.minecraft.world.entity.animal.allay.Allay"}
#extends
[`Mob`](mob)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `dancing` | `boolean` | Whether the allay is dancing to a nearby jukebox. :api-badge{kind="readonly"} |
| `flapping` | `boolean` | Whether the allay is flapping its wings this tick. :api-badge{kind="readonly"} |
| `spinning` | `boolean` | Whether the dancing allay is doing its spin flourish. :api-badge{kind="readonly"} |

## Methods

### `hasItemInHand()`

Whether the allay is currently holding an item.

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

