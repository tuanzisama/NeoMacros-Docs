---
title: "render"
description: "neo.render：基于原版 gizmo 管线的世界坐标图形绘制。图形跨帧保留，直到清空或模块卸载；坐标为世界坐标。"
---

:api-module-header{ category="界面" neo-name="neo.render" since="0.1.0" mc="*" loader="*"}

## Methods

::api-method

### `clearLayer`

清空一个图层上的全部形状。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `layerId` | `string` |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `drawBox`

在世界内绘制线框方块。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `layerId` | `string` | layer identifier; shapes accumulate per layer until | — | — |
| `min` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} | first corner (world coordinates) | — | — |
| `max` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} | opposite corner (world coordinates) | — | — |
| `argbColor` | `number` | ARGB color (e.g. 0xFF00FF00 for opaque green) | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `drawLine`

在世界内绘制线段。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `layerId` | `string` |  | — | — |
| `from` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |
| `to` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |
| `argbColor` | `number` |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `layerIds`

列出当前持有形状的图层。

**Returns** `Array<string>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `surface`

绘制穿过三个及以上顶点的凸面（新节点为自首点的扇面；1.x 节点为多边形描边）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `layerId` | `string` |  | — | — |
| `points` | :api-type{text='Array<Pos3D>' refs='Pos3D=classes/pos3d'} |  | — | — |
| `argbColor` | `number` |  | — | — |

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `traceLine`

绘制一条从本地玩家眼睛到实体的活动连线，实体在场景中时每帧保持指向。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `layerId` | `string` |  | — | — |
| `target` | :api-type{text='Entity' refs='Entity=classes/entity'} |  | — | — |
| `argbColor` | `number` |  | — | — |

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

