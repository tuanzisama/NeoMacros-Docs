---
title: "Pos2D"
description: "不可变二维点：旋转（yaw, pitch）与屏幕坐标。所有运算都返回新实例。"
---

::api-declaration{ kind="data" name="Pos2D" ctor="new Pos2D(x: number, y: number)"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `x` | `number` | X 坐标。 |
| `y` | `number` | Y 坐标。 |

## Methods

::api-method

### `add`

加上另一点。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos2D' refs='Pos2D=classes/pos2d'} |  | — | — |

**Returns** :api-type{text='Pos2D' refs='Pos2D=classes/pos2d'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `compare`

分量字典序比较（先 x 后 y）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos2D' refs='Pos2D=classes/pos2d'} |  | — | — |

**Returns** `number`

:api-badges{ since="0.2.0"}

::

::api-method

### `mul`

与另一点按分量相乘。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos2D' refs='Pos2D=classes/pos2d'} |  | — | — |

**Returns** :api-type{text='Pos2D' refs='Pos2D=classes/pos2d'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `scale`

按系数缩放。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `factor` | `number` |  | — | — |

**Returns** :api-type{text='Pos2D' refs='Pos2D=classes/pos2d'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `sub`

减去另一点。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='Pos2D' refs='Pos2D=classes/pos2d'} |  | — | — |

**Returns** :api-type{text='Pos2D' refs='Pos2D=classes/pos2d'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `toJSON`

JSON 形式，使 JSON.stringify 直接输出坐标。

**Returns** `string`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

**Example**

```js
const rot = new Pos2D(90, 0); // yaw 90°, pitch 0°
const steeper = rot.add(new Pos2D(0, 45)); // pitch 抬到 45°
```

