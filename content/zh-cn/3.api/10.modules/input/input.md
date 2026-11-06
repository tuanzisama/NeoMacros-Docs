---
title: "input"
description: "neo.input 门面：按键绑定注册（显示在原版控制设置中）、原始按键监听、鼠标滚轮事件与按键注入（press/release/hold/set）。"
---

:api-module-header{ category="输入" global="true" neo-name="neo.input" esm-name="@neomacros/input" since="0.1.0" mc="*" loader="*"}

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `keybinds` | `Array<Record<string, unknown>>` | 原版键位表 [{name, key}]，按注册顺序；key 为绑定键的友好名称。 :api-badge{kind="readonly"} |
| `movementState` | `Record<string, boolean>` | 移动键位状态 {forward, backward, left, right, jump, sneak, sprint}。 :api-badge{kind="readonly"} |
| `pressedKeys` | `Array<string>` | 当前按住的原版键位绑定名数组。 :api-badge{kind="readonly"} |

## Methods

### `hold(keyName: string, millis: number)`

按住一个原始按键指定毫秒后松开；Promise 在松开后落定。

**Parameters**

- `keyName` `string`: 
- `millis` `number`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `movement(spec: Record<string, unknown>)`

按住给定的移动键位，直到取消返回的订阅。识别键：forward/backward/left/right/jump/sneak/sprint。

**Parameters**

- `spec` `Record<string, unknown>`: 移动键位表

**Returns** `Subscription`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `onScroll(sink: (arg: number) => void)`

订阅鼠标滚轮事件；正值表示向上滚动。

**Parameters**

- `sink` `(arg: number) => void`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `press(keyName: string)`

注入一个原始按键的按下沿。

**Parameters**

- `keyName` `string`: 

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `registerKeyPress(keyName: string, sink: () => void)`

监听单个按键的按下沿。

**Parameters**

- `keyName` `string`: 
- `sink` `() => void`: 

**Returns** `Subscription` — 订阅句柄，cancel 注销

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `registerKeybind(keyName: string, sink: () => void)`

注册一个持久按键绑定；按键回调在每次按下时触发。绑定会出现在原版控制设置中。

**Parameters**

- `keyName` `string`: vanilla key name, e.g. key.keyboard.k
- `sink` `() => void`: press callback

**Returns** `Subscription` — 订阅句柄，cancel 解绑

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `release(keyName: string)`

注入一个原始按键的松开沿。

**Parameters**

- `keyName` `string`: 

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `set(bindName: string, down: boolean)`

按键位绑定名（如 key.use）注入按下/松开状态。

**Parameters**

- `bindName` `string`: 
- `down` `boolean`: 

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `setBind(bindName: string, keyName: string)`

重新绑定一个原版键位到按键描述（key.keyboard.w 形式）。

**Parameters**

- `bindName` `string`: 键位绑定名
- `keyName` `string`: 按键描述

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `unregister(handle: unknown)`

注销先前注册的按键绑定或按下监听。

**Parameters**

- `handle` `unknown`: 

:api-badges{ since="0.1.0" mc="*" loader="*"}


## Examples

注册会出现在原版控制设置菜单中的按键绑定，并可像玩家真实按键一样注入原始按键输入。

```js
const { input } = neo;

// Persistent keybind, listed in the vanilla controls menu under NeoMacros
let enabled = false;
input.registerKeybind('key.keyboard.k', () => {
  enabled = !enabled; // fires on press; repeats while held
});

// Inject input as if the user pressed it
input.hold('key.keyboard.left.shift', 500); // raw key: hold, then release
input.set('key.sprint', true); // by vanilla bind name
```
