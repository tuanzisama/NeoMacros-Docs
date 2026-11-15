---
title: "input"
description: "neo.input：按键绑定注册（显示在原版控制设置中）、原始按键监听、鼠标滚轮事件与按键注入（press/release/hold/set）。"
---

:api-module-header{ category="输入" neo-name="neo.input" since="0.1.0" mc="*" loader="*"}

**Classes**

[`InputSubscription`](classes/InputSubscription.html) · [`MovementSpec`](classes/MovementSpec.html)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `keybinds` | :api-type{text='Array<KeybindData>' refs='KeybindData=classes/keybinddata'} | 原版键位表 [{name, key}]，按注册顺序；key 为绑定键的友好名称。 :api-badge{kind="readonly"} |
| `movementState` | `Record<string, boolean>` | 移动键位状态 {forward, backward, left, right, jump, sneak, sprint}。 :api-badge{kind="readonly"} |
| `pressedKeys` | `Array<string>` | 当前按住的原版键位绑定名数组。 :api-badge{kind="readonly"} |

## Methods

::api-method

### `hold`

按住一个原始按键指定毫秒后松开；Promise 在松开后落定。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `keyName` | `string` |  | — | — |
| `millis` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `movement`

按住给定的移动键位，直到取消返回的订阅。识别键：forward/backward/left/right/jump/sneak/sprint。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `spec` | :api-type{text='MovementSpec' refs='MovementSpec=classes/movementspec'} | 移动键位表 | — | — |

**Returns** :api-type{text='InputSubscription' refs='InputSubscription=classes/inputsubscription'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `onScroll`

订阅鼠标滚轮事件；正值表示向上滚动。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `sink` | `(arg: number) => void` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `press`

注入一个原始按键的按下沿。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `keyName` | `string` |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `registerKeyPress`

监听单个按键的按下沿。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `keyName` | `string` |  | — | — |
| `sink` | `() => void` |  | — | — |

**Returns** :api-type{text='InputSubscription' refs='InputSubscription=classes/inputsubscription'} — 订阅句柄，cancel 注销

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `registerKeybind`

注册一个持久按键绑定；按键回调在每次按下时触发。绑定会出现在原版控制设置中。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `keyName` | `string` | 原版按键名，如 key.keyboard.k | — | — |
| `sink` | `() => void` | press callback | — | — |

**Returns** :api-type{text='InputSubscription' refs='InputSubscription=classes/inputsubscription'} — 订阅句柄，cancel 解绑

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `release`

注入一个原始按键的松开沿。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `keyName` | `string` |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `set`

按键位绑定名（如 key.use）注入按下/松开状态。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `bindName` | `string` |  | — | — |
| `down` | `boolean` |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `setBind`

重新绑定一个原版键位到按键描述（key.keyboard.w 形式）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `bindName` | `string` | 键位绑定名 | — | — |
| `keyName` | `string` | 按键描述 | — | — |

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `unregister`

注销先前注册的按键绑定或按下监听。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `handle` | :api-type{text='InputSubscription' refs='InputSubscription=classes/inputsubscription'} |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

