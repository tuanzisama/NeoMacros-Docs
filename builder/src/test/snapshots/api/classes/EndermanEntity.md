---
title: "EndermanEntity"
description: "An enderman: the block it currently carries as an id string, or undefined."
---

::api-declaration{ kind="handle" name="EndermanEntity" wraps="net.minecraft.world.entity.monster.Enderman"}
#extends
[`MobEntity`](MobEntity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `carriedBlock` | `string` | The carried block id, or undefined when carrying nothing. :api-badge{kind="readonly"} |

