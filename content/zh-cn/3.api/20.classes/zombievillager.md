---
title: "ZombieVillager"
description: "僵尸村民：交易身份与转化状态。"
---

::api-declaration{ kind="handle" name="ZombieVillager" wraps="net.minecraft.world.entity.monster.zombie.ZombieVillager"}
#extends
[`Zombie`](zombie)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `converting` | `boolean` | 僵尸村民是否正在转化回村民。 :api-badge{kind="readonly"} |
| `level` | `number` | 治愈后恢复的交易等级（1-5）。 :api-badge{kind="readonly"} |
| `profession` | `string` | 治愈后恢复的职业标识，如 minecraft:farmer。 :api-badge{kind="readonly"} |
| `variant` | `string` | 治愈后恢复的生物群系变体标识，如 minecraft:plains。 :api-badge{kind="readonly"} |

