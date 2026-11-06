---
title: "WanderingTrader"
description: "A wandering trader: despawn countdown."
---

::api-declaration{ kind="handle" name="WanderingTrader" wraps="net.minecraft.world.entity.npc.wanderingtrader.WanderingTrader"}
#extends
[`Mob`](mob)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `despawnDelay` | `number` | The delay in ticks before the trader despawns; zero while trading. :api-badge{kind="readonly"} |

