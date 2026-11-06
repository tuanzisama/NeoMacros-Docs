---
title: "TextBuilder"
description: "可变构建器，产出不可变 。由 chat.text(str, style?) 创建；链式设置样式后 build()。样式作用于最近一次追加的分段。"
---

Handle

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `segments` | `Array<TextSegmentData>` | 目前已追加的分段（兼容读取面）。 (read-only) |

## Methods

### `append(text: string, style: Record<string, unknown>)`

追加一个分段，可选样式（{color, bold, ...}）。

**Parameters**

- `text` `string`: 
- `style` `Record<string, unknown>`: 

**Returns** [TextBuilder](textbuilder)

Since: 0.2.0 · MC: * · Loader: *

### `append(text: string)`

追加一个无样式分段。

**Parameters**

- `text` `string`: 

**Returns** [TextBuilder](textbuilder)

Since: 0.2.0 · MC: * · Loader: *

### `bold()`

应用粗体装饰。

**Returns** [TextBuilder](textbuilder)

Since: 0.2.0 · MC: * · Loader: *

### `build()`

产出不可变的富文本。

**Returns** [Text](text)

Since: 0.2.0 · MC: * · Loader: *

### `clickCommand(command: string)`

设置运行命令的点击动作。

**Parameters**

- `command` `string`: 

**Returns** [TextBuilder](textbuilder)

Since: 0.2.0 · MC: * · Loader: *

### `clickUrl(url: string)`

设置打开链接的点击动作。

**Parameters**

- `url` `string`: 

**Returns** [TextBuilder](textbuilder)

Since: 0.2.0 · MC: * · Loader: *

### `color(color: string)`

设置分段颜色（命名色或 #rrggbb）。

**Parameters**

- `color` `string`: 

**Returns** [TextBuilder](textbuilder)

Since: 0.2.0 · MC: * · Loader: *

### `hover(hoverText: string)`

设置悬停展示文本。

**Parameters**

- `hoverText` `string`: 

**Returns** [TextBuilder](textbuilder)

Since: 0.2.0 · MC: * · Loader: *

### `italic()`

应用斜体装饰。

**Returns** [TextBuilder](textbuilder)

Since: 0.2.0 · MC: * · Loader: *

### `obfuscated()`

应用乱码装饰。

**Returns** [TextBuilder](textbuilder)

Since: 0.2.0 · MC: * · Loader: *

### `strikethrough()`

应用删除线装饰。

**Returns** [TextBuilder](textbuilder)

Since: 0.2.0 · MC: * · Loader: *

### `underlined()`

应用下划线装饰。

**Returns** [TextBuilder](textbuilder)

Since: 0.2.0 · MC: * · Loader: *

