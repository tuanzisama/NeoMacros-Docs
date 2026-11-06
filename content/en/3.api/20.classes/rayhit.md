---
title: "RayHit"
description: "Live raycast result: the first hit along the ray. block and entity are mutually exclusive; both are live handles."
---

::api-declaration{ kind="handle" name="RayHit"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `block` | [Block](block) | The hit block handle, or undefined on entity hits / misses. :api-badge{kind="readonly"} |
| `distance` | `number` | The distance from the origin to the hit (max distance on a miss). :api-badge{kind="readonly"} |
| `entity` | [Entity](entity) | The hit entity handle, or undefined on block hits / misses. :api-badge{kind="readonly"} |
| `hit` | `boolean` | Whether the ray hit anything at all. |
| `pos` | [Pos3D](pos3d) | The exact hit position. :api-badge{kind="readonly"} |

