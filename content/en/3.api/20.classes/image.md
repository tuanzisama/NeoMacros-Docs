---
title: "Image"
description: "Immutable raster image: dimensions plus PNG-encoded bytes, produced by screenshots (and later by texture drawing). Instances come only from queries; there is no direct constructor. The byte content is compatible with fs.writeBytes."
---

Data

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `bytes` | `unknown` | The PNG-encoded image content. (read-only) |
| `height` | `number` | The image height in pixels. (read-only) |
| `width` | `number` | The image width in pixels. (read-only) |

## Methods

### `toJSON()`

Plain-object rendering used by JSON.stringify.

**Returns** `Record<string, unknown>`

Since: 0.2.0

### `toString()`



**Returns** `string`

Since: 0.2.0

