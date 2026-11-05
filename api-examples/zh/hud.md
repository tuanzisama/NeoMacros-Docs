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
