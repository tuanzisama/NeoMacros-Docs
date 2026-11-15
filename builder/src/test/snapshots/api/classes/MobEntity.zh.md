---
title: "MobEntity"
description: "生物基类：AI 开关与当前攻击目标，为敌对与可驯物种共享。"
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
| `noAi` | `boolean` | 该生物是否无 AI（NoAI 标签生成）。 :api-badge{kind="readonly"} |
| `target` | :api-type{text='Entity' refs='Entity=classes/entity'} | 当前攻击目标；空闲时为 undefined。 :api-badge{kind="readonly"} |

