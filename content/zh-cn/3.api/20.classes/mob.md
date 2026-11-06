---
title: "Mob"
description: "生物基类：AI 开关与当前攻击目标，为敌对与可驯物种共享。"
---

Handle · Wraps: `net.minecraft.world.entity.Mob` · Extends: [`LivingEntity`](livingentity) · Extended by: [`Allay`](allay), [`Animal`](animal), [`Bat`](bat), [`Breeze`](breeze), [`Creaking`](creaking), [`Creeper`](creeper), [`Dolphin`](dolphin), [`EnderDragon`](enderdragon), [`Enderman`](enderman), [`Evoker`](evoker), [`Ghast`](ghast), [`Phantom`](phantom), [`Piglin`](piglin), [`PiglinBrute`](piglinbrute), [`Pillager`](pillager), [`Shulker`](shulker), [`SnowGolem`](snowgolem), [`Spider`](spider), [`Strider`](strider), [`Vex`](vex), [`Villager`](villager), [`WanderingTrader`](wanderingtrader), [`Warden`](warden), [`Witch`](witch), [`WitherBoss`](witherboss), [`Zombie`](zombie)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `noAi` | `boolean` | 该生物是否无 AI（NoAI 标签生成）。 (read-only) |
| `target` | [Entity](entity) | 当前攻击目标；空闲时为 undefined。 (read-only) |

