---
title: "AbstractFish"
description: "鱼类基类：桶装来源状态。"
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
| `fromBucket` | `boolean` | 鱼是否来自放出的水桶。 :api-badge{kind="readonly"} |

