---
title: "input"
description: "The neo.input facade: keybind registration (surfaced in the vanilla controls menu), raw key press listening, mouse wheel events, and key injection (press/release/hold/set)."
---

Category: Input · Since: 0.1.0 · MC availability: * · Loader availability: * · Exposed as `neo.input` and `@neomacros/input`

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `keybinds` | `Array<Record<string, unknown>>` | The vanilla keybind rows as [{name, key}] in registration order; key is the friendly label of the bound key. (read-only) |
| `movementState` | `Record<string, boolean>` | The movement bind states as {forward, backward, left, right, jump, sneak, sprint}. (read-only) |
| `pressedKeys` | `Array<string>` | The vanilla keybind names currently held down. (read-only) |

## Methods

### `hold(keyName: string, millis: number)`

Holds a raw key down for the given duration, then releases; the promise resolves after the release.

**Parameters**

- `keyName` `string`: 
- `millis` `number`: 

**Returns** `Promise<void>`

Since: 0.1.0 · MC: * · Loader: *

### `movement(spec: Record<string, unknown>)`

Holds the given movement binds down until the returned subscription is cancelled. Recognized keys: forward, backward, left, right, jump, sneak, sprint.

**Parameters**

- `spec` `Record<string, unknown>`: 移动键位表

**Returns** `Subscription`

Since: 0.2.0 · MC: * · Loader: *

### `onScroll(sink: (arg: number) => void)`

Subscribes to mouse wheel scroll; the value is the scroll offset (positive = wheel up).

**Parameters**

- `sink` `(arg: number) => void`: 

**Returns** `Promise<void>`

Since: 0.1.0 · MC: * · Loader: *

### `press(keyName: string)`

Injects one raw key press (down edge).

**Parameters**

- `keyName` `string`: 

Since: 0.1.0 · MC: * · Loader: *

### `registerKeyPress(keyName: string, sink: () => void)`

Registers a one-shot press listener for a raw key.

**Parameters**

- `keyName` `string`: 
- `sink` `() => void`: 

**Returns** `Subscription`

Since: 0.1.0 · MC: * · Loader: *

### `registerKeybind(keyName: string, sink: () => void)`

Registers a persistent keybind; the sink fires on every press (repeats while held, per vanilla click semantics). The binding appears in the vanilla controls menu under the NeoMacros category.

**Parameters**

- `keyName` `string`: vanilla key name, e.g. key.keyboard.k
- `sink` `() => void`: press callback

**Returns** `Subscription` — a subscription; cancel unbinds

Since: 0.1.0 · MC: * · Loader: *

### `release(keyName: string)`

Injects one raw key release (up edge).

**Parameters**

- `keyName` `string`: 

Since: 0.1.0 · MC: * · Loader: *

### `set(bindName: string, down: boolean)`

Injects one keybind state by bind name (key.use and friends), as if the user pressed the bound input.

**Parameters**

- `bindName` `string`: 
- `down` `boolean`: 

Since: 0.1.0 · MC: * · Loader: *

### `setBind(bindName: string, keyName: string)`

Rebinds one vanilla keybind to the key description (key.keyboard.w form).

**Parameters**

- `bindName` `string`: 键位绑定名
- `keyName` `string`: 按键描述

Since: 0.2.0 · MC: * · Loader: *

### `unregister(handle: unknown)`

Removes a previously registered keybind or press listener.

**Parameters**

- `handle` `unknown`: 

Since: 0.1.0 · MC: * · Loader: *


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
