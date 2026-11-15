---
title: "MobEntity"
description: "The mob base: artificial-intelligence toggle and current attack target, shared by every hostile and tameable species."
---

::api-declaration{ kind="handle" name="MobEntity" wraps="net.minecraft.world.entity.Mob"}
#extends
[`LivingEntity`](LivingEntity.html)
#extended-by
[`AllayEntity`](AllayEntity.html), [`AnimalEntity`](AnimalEntity.html), [`ArmorStandEntity`](ArmorStandEntity.html), [`BatEntity`](BatEntity.html), [`BreezeEntity`](BreezeEntity.html), [`CreakingEntity`](CreakingEntity.html), [`CreeperEntity`](CreeperEntity.html), [`DolphinEntity`](DolphinEntity.html), [`EnderDragonEntity`](EnderDragonEntity.html), [`EndermanEntity`](EndermanEntity.html), [`EvokerEntity`](EvokerEntity.html), [`GhastEntity`](GhastEntity.html), [`PhantomEntity`](PhantomEntity.html), [`PiglinBruteEntity`](PiglinBruteEntity.html), [`PiglinEntity`](PiglinEntity.html), [`PillagerEntity`](PillagerEntity.html), [`ShulkerEntity`](ShulkerEntity.html), [`SnowGolemEntity`](SnowGolemEntity.html), [`SpiderEntity`](SpiderEntity.html), [`StriderEntity`](StriderEntity.html), [`VexEntity`](VexEntity.html), [`VillagerEntity`](VillagerEntity.html), [`WanderingTraderEntity`](WanderingTraderEntity.html), [`WardenEntity`](WardenEntity.html), [`WitchEntity`](WitchEntity.html), [`WitherBossEntity`](WitherBossEntity.html), [`ZombieEntity`](ZombieEntity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `noAi` | `boolean` | Whether the mob has no AI (spawned with the NoAI tag). :api-badge{kind="readonly"} |
| `target` | :api-type{text='Entity' refs='Entity=classes/entity'} | The current attack target, or undefined when idle. :api-badge{kind="readonly"} |

