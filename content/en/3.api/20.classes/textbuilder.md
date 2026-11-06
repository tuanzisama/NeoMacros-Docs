---
title: "TextBuilder"
description: "Mutable builder producing immutable values. Created by chat.text(str, style?); chain the style members then build(). Styles apply to the most recently appended segment."
---

Handle

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `segments` | `Array<TextSegmentData>` | The segments appended so far (read face for compat). (read-only) |

## Methods

### `append(text: string, style: Record<string, unknown>)`

Appends one more segment, optionally styled ({color, bold, ...}).

**Parameters**

- `text` `string`: 
- `style` `Record<string, unknown>`: 

**Returns** [TextBuilder](textbuilder)

Since: 0.2.0 · MC: * · Loader: *

### `append(text: string)`

Appends one unstyled segment.

**Parameters**

- `text` `string`: 

**Returns** [TextBuilder](textbuilder)

Since: 0.2.0 · MC: * · Loader: *

### `bold()`

Applies the bold decoration.

**Returns** [TextBuilder](textbuilder)

Since: 0.2.0 · MC: * · Loader: *

### `build()`

Produces the immutable styled text.

**Returns** [Text](text)

Since: 0.2.0 · MC: * · Loader: *

### `clickCommand(command: string)`

Sets the run-command click action.

**Parameters**

- `command` `string`: 

**Returns** [TextBuilder](textbuilder)

Since: 0.2.0 · MC: * · Loader: *

### `clickUrl(url: string)`

Sets the open-url click action.

**Parameters**

- `url` `string`: 

**Returns** [TextBuilder](textbuilder)

Since: 0.2.0 · MC: * · Loader: *

### `color(color: string)`

Sets the segment color (named color or #rrggbb).

**Parameters**

- `color` `string`: 

**Returns** [TextBuilder](textbuilder)

Since: 0.2.0 · MC: * · Loader: *

### `hover(hoverText: string)`

Sets the show-text hover content.

**Parameters**

- `hoverText` `string`: 

**Returns** [TextBuilder](textbuilder)

Since: 0.2.0 · MC: * · Loader: *

### `italic()`

Applies the italic decoration.

**Returns** [TextBuilder](textbuilder)

Since: 0.2.0 · MC: * · Loader: *

### `obfuscated()`

Applies the obfuscated decoration.

**Returns** [TextBuilder](textbuilder)

Since: 0.2.0 · MC: * · Loader: *

### `strikethrough()`

Applies the strikethrough decoration.

**Returns** [TextBuilder](textbuilder)

Since: 0.2.0 · MC: * · Loader: *

### `underlined()`

Applies the underline decoration.

**Returns** [TextBuilder](textbuilder)

Since: 0.2.0 · MC: * · Loader: *

