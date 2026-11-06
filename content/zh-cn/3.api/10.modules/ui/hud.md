---
title: "hud"
description: "neo.hud 门面：叠加在原版 HUD 之上的文本层。文本条目跨帧保留，直到移除或模块卸载。"
---

:api-module-header{ category="界面" global="true" neo-name="neo.hud" esm-name="@neomacros/hud" since="0.1.0" mc="*" loader="*"}

## Methods

### `addText(id: string, text: string, x: number, y: number, color: number)`

在 HUD 覆盖层上添加一条持久文本。

**Parameters**

- `id` `string`: stable text identifier (remove via )
- `text` `string`: the text content
- `x` `number`: screen x (pixels from left)
- `y` `number`: screen y (pixels from top)
- `color` `number`: ARGB color (e.g. 0xFFFFFFFF for white)

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `removeText(id: string)`

移除一条 HUD 文本。

**Parameters**

- `id` `string`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `textIds()`

列出所有已注册的 HUD 文本标识。

**Returns** `Array<string>`

:api-badges{ since="0.1.0" mc="*" loader="*"}


## Examples

在 HUD 覆盖层维护一条常驻记分文本：对同一 id 再次调用 addText 即为刷新该条目。

```js
const { hud } = neo;

// Calling addText again with the same id replaces the entry: refresh freely
hud.addText('score', 'K 12  D 3', 8, 8, 0xFF55FF55); // ARGB, top-left

function updateScore(kills, deaths) {
  hud.addText('score', `K ${kills}  D ${deaths}`, 8, 8, 0xFF55FF55);
}

updateScore(13, 3);

// Inspect the overlay, then take the line down when done
if (hud.textIds().includes('score')) {
  hud.removeText('score');
}
```
