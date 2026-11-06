---
title: "Image"
description: "Immutable raster image: dimensions plus PNG-encoded bytes, produced by screenshots (and later by texture drawing). Instances come only from queries; there is no direct constructor. The byte content is compatible with fs.writeBytes."
---

::api-declaration{ kind="data" name="Image"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `bytes` | `unknown` | The PNG-encoded image content. :api-badge{kind="readonly"} |
| `height` | `number` | The image height in pixels. :api-badge{kind="readonly"} |
| `width` | `number` | The image width in pixels. :api-badge{kind="readonly"} |

## Methods

### `toJSON()`

Plain-object rendering used by JSON.stringify.

**Returns** `Record<string, unknown>`

:api-badges{ since="0.2.0"}

### `toString()`



**Returns** `string`

:api-badges{ since="0.2.0"}

