---
title: "input"
description: "The neo.input module: keybind registration (surfaced in the vanilla controls menu), raw key press listening, mouse wheel events, and key injection (press/release/hold/set)."
---

:api-module-header{ category="Input" neo-name="neo.input" since="0.1.0" mc="*" loader="*"}

**Classes**

[`InputSubscription`](classes/InputSubscription.html) · [`MovementSpec`](classes/MovementSpec.html)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `keybinds` | :api-type{text='Array<KeybindData>' refs='KeybindData=classes/keybinddata'} | The vanilla keybind rows as [{name, key}] in registration order; key is the friendly label of the bound key. :api-badge{kind="readonly"} |
| `movementState` | `Record<string, boolean>` | The movement bind states as {forward, backward, left, right, jump, sneak, sprint}. :api-badge{kind="readonly"} |
| `pressedKeys` | `Array<string>` | The vanilla keybind names currently held down. :api-badge{kind="readonly"} |

## Methods

::api-method

### `hold`

Holds a raw key down for the given duration, then releases; the promise resolves after the release.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `keyName` | `string` |  | — | — |
| `millis` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `movement`

Holds the given movement binds down until the returned subscription is cancelled. Recognized keys: forward, backward, left, right, jump, sneak, sprint.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `spec` | :api-type{text='MovementSpec' refs='MovementSpec=classes/movementspec'} |  | — | — |

**Returns** :api-type{text='InputSubscription' refs='InputSubscription=classes/inputsubscription'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `onScroll`

Subscribes to mouse wheel scroll; the value is the scroll offset (positive = wheel up).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `sink` | `(arg: number) => void` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `press`

Injects one raw key press (down edge).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `keyName` | `string` |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `registerKeyPress`

Registers a one-shot press listener for a raw key.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `keyName` | `string` |  | — | — |
| `sink` | `() => void` |  | — | — |

**Returns** :api-type{text='InputSubscription' refs='InputSubscription=classes/inputsubscription'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `registerKeybind`

Registers a persistent keybind; the sink fires on every press (repeats while held, per vanilla click semantics). The binding appears in the vanilla controls menu under the NeoMacros category.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `keyName` | `string` | vanilla key name, e.g. key.keyboard.k | — | — |
| `sink` | `() => void` | press callback | — | — |

**Returns** :api-type{text='InputSubscription' refs='InputSubscription=classes/inputsubscription'} — a subscription; cancel unbinds

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `release`

Injects one raw key release (up edge).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `keyName` | `string` |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `set`

Injects one keybind state by bind name (key.use and friends), as if the user pressed the bound input.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `bindName` | `string` |  | — | — |
| `down` | `boolean` |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `setBind`

Rebinds one vanilla keybind to the key description (key.keyboard.w form).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `bindName` | `string` |  | — | — |
| `keyName` | `string` |  | — | — |

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `unregister`

Removes a previously registered keybind or press listener.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `handle` | :api-type{text='InputSubscription' refs='InputSubscription=classes/inputsubscription'} |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

