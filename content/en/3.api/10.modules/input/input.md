---
title: "input"
description: "The neo.input facade: keybind registration (surfaced in the vanilla controls menu), raw key press listening, mouse wheel events, and key injection (press/release/hold/set)."
---

:api-module-header{ category="Input" global="true" neo-name="neo.input" esm-name="@neomacros/input" since="0.1.0" mc="*" loader="*"}

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `keybinds` | `Array<Record<string, unknown>>` | The vanilla keybind rows as [{name, key}] in registration order; key is the friendly label of the bound key. :api-badge{kind="readonly"} |
| `movementState` | `Record<string, boolean>` | The movement bind states as {forward, backward, left, right, jump, sneak, sprint}. :api-badge{kind="readonly"} |
| `pressedKeys` | `Array<string>` | The vanilla keybind names currently held down. :api-badge{kind="readonly"} |

## Methods

### `hold(keyName: string, millis: number)`

Holds a raw key down for the given duration, then releases; the promise resolves after the release.

**Parameters**

- `keyName` `string`: 
- `millis` `number`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `movement(spec: Record<string, unknown>)`

Holds the given movement binds down until the returned subscription is cancelled. Recognized keys: forward, backward, left, right, jump, sneak, sprint.

**Parameters**

- `spec` `Record<string, unknown>`: 移动键位表

**Returns** `Subscription`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `onScroll(sink: (arg: number) => void)`

Subscribes to mouse wheel scroll; the value is the scroll offset (positive = wheel up).

**Parameters**

- `sink` `(arg: number) => void`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `press(keyName: string)`

Injects one raw key press (down edge).

**Parameters**

- `keyName` `string`: 

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `registerKeyPress(keyName: string, sink: () => void)`

Registers a one-shot press listener for a raw key.

**Parameters**

- `keyName` `string`: 
- `sink` `() => void`: 

**Returns** `Subscription`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `registerKeybind(keyName: string, sink: () => void)`

Registers a persistent keybind; the sink fires on every press (repeats while held, per vanilla click semantics). The binding appears in the vanilla controls menu under the NeoMacros category.

**Parameters**

- `keyName` `string`: vanilla key name, e.g. key.keyboard.k
- `sink` `() => void`: press callback

**Returns** `Subscription` — a subscription; cancel unbinds

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `release(keyName: string)`

Injects one raw key release (up edge).

**Parameters**

- `keyName` `string`: 

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `set(bindName: string, down: boolean)`

Injects one keybind state by bind name (key.use and friends), as if the user pressed the bound input.

**Parameters**

- `bindName` `string`: 
- `down` `boolean`: 

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `setBind(bindName: string, keyName: string)`

Rebinds one vanilla keybind to the key description (key.keyboard.w form).

**Parameters**

- `bindName` `string`: 键位绑定名
- `keyName` `string`: 按键描述

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `unregister(handle: unknown)`

Removes a previously registered keybind or press listener.

**Parameters**

- `handle` `unknown`: 

:api-badges{ since="0.1.0" mc="*" loader="*"}


## Examples

Register a keybind that appears in the vanilla controls menu, then inject raw key input as if the user pressed it.

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
