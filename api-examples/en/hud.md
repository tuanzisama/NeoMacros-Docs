Maintain a persistent score line on the HUD overlay: calling addText again with the same id replaces the entry, so refreshing is just another addText.

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
