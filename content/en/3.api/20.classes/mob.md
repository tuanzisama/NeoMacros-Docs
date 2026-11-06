---
title: "Mob"
description: "The mob base: artificial-intelligence toggle and current attack target, shared by every hostile and tameable species."
---

Handle · Wraps: `net.minecraft.world.entity.Mob` · Extends: [`LivingEntity`](livingentity) · Extended by: [`Animal`](animal), [`Bat`](bat), [`Creeper`](creeper), [`Enderman`](enderman), [`Ghast`](ghast), [`Phantom`](phantom), [`Spider`](spider), [`Strider`](strider), [`Villager`](villager), [`WitherBoss`](witherboss), [`Zombie`](zombie)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `noAi` | `boolean` | Whether the mob has no AI (spawned with the NoAI tag). (read-only) |
| `target` | [Entity](entity) | The current attack target, or undefined when idle. (read-only) |

