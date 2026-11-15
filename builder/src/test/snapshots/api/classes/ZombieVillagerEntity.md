---
title: "ZombieVillagerEntity"
description: "A zombie villager: trade identity and conversion state."
---

::api-declaration{ kind="handle" name="ZombieVillagerEntity" wraps="net.minecraft.world.entity.monster.zombie.ZombieVillager"}
#extends
[`ZombieEntity`](ZombieEntity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `converting` | `boolean` | Whether the zombie villager is converting back into a villager. :api-badge{kind="readonly"} |
| `level` | `number` | The trade level (1-5) this villager would regain on curing. :api-badge{kind="readonly"} |
| `profession` | `string` | The profession identifier this villager would regain on curing, e.g. minecraft:farmer. :api-badge{kind="readonly"} |
| `variant` | `string` | The biome variant identifier this villager would regain on curing, e.g. minecraft:plains. :api-badge{kind="readonly"} |

