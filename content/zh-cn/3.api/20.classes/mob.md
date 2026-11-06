---
title: "Mob"
description: "生物基类：AI 开关与当前攻击目标，为敌对与可驯物种共享。"
---

Handle · Wraps: `net.minecraft.world.entity.Mob` · Extends: [`LivingEntity`](livingentity) · Extended by: [`Animal`](animal), [`Bat`](bat), [`Creeper`](creeper), [`Enderman`](enderman), [`Ghast`](ghast), [`Phantom`](phantom), [`Spider`](spider), [`Strider`](strider), [`Villager`](villager), [`WitherBoss`](witherboss), [`Zombie`](zombie)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `noAi` | `boolean` | 该生物是否无 AI（NoAI 标签生成）。 (read-only) |
| `target` | [Entity](entity) | 当前攻击目标；空闲时为 undefined。 (read-only) |

