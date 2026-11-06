---
title: "ZombieVillager"
description: "A zombie villager: trade identity and conversion state."
---

Handle · Wraps: `net.minecraft.world.entity.monster.zombie.ZombieVillager` · Extends: [`Zombie`](zombie)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `converting` | `boolean` | Whether the zombie villager is converting back into a villager. (read-only) |
| `level` | `number` | The trade level (1-5) this villager would regain on curing. (read-only) |
| `profession` | `string` | The profession identifier this villager would regain on curing, e.g. minecraft:farmer. (read-only) |
| `variant` | `string` | The biome variant identifier this villager would regain on curing, e.g. minecraft:plains. (read-only) |

