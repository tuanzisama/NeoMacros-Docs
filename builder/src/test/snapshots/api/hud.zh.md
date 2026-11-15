---
title: "hud"
description: "neo.hud：叠加在原版 HUD 之上的文本层。文本条目跨帧保留，直到移除或模块卸载。"
---

:api-module-header{ category="界面" neo-name="neo.hud" since="0.1.0" mc="*" loader="*"}

## Methods

::api-method

### `addText`

在 HUD 覆盖层上添加一条持久文本。

| 参数 | 类型 | 说明 | 可选 | 默认 |
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

移除一条 HUD 文本。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `id` | `string` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `textIds`

列出所有已注册的 HUD 文本标识。

**Returns** `Array<string>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

