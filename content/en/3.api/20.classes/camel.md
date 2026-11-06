---
title: "Camel"
description: "A camel: dash and sit pose, over the horse inventory base."
---

::api-declaration{ kind="handle" name="Camel" wraps="net.minecraft.world.entity.animal.camel.Camel"}
#extends
[`AbstractHorse`](abstracthorse)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `dashing` | `boolean` | Whether the camel is dashing. :api-badge{kind="readonly"} |
| `inPoseTransition` | `boolean` | Whether the camel is transitioning between sit poses. :api-badge{kind="readonly"} |
| `poseTime` | `number` | The tick timestamp of the last pose change. :api-badge{kind="readonly"} |
| `sitting` | `boolean` | Whether the camel is sitting. :api-badge{kind="readonly"} |

