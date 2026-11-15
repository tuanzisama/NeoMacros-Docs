---
title: "ArmorStandEntity"
description: "An armor stand: the marker and small pose flags."
---

::api-declaration{ kind="handle" name="ArmorStandEntity" wraps="net.minecraft.world.entity.decoration.ArmorStand"}
#extends
[`MobEntity`](MobEntity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `marker` | `boolean` | Whether the stand is a hitbox-less marker. :api-badge{kind="readonly"} |
| `small` | `boolean` | Whether the stand uses the small pose. :api-badge{kind="readonly"} |

