---
title: "Pos3D"
description: "不可变三维点/向量：所有运算都返回新实例。位置、方向与偏移的脚本端主力类型；JSON.stringify 直接输出 {\"x\":…,\"y\":…,\"z\":…}。"
---

::api-declaration{ kind="data" name="Pos3D" ctor="new Pos3D(x: number, y: number, z: number)"}
#extended-by
[`BlockPos`](BlockPos.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `x` | `number` | X 坐标。 |
| `y` | `number` | Y 坐标。 |
| `z` | `number` | Z 坐标。 |

## Methods

::api-method

### `add`

加上另一个点/向量。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `cross`

叉积。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `distanceSq`

到另一点的距离平方。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |

**Returns** `number`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `distanceTo`

到另一点的距离。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |

**Returns** `number`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `div`

与另一向量按分量相除。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `dot`

点积。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |

**Returns** `number`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `floor`

将坐标向下取整到方块网格。

**Returns** :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `length`

向量长度。

**Returns** `number`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `lengthSq`

向量长度的平方。

**Returns** `number`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `lerp`

向另一点按 t（0..1）线性插值。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |
| `t` | `number` |  | — | — |

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `mul`

与另一向量按分量相乘。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `normalize`

同方向的单位向量（零向量保持为零）。

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `scale`

按系数缩放。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `factor` | `number` |  | — | — |

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `sub`

减去另一个点/向量。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  | — | — |

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `toJSON`

JSON 形式，使 JSON.stringify 直接输出坐标。

**Returns** `string`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `withX`

返回替换 X 坐标后的副本。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `value` | `number` |  | — | — |

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `withY`

返回替换 Y 坐标后的副本。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `value` | `number` |  | — | — |

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `withZ`

返回替换 Z 坐标后的副本。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `value` | `number` |  | — | — |

**Returns** :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

**Example**

```js
const a = new Pos3D(0, 64, 0);
const b = a.add(new Pos3D(3, 0, 4)); // (3, 64, 4)
const d = b.sub(a).length(); // 5
```

