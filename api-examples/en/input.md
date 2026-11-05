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
