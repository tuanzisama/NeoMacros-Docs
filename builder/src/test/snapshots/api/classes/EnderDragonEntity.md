---
title: "EnderDragonEntity"
description: "The ender dragon: fight phase and death countdown."
---

::api-declaration{ kind="handle" name="EnderDragonEntity" wraps="net.minecraft.world.entity.boss.enderdragon.EnderDragon"}
#extends
[`MobEntity`](MobEntity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `deathTime` | `number` | The death animation countdown; above zero only while dying. :api-badge{kind="readonly"} |
| `phase` | `number` | The fight phase index synced from the dragon fight. :api-badge{kind="readonly"} |

