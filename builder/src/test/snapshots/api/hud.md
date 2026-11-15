---
title: "hud"
description: "The neo.hud module: HUD overlay text rendered on top of the vanilla HUD. Text entries persist across frames until removed or the module unloads."
---

:api-module-header{ category="UI" neo-name="neo.hud" since="0.1.0" mc="*" loader="*"}

## Methods

::api-method

### `addText`

Adds a persistent text entry on the HUD overlay.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `id` | `string` | stable text identifier (remove via ) | — | — |
| `text` | `string` | the text content | — | — |
| `x` | `number` | screen x (pixels from left) | — | — |
| `y` | `number` | screen y (pixels from top) | — | — |
| `color` | `number` | ARGB color (e.g. 0xFFFFFFFF for white) | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `removeText`

Removes a previously added text entry.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `id` | `string` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `textIds`

Lists all registered text entry identifiers.

**Returns** `Array<string>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

