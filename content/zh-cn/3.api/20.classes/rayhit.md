---
title: "RayHit"
description: "活射线检测结果：沿射线的首个命中。block 与 entity 互斥，均为活句柄。"
---

::api-declaration{ kind="handle" name="RayHit"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `block` | [Block](block) | 命中方块句柄；命中实体或未命中时为 undefined。 :api-badge{kind="readonly"} |
| `distance` | `number` | 原点到命中点的距离（未命中时为最大距离）。 :api-badge{kind="readonly"} |
| `entity` | [Entity](entity) | 命中实体句柄；命中方块或未命中时为 undefined。 :api-badge{kind="readonly"} |
| `hit` | `boolean` | 射线是否命中了任何目标。 |
| `pos` | [Pos3D](pos3d) | 精确命中位置。 :api-badge{kind="readonly"} |

