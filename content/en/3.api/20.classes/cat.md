---
title: "Cat"
description: "A cat: collar color and coat variant."
---

::api-declaration{ kind="handle" name="Cat" wraps="net.minecraft.world.entity.animal.feline.Cat"}
#extends
[`TamableAnimal`](tamableanimal)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `collarColor` | `string` | The collar color identifier, e.g. minecraft:red. :api-badge{kind="readonly"} |
| `variant` | `string` | The coat variant identifier, e.g. minecraft:black. :api-badge{kind="readonly"} |

