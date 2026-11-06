---
title: "chat"
description: "The neo.chat facade: chat output services. Sending targets the connected server; log and actionbar render locally only."
---

Category: UI · Since: 0.1.0 · MC availability: * · Loader availability: * · Exposed as `neo.chat` and `@neomacros/chat`

## Methods

### `actionbar(message: string)`

Renders the message on the action bar above the hotbar.

**Parameters**

- `message` `string`: 

Since: 0.1.0 · MC: * · Loader: *

### `actionbarText(text: Text)`

Renders one styled text on the action bar.

**Parameters**

- `text` [Text](../../classes/text): 富文本

Since: 0.2.0 · MC: * · Loader: *

### `getPlain(text: Text)`

The plain concatenation of a styled text value.

**Parameters**

- `text` [Text](../../classes/text): 富文本

**Returns** `string`

Since: 0.2.0 · MC: * · Loader: *

### `getWidth(text: string)`

The rendered pixel width of the text in the chat font.

**Parameters**

- `text` `string`: 文本

**Returns** `number`

Since: 0.2.0 · MC: * · Loader: *

### `log(message: string)`

Prints the message to the local chat HUD only.

**Parameters**

- `message` `string`: 

Since: 0.1.0 · MC: * · Loader: *

### `logText(text: Text)`

Logs one styled text locally with full color/decoration/hover/click rendering.

**Parameters**

- `text` [Text](../../classes/text): 富文本

Since: 0.2.0 · MC: * · Loader: *

### `say(message: string)`

Sends the message to the connected server as if typed by the player.

**Parameters**

- `message` `string`: 

Since: 0.1.0 · MC: * · Loader: *

### `text(text: string, style: Record<string, unknown>)`

Starts a styled text builder from one literal segment, optionally styled ({color, bold, italic, underlined, strikethrough, obfuscated, hoverText, clickCommand, clickUrl}).

**Parameters**

- `text` `string`: 字面内容
- `style` `Record<string, unknown>`: 初始样式（可省略）

**Returns** [TextBuilder](../../classes/textbuilder)

Since: 0.2.0 · MC: * · Loader: *

### `title(title: string, subtitle: string, fadeIn: number, stay: number, fadeOut: number)`

Shows a title (and optional subtitle) overlay; null lines are skipped and non-null durations override the vanilla fade timings in ticks.

**Parameters**

- `title` `string`: 主标题（可省）
- `subtitle` `string`: 副标题（可省）
- `fadeIn` `number`: 淡入 tick（可省）
- `stay` `number`: 停留 tick（可省）
- `fadeOut` `number`: 淡出 tick（可省）

Since: 0.2.0 · MC: * · Loader: *

### `toast(title: string, message: string)`

Shows a system toast notification in the screen corner.

**Parameters**

- `title` `string`: 标题
- `message` `string`: 正文

Since: 0.2.0 · MC: * · Loader: *


## Examples

Send one message to the server while keeping other output strictly local.

```js
const { chat } = neo;

// say() targets the server, as if typed by the player (commands too)
chat.say('/home');

// log() and actionbar() render locally and never reach the server
chat.log('Only you can read this line');
chat.actionbar('Follow the torch markers'); // drawn above the hotbar
```
