---
title: "ZombieEntity"
description: "僵尸：溺水转化状态。"
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
| `underWaterConverting` | `boolean` | 僵尸是否正在水下转化为溺尸。 :api-badge{kind="readonly"} |

