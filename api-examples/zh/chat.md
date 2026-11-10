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

`events.onSync` 同步订阅可取消的显示事件：返回 truthy 取消显示，返回普通对象则修改内容（`{ text }` 替换文本；`{ cancel: true }` 显式取消）。

```js
const { events } = neo;

// chat:title 在大标题与副标题显示时触发（用 ev.kind 区分）；chat:actionbar
// 在服务器动作栏包与本地 overlay 提示时触发（ev.source 为 'server' 或 'local'）。
events.onSync('chat:title', (ev) => {
  if (ev.kind === 'title' && ev.text.plain.includes('广告')) {
    return true;                    // 抑制整个显示
  }
  if (ev.kind === 'subtitle') {
    return { text: '由 neomacros 保护' };  // 替换副标题文本
  }
});

events.onSync('chat:actionbar', (ev) => {
  if (ev.source === 'local' && ev.text.plain.includes('不能再喝')) {
    return true;                    // 吞掉本地提示
  }
  return { text: ev.text.plain.toUpperCase() };
});

// screen:signEdit 在告示牌编辑界面即将打开时触发。返回 { lines, closeScreen }
// 替换四行文本并跳过编辑界面——替换后的文本直接提交给服务器（自动签名）。
events.onSync('screen:signEdit', (ev) => {
  if (ev.front) {
    return { lines: [ev.x + ', ' + ev.z, '商店', '', ''], closeScreen: true };
  }
});
```
