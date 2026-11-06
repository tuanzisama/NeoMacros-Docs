---
title: "chat"
description: "The neo.chat facade: chat output services. Sending targets the connected server; log and actionbar render locally only."
---

:api-module-header{ category="UI" global="true" neo-name="neo.chat" esm-name="@neomacros/chat" since="0.1.0" mc="*" loader="*"}

## Methods

### `actionbar(message: string)`

Renders the message on the action bar above the hotbar.

**Parameters**

- `message` `string`: 

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `actionbarText(text: Text)`

Renders one styled text on the action bar.

**Parameters**

- `text` [Text](../../classes/text): 富文本

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `getPlain(text: Text)`

The plain concatenation of a styled text value.

**Parameters**

- `text` [Text](../../classes/text): 富文本

**Returns** `string`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `getWidth(text: string)`

The rendered pixel width of the text in the chat font.

**Parameters**

- `text` `string`: 文本

**Returns** `number`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `log(message: string)`

Prints the message to the local chat HUD only.

**Parameters**

- `message` `string`: 

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `logText(text: Text)`

Logs one styled text locally with full color/decoration/hover/click rendering.

**Parameters**

- `text` [Text](../../classes/text): 富文本

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `say(message: string)`

Sends the message to the connected server as if typed by the player.

**Parameters**

- `message` `string`: 

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `text(text: string, style: Record<string, unknown>)`

Starts a styled text builder from one literal segment, optionally styled ({color, bold, italic, underlined, strikethrough, obfuscated, hoverText, clickCommand, clickUrl}).

**Parameters**

- `text` `string`: 字面内容
- `style` `Record<string, unknown>`: 初始样式（可省略）

**Returns** [TextBuilder](../../classes/textbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `title(title: string, subtitle: string, fadeIn: number, stay: number, fadeOut: number)`

Shows a title (and optional subtitle) overlay; null lines are skipped and non-null durations override the vanilla fade timings in ticks.

**Parameters**

- `title` `string`: 主标题（可省）
- `subtitle` `string`: 副标题（可省）
- `fadeIn` `number`: 淡入 tick（可省）
- `stay` `number`: 停留 tick（可省）
- `fadeOut` `number`: 淡出 tick（可省）

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `toast(title: string, message: string)`

Shows a system toast notification in the screen corner.

**Parameters**

- `title` `string`: 标题
- `message` `string`: 正文

:api-badges{ since="0.2.0" mc="*" loader="*"}


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
