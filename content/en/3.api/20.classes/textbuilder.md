---
title: "TextBuilder"
description: "Mutable builder producing immutable values. Created by chat.text(str, style?); chain the style members then build(). Styles apply to the most recently appended segment."
---

::api-declaration{ kind="handle" name="TextBuilder"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `segments` | `Array<TextSegmentData>` | The segments appended so far (read face for compat). :api-badge{kind="readonly"} |

## Methods

### `append(text: string, style: Record<string, unknown>)`

Appends one more segment, optionally styled ({color, bold, ...}).

**Parameters**

- `text` `string`: 
- `style` `Record<string, unknown>`: 

**Returns** [TextBuilder](textbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `append(text: string)`

Appends one unstyled segment.

**Parameters**

- `text` `string`: 

**Returns** [TextBuilder](textbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `bold()`

Applies the bold decoration.

**Returns** [TextBuilder](textbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `build()`

Produces the immutable styled text.

**Returns** [Text](text)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `clickCommand(command: string)`

Sets the run-command click action.

**Parameters**

- `command` `string`: 

**Returns** [TextBuilder](textbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `clickUrl(url: string)`

Sets the open-url click action.

**Parameters**

- `url` `string`: 

**Returns** [TextBuilder](textbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `color(color: string)`

Sets the segment color (named color or #rrggbb).

**Parameters**

- `color` `string`: 

**Returns** [TextBuilder](textbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `hover(hoverText: string)`

Sets the show-text hover content.

**Parameters**

- `hoverText` `string`: 

**Returns** [TextBuilder](textbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `italic()`

Applies the italic decoration.

**Returns** [TextBuilder](textbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `obfuscated()`

Applies the obfuscated decoration.

**Returns** [TextBuilder](textbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `strikethrough()`

Applies the strikethrough decoration.

**Returns** [TextBuilder](textbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `underlined()`

Applies the underline decoration.

**Returns** [TextBuilder](textbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

