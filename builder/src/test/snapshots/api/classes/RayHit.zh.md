---
title: "RayHit"
description: "活射线检测结果：沿射线的首个命中。block 与 entity 互斥，均为活句柄。"
---

::api-declaration{ kind="handle" name="RayHit"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `block` | :api-type{text='Block' refs='Block=classes/block'} | 命中方块句柄；命中实体或未命中时为 undefined。 :api-badge{kind="readonly"} |
| `distance` | `number` | 原点到命中点的距离（未命中时为最大距离）。 :api-badge{kind="readonly"} |
| `entity` | :api-type{text='Entity' refs='Entity=classes/entity'} | 命中实体句柄；命中方块或未命中时为 undefined。 :api-badge{kind="readonly"} |
| `face` | `string` | 命中面名（up、north 等）；命中实体或未命中时为 undefined。 :api-badge{kind="readonly"} |
| `hit` | `boolean` | 射线是否命中了任何目标。 |
| `pos` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} | 精确命中位置。 :api-badge{kind="readonly"} |

