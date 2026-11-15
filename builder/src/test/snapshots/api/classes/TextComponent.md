---
title: "TextComponent"
description: "Immutable styled text node: literal content plus optional color, decorations, hover content, click action, and nested children. Built with (build()); instances also arrive as the chat:receive payload. JSON.stringify renders the vanilla component tree ({text, color, …, extra: [...]})."
---

::api-declaration{ kind="data" name="TextComponent"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `children` | :api-type{text='Array<TextComponent>' refs='TextComponent=classes/textcomponent'} | The nested child nodes in order. :api-badge{kind="readonly"} |
| `content` | `string` | The literal content of this node. :api-badge{kind="readonly"} |
| `plain` | `string` | The plain concatenated text of the whole tree. :api-badge{kind="readonly"} |

## Methods

::api-method

### `toJSON`

Vanilla component tree rendering used by JSON.stringify; unset styling keys are omitted.

**Returns** `string`

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

