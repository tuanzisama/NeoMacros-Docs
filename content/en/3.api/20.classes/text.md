---
title: "Text"
description: "Immutable styled text: an ordered list of segments, each carrying literal content and optional color, decorations, hover text, and click action. Instances come only from chat.text(...).build(); there is no direct constructor. JSON.stringify renders the segment list."
---

Data

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `plain` | `string` | The plain concatenated text without styling. (read-only) |
| `segments` | `Array<TextSegmentData>` | The styled segments in order. (read-only) |

## Methods

### `of(plain: string)`

Creates an unstyled single-segment text (compat/tests).

**Parameters**

- `plain` `string`: 

**Returns** [Text](text)

Since: 0.2.0

### `toJSON()`

Plain-object rendering used by JSON.stringify.

**Returns** `Array<Record<string, unknown>>`

Since: 0.2.0

### `toString()`



**Returns** `string`

Since: 0.2.0

