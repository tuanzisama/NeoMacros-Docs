---
title: "Mob"
description: "The mob base: artificial-intelligence toggle and current attack target, shared by every hostile and tameable species."
---

::api-declaration{ kind="handle" name="Mob" wraps="net.minecraft.world.entity.Mob"}
#extends
[`LivingEntity`](livingentity)
#extended-by
[`Allay`](allay), [`Animal`](animal), [`Bat`](bat), [`Breeze`](breeze), [`Creaking`](creaking), [`Creeper`](creeper), [`Dolphin`](dolphin), [`EnderDragon`](enderdragon), [`Enderman`](enderman), [`Evoker`](evoker), [`Ghast`](ghast), [`Phantom`](phantom), [`Piglin`](piglin), [`PiglinBrute`](piglinbrute), [`Pillager`](pillager), [`Shulker`](shulker), [`SnowGolem`](snowgolem), [`Spider`](spider), [`Strider`](strider), [`Vex`](vex), [`Villager`](villager), [`WanderingTrader`](wanderingtrader), [`Warden`](warden), [`Witch`](witch), [`WitherBoss`](witherboss), [`Zombie`](zombie)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `noAi` | `boolean` | Whether the mob has no AI (spawned with the NoAI tag). :api-badge{kind="readonly"} |
| `target` | [Entity](entity) | The current attack target, or undefined when idle. :api-badge{kind="readonly"} |

