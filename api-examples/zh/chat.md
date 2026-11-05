区分面向服务器与仅本地渲染的输出：say 会发送到服务器，log 与 actionbar 只在本地显示。

```js
const { chat } = neo;

// say() targets the server, as if typed by the player (commands too)
chat.say('/home');

// log() and actionbar() render locally and never reach the server
chat.log('Only you can read this line');
chat.actionbar('Follow the torch markers'); // drawn above the hotbar
```
