---
title: "EnderDragonEntity"
description: "末影龙：战斗阶段与死亡倒计时。"
---

::api-declaration{ kind="handle" name="EnderDragonEntity" wraps="net.minecraft.world.entity.boss.enderdragon.EnderDragon"}
#extends
[`MobEntity`](MobEntity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `deathTime` | `number` | 死亡动画倒计时；仅濒死时大于零。 :api-badge{kind="readonly"} |
| `phase` | `number` | 龙战同步来的阶段序号。 :api-badge{kind="readonly"} |

