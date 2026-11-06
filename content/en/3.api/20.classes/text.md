---
title: "Text"
description: "Immutable styled text: an ordered list of segments, each carrying literal content and optional color, decorations, hover text, and click action. Instances come only from chat.text(...).build(); there is no direct constructor. JSON.stringify renders the segment list."
---

::api-declaration{ kind="data" name="Text"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `plain` | `string` | The plain concatenated text without styling. :api-badge{kind="readonly"} |
| `segments` | `Array<TextSegmentData>` | The styled segments in order. :api-badge{kind="readonly"} |

## Methods

### `of(plain: string)`

Creates an unstyled single-segment text (compat/tests).

**Parameters**

- `plain` `string`: 

**Returns** [Text](text)

:api-badges{ since="0.2.0"}

### `toJSON()`

Plain-object rendering used by JSON.stringify.

**Returns** `Array<Record<string, unknown>>`

:api-badges{ since="0.2.0"}

### `toString()`



**Returns** `string`

:api-badges{ since="0.2.0"}

