---
title: "Creeper"
description: "苦力怕：充能与点燃状态。原版客户端类未暴露引信倒计时访问器，随物种缺口后随批。"
---

::api-declaration{ kind="handle" name="Creeper" wraps="net.minecraft.world.entity.monster.Creeper"}
#extends
[`Mob`](mob)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `ignited` | `boolean` | 引信是否被打火石点燃。 :api-badge{kind="readonly"} |
| `powered` | `boolean` | 苦力怕是否被闪电充能。 :api-badge{kind="readonly"} |

