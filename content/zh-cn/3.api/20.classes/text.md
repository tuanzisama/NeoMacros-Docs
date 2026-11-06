---
title: "Text"
description: "不可变富文本：按序的分段列表，每段携带字面内容与可选颜色、装饰、悬停文本、点击动作。实例只来自 chat.text(...).build()；不提供直接构造器。JSON.stringify 输出分段列表。"
---

Data

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `plain` | `string` | 去样式后的纯文本。 (read-only) |
| `segments` | `Array<TextSegmentData>` | 按序的样式分段。 (read-only) |

## Methods

### `of(plain: string)`

Creates an unstyled single-segment text (compat/tests).

**Parameters**

- `plain` `string`: 

**Returns** [Text](text)

Since: 0.2.0

### `toJSON()`

JSON.stringify 的纯对象渲染。

**Returns** `Array<Record<string, unknown>>`

Since: 0.2.0

### `toString()`



**Returns** `string`

Since: 0.2.0

