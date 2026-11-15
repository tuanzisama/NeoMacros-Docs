---
title: "SheepEntity"
description: "A sheep: wool color and sheared state."
---

::api-declaration{ kind="handle" name="SheepEntity" wraps="net.minecraft.world.entity.animal.sheep.Sheep"}
#extends
[`AnimalEntity`](AnimalEntity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `color` | `string` | The wool color identifier, e.g. minecraft:white. :api-badge{kind="readonly"} |
| `sheared` | `boolean` | Whether the wool has been sheared off. :api-badge{kind="readonly"} |

