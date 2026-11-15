---
title: "ZombieEntity"
description: "A zombie: drowning conversion state."
---

::api-declaration{ kind="handle" name="ZombieEntity" wraps="net.minecraft.world.entity.monster.zombie.Zombie"}
#extends
[`MobEntity`](MobEntity.html)
#extended-by
[`DrownedEntity`](DrownedEntity.html), [`ZombieVillagerEntity`](ZombieVillagerEntity.html), [`ZombifiedPiglinEntity`](ZombifiedPiglinEntity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `underWaterConverting` | `boolean` | Whether the zombie is converting into a drowned underwater. :api-badge{kind="readonly"} |

