---
title: "Armadillo"
description: "犰狳：缩壳状态。"
---

::api-declaration{ kind="handle" name="Armadillo" wraps="net.minecraft.world.entity.animal.armadillo.Armadillo"}
#extends
[`Animal`](animal)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `scared` | `boolean` | 犰狳是否受惊缩壳。 :api-badge{kind="readonly"} |
| `state` | `string` | 缩壳状态标识，取值 minecraft:idle、 minecraft:rolling、minecraft:scared 或 minecraft:unrolling。 :api-badge{kind="readonly"} |

