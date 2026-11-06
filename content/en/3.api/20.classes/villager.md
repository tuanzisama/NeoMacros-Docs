---
title: "Villager"
description: "A villager: profession, trade level, and biome variant."
---

::api-declaration{ kind="handle" name="Villager" wraps="net.minecraft.world.entity.npc.villager.Villager"}
#extends
[`Mob`](mob)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `level` | `number` | The trade level (1-5); undefined for nitwits. :api-badge{kind="readonly"} |
| `profession` | `string` | The profession identifier, e.g. minecraft:farmer. :api-badge{kind="readonly"} |
| `variant` | `string` | The biome variant identifier, e.g. minecraft:plains. :api-badge{kind="readonly"} |

