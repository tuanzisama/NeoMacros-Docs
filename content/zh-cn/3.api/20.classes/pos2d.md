---
title: "Pos2D"
description: "不可变二维点：旋转（yaw, pitch）与屏幕坐标。所有运算都返回新实例。"
---

::api-declaration{ kind="data" name="Pos2D"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `x` | `number` | X 坐标。 |
| `y` | `number` | Y 坐标。 |

## Methods

### `add(other: Pos2D)`

加上另一点。

**Parameters**

- `other` [Pos2D](pos2d): 

**Returns** [Pos2D](pos2d)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `compare(other: Pos2D)`

分量字典序比较（先 x 后 y）。

**Parameters**

- `other` [Pos2D](pos2d): 

**Returns** `number`

:api-badges{ since="0.2.0"}

### `construct(args: unknown)`



**Parameters**

- `args` `unknown`: 

**Returns** `unknown`

:api-badges{ since="0.2.0"}

### `equals(other: unknown)`



**Parameters**

- `other` `unknown`: 

**Returns** `boolean`

:api-badges{ since="0.2.0"}

### `hashCode()`



**Returns** `number`

:api-badges{ since="0.2.0"}

### `mul(other: Pos2D)`

与另一点按分量相乘。

**Parameters**

- `other` [Pos2D](pos2d): 

**Returns** [Pos2D](pos2d)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `scale(factor: number)`

按系数缩放。

**Parameters**

- `factor` `number`: 

**Returns** [Pos2D](pos2d)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `sub(other: Pos2D)`

减去另一点。

**Parameters**

- `other` [Pos2D](pos2d): 

**Returns** [Pos2D](pos2d)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `toJSON()`

JSON 形式，使 JSON.stringify 直接输出坐标。

**Returns** `Record<string, unknown>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `toString()`



**Returns** `string`

:api-badges{ since="0.2.0"}

