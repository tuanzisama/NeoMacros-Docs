---
title: "WanderingTraderEntity"
description: "A wandering trader: despawn countdown."
---

::api-declaration{ kind="handle" name="WanderingTraderEntity" wraps="net.minecraft.world.entity.npc.wanderingtrader.WanderingTrader"}
#extends
[`MobEntity`](MobEntity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `despawnDelay` | `number` | The delay in ticks before the trader despawns; zero while trading. :api-badge{kind="readonly"} |

