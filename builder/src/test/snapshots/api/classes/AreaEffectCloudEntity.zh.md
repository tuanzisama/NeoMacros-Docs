---
title: "AreaEffectCloudEntity"
description: "药水效果云：半径与潜伏状态。"
---

::api-declaration{ kind="handle" name="AreaEffectCloudEntity" wraps="net.minecraft.world.entity.AreaEffectCloud"}
#extends
[`Entity`](Entity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `radius` | `number` | 效果云当前半径（格）。 :api-badge{kind="readonly"} |
| `waitTime` | `number` | 潜伏剩余刻数。 :api-badge{kind="readonly"} |
| `waiting` | `boolean` | 效果云是否处于生效前的潜伏中。 :api-badge{kind="readonly"} |

