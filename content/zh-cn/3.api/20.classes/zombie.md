---
title: "Zombie"
description: "僵尸：溺水转化状态。"
---

::api-declaration{ kind="handle" name="Zombie" wraps="net.minecraft.world.entity.monster.zombie.Zombie"}
#extends
[`Mob`](mob)
#extended-by
[`Drowned`](drowned), [`ZombieVillager`](zombievillager), [`ZombifiedPiglin`](zombifiedpiglin)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `underWaterConverting` | `boolean` | 僵尸是否正在水下转化为溺尸。 :api-badge{kind="readonly"} |

