---
title: "Piglin"
description: "A piglin: barterer growth and zombification state."
---

::api-declaration{ kind="handle" name="Piglin" wraps="net.minecraft.world.entity.monster.piglin.Piglin"}
#extends
[`Mob`](mob)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `adult` | `boolean` | Whether the piglin has grown out of its baby stage. :api-badge{kind="readonly"} |
| `converting` | `boolean` | Whether the piglin is converting into a zombified piglin. :api-badge{kind="readonly"} |

