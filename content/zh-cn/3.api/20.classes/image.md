---
title: "Image"
description: "不可变位图：尺寸加 PNG 编码字节，由截图（以及后续的纹理绘制）产生。实例只来自查询，不提供直接构造器。字节内容可直接交给 fs.writeBytes。"
---

Data

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `bytes` | `unknown` | PNG 编码的图片内容。 (read-only) |
| `height` | `number` | 图片高度（像素）。 (read-only) |
| `width` | `number` | 图片宽度（像素）。 (read-only) |

## Methods

### `toJSON()`

Plain-object rendering used by JSON.stringify.

**Returns** `Record<string, unknown>`

Since: 0.2.0

### `toString()`



**Returns** `string`

Since: 0.2.0

