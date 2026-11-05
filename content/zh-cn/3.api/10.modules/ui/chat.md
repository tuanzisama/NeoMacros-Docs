---
title: "chat"
description: "neo.chat 门面：聊天输出服务。say 发往所连服务器；log 与 actionbar 仅本地渲染。"
---

Category: 界面 · Since: 0.1.0 · MC availability: * · Loader availability: * · Exposed as `neo.chat` and `@neomacros/chat`

## Methods

### `actionbar(message: string)`

在快捷栏上方的动作条显示消息。

**Parameters**

- `message` `string`: 

Since: 0.1.0 · MC: * · Loader: *

### `log(message: string)`

仅在本地聊天栏打印消息。

**Parameters**

- `message` `string`: 

Since: 0.1.0 · MC: * · Loader: *

### `say(message: string)`

以玩家身份向服务器发送聊天消息。

**Parameters**

- `message` `string`: 

Since: 0.1.0 · MC: * · Loader: *


## Examples

区分面向服务器与仅本地渲染的输出：say 会发送到服务器，log 与 actionbar 只在本地显示。

```js
const { chat } = neo;

// say() targets the server, as if typed by the player (commands too)
chat.say('/home');

// log() and actionbar() render locally and never reach the server
chat.log('Only you can read this line');
chat.actionbar('Follow the torch markers'); // drawn above the hotbar
```
