---
title: "Villager"
description: "村民：职业、交易等级与生物群系变体。"
---

::api-declaration{ kind="handle" name="Villager" wraps="net.minecraft.world.entity.npc.villager.Villager"}
#extends
[`Mob`](mob)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `level` | `number` | 交易等级（1-5）；傻子村民为 undefined。 :api-badge{kind="readonly"} |
| `profession` | `string` | 职业标识，如 minecraft:farmer。 :api-badge{kind="readonly"} |
| `variant` | `string` | 生物群系变体标识，如 minecraft:plains。 :api-badge{kind="readonly"} |

