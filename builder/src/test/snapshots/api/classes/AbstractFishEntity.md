---
title: "AbstractFishEntity"
description: "The fish base: bucket-birth state."
---

::api-declaration{ kind="handle" name="AbstractFishEntity" wraps="net.minecraft.world.entity.animal.fish.AbstractFish"}
#extends
[`AnimalEntity`](AnimalEntity.html)
#extended-by
[`AbstractSchoolingFishEntity`](AbstractSchoolingFishEntity.html), [`PufferfishEntity`](PufferfishEntity.html), [`TropicalFishEntity`](TropicalFishEntity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `fromBucket` | `boolean` | Whether the fish was released from a water bucket. :api-badge{kind="readonly"} |

