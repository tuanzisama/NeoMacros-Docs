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
