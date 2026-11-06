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

### `actionbarText(text: Text)`

在动作条上渲染富文本。

**Parameters**

- `text` [Text](../../classes/text): 富文本

Since: 0.2.0 · MC: * · Loader: *

### `getPlain(text: Text)`

富文本的纯文本拼接。

**Parameters**

- `text` [Text](../../classes/text): 富文本

**Returns** `string`

Since: 0.2.0 · MC: * · Loader: *

### `getWidth(text: string)`

文本在聊天字体下的渲染像素宽度。

**Parameters**

- `text` `string`: 文本

**Returns** `number`

Since: 0.2.0 · MC: * · Loader: *

### `log(message: string)`

仅在本地聊天栏打印消息。

**Parameters**

- `message` `string`: 

Since: 0.1.0 · MC: * · Loader: *

### `logText(text: Text)`

以完整颜色/装饰/悬停/点击渲染在本地聊天栏打印富文本。

**Parameters**

- `text` [Text](../../classes/text): 富文本

Since: 0.2.0 · MC: * · Loader: *

### `say(message: string)`

以玩家身份向服务器发送聊天消息。

**Parameters**

- `message` `string`: 

Since: 0.1.0 · MC: * · Loader: *

### `text(text: string, style: Record<string, unknown>)`

从一个字面分段开始富文本构建器；可选样式（{color, bold, italic, underlined, strikethrough, obfuscated, hoverText, clickCommand, clickUrl}）。

**Parameters**

- `text` `string`: 字面内容
- `style` `Record<string, unknown>`: 初始样式（可省略）

**Returns** [TextBuilder](../../classes/textbuilder)

Since: 0.2.0 · MC: * · Loader: *

### `title(title: string, subtitle: string, fadeIn: number, stay: number, fadeOut: number)`

显示标题（与可选副标题）覆盖层；null 行跳过，非 null 时长（tick）覆盖原版渐变时间。

**Parameters**

- `title` `string`: 主标题（可省）
- `subtitle` `string`: 副标题（可省）
- `fadeIn` `number`: 淡入 tick（可省）
- `stay` `number`: 停留 tick（可省）
- `fadeOut` `number`: 淡出 tick（可省）

Since: 0.2.0 · MC: * · Loader: *

### `toast(title: string, message: string)`

在屏幕角落显示系统 toast 通知。

**Parameters**

- `title` `string`: 标题
- `message` `string`: 正文

Since: 0.2.0 · MC: * · Loader: *


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
