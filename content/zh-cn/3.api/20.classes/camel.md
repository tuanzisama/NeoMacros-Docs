---
title: "Camel"
description: "骆驼：冲刺与坐姿，继承马匹背包基类。"
---

::api-declaration{ kind="handle" name="Camel" wraps="net.minecraft.world.entity.animal.camel.Camel"}
#extends
[`AbstractHorse`](abstracthorse)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `dashing` | `boolean` | 骆驼是否正在冲刺。 :api-badge{kind="readonly"} |
| `inPoseTransition` | `boolean` | 骆驼是否正在坐姿切换中。 :api-badge{kind="readonly"} |
| `poseTime` | `number` | 上次坐姿切换的游戏刻时间戳。 :api-badge{kind="readonly"} |
| `sitting` | `boolean` | 骆驼是否正在坐下。 :api-badge{kind="readonly"} |

