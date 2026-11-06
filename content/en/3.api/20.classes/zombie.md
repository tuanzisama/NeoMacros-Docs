---
title: "Zombie"
description: "A zombie: drowning conversion state."
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
| `underWaterConverting` | `boolean` | Whether the zombie is converting into a drowned underwater. :api-badge{kind="readonly"} |

