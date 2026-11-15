---
title: "SheepEntity"
description: "绵羊：羊毛颜色与剪毛状态。"
---

::api-declaration{ kind="handle" name="SheepEntity" wraps="net.minecraft.world.entity.animal.sheep.Sheep"}
#extends
[`AnimalEntity`](AnimalEntity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `color` | `string` | 羊毛颜色标识，如 minecraft:white。 :api-badge{kind="readonly"} |
| `sheared` | `boolean` | 羊毛是否已被剪掉。 :api-badge{kind="readonly"} |

