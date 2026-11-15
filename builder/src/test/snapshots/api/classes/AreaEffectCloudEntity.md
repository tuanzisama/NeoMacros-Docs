---
title: "AreaEffectCloudEntity"
description: "An area effect cloud: radius and waiting state."
---

::api-declaration{ kind="handle" name="AreaEffectCloudEntity" wraps="net.minecraft.world.entity.AreaEffectCloud"}
#extends
[`Entity`](Entity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `radius` | `number` | The current cloud radius in blocks. :api-badge{kind="readonly"} |
| `waitTime` | `number` | The remaining wait time in ticks. :api-badge{kind="readonly"} |
| `waiting` | `boolean` | Whether the cloud is waiting before the effect starts. :api-badge{kind="readonly"} |

