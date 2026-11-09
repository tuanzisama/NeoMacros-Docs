区分面向服务器与仅本地渲染的输出：say 会发送到服务器，log 与 actionbar 只在本地显示。

```js
const { chat, Component } = neo;

// say() targets the server, as if typed by the player (commands too)
chat.say('/home');

// log() and actionbar() render locally and never reach the server
chat.log('Only you can read this line');
chat.actionbar('Follow the torch markers'); // drawn above the hotbar
```

富文本用 `Component` 构建：链式设样式、`append` 组合子节点，`build()` 产出不可变的 `TextComponent`。

```js
const { chat, Component } = neo;

// 简单样式链
chat.log(new Component('警告：').color('red').bold(true));

// 组树 + 交互：点击回城、悬停提示
const link = new Component('点我回城')
  .clickCommand('/home')
  .hover('传送到主城')
  .underlined();

chat.actionbar(new Component('系统：').color('#ffaa00').append(link));

// 回声场景：把 chat:receive 收到的 TextComponent 拼进新消息
neo.events.on('chat:receive', (e) => {
  if (e.message.plain.includes('刷新')) {
    chat.say(new Component('正在刷新…').append(e.message));
  }
});
```
