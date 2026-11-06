---
title: "AbstractFish"
description: "The fish base: bucket-birth state."
---

::api-declaration{ kind="handle" name="AbstractFish" wraps="net.minecraft.world.entity.animal.fish.AbstractFish"}
#extends
[`Animal`](animal)
#extended-by
[`AbstractSchoolingFish`](abstractschoolingfish), [`Pufferfish`](pufferfish), [`TropicalFish`](tropicalfish)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `fromBucket` | `boolean` | Whether the fish was released from a water bucket. :api-badge{kind="readonly"} |

