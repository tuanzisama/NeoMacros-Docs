---
title: "entity"
description: "neo.entity：对已加载世界的实体查询。查询返回活句柄，属性实时回读当前状态；实体消失后属性回读为 undefined 而不报错。"
---

:api-module-header{ category="世界" neo-name="neo.entity" since="0.1.0" mc="*" loader="*"}

**Classes**

[`BoundingBox`](classes/BoundingBox.html) · [`Entity`](classes/Entity.html) · [`ItemEntity`](classes/ItemEntity.html) · [`LivingEntity`](classes/LivingEntity.html) · [`StatusEffectData`](classes/StatusEffectData.html)

## Methods

::api-method

### `inRadius`

查询中心点半径范围内的全部实体句柄。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `x` | `number` | 中心点坐标 X | — | — |
| `y` | `number` | 中心点坐标 Y | — | — |
| `z` | `number` | 中心点坐标 Z | — | — |
| `range` | `number` | 半径（格） | — | — |

**Returns** :api-type{text='Array<Entity>' refs='Entity=classes/entity'} — 实体句柄数组

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `lookup`

按 UUID 查询实体句柄；不存在或已卸载时为 undefined。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `uuid` | `string` | 实体的 UUID 字符串 | — | — |

**Returns** :api-type{text='Entity' refs='Entity=classes/entity'} — 实体句柄，或 undefined

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `nearest`

返回距离中心最近的实体句柄；无命中时为 undefined。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `x` | `number` | 中心点坐标 X | — | — |
| `y` | `number` | 中心点坐标 Y | — | — |
| `z` | `number` | 中心点坐标 Z | — | — |
| `range` | `number` | 半径（格） | — | — |

**Returns** :api-type{text='Entity' refs='Entity=classes/entity'} — 最近实体句柄或 undefined

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `players`

返回世界中全部玩家的句柄。

**Returns** :api-type{text='Array<Entity>' refs='Entity=classes/entity'} — 玩家句柄数组

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

