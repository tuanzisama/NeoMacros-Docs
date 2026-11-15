---
title: "Target"
description: "活准星选取句柄：玩家当前指向的目标，上限为方块与实体交互距离；每次访问实时回读。"
---

::api-declaration{ kind="handle" name="Target" wraps="net.minecraft.world.phys.HitResult"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `block` | :api-type{text='Block' refs='Block=classes/block'} | 指向的方块句柄；指向实体或未命中时为 undefined。 :api-badge{kind="readonly"} |
| `distance` | `number` | 眼睛到命中点的距离（格）；未命中时为 0。 :api-badge{kind="readonly"} |
| `entity` | :api-type{text='Entity' refs='Entity=classes/entity'} | 指向的实体句柄；指向方块或未命中时为 undefined。 :api-badge{kind="readonly"} |
| `face` | `string` | 指向的方块面名（up、north 等）；指向实体或未命中时为 undefined。 :api-badge{kind="readonly"} |
| `hit` | `boolean` | 准星是否指向了任何目标。 |
| `pos` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} | 精确命中位置；未命中时为 undefined。 :api-badge{kind="readonly"} |

