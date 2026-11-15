---
title: "AbstractHorseEntity"
description: "The horse base: taming, eating and breeding states plus the saddle inventory size."
---

::api-declaration{ kind="handle" name="AbstractHorseEntity" wraps="net.minecraft.world.entity.animal.equine.AbstractHorse"}
#extends
[`AnimalEntity`](AnimalEntity.html)
#extended-by
[`AbstractChestedHorseEntity`](AbstractChestedHorseEntity.html), [`CamelEntity`](CamelEntity.html), [`HorseEntity`](HorseEntity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `bred` | `boolean` | Whether the horse has bred after taming. :api-badge{kind="readonly"} |
| `eating` | `boolean` | Whether the horse is currently eating. :api-badge{kind="readonly"} |
| `inventorySize` | `number` | The saddle inventory slot count. :api-badge{kind="readonly"} |
| `tamed` | `boolean` | Whether the horse is tamed. :api-badge{kind="readonly"} |

