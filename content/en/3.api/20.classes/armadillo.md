---
title: "Armadillo"
description: "An armadillo: shell roll state."
---

::api-declaration{ kind="handle" name="Armadillo" wraps="net.minecraft.world.entity.animal.armadillo.Armadillo"}
#extends
[`Animal`](animal)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `scared` | `boolean` | Whether the armadillo is scared into its shell. :api-badge{kind="readonly"} |
| `state` | `string` | The roll state identifier, one of minecraft:idle, minecraft:rolling, minecraft:scared, or minecraft:unrolling. :api-badge{kind="readonly"} |

