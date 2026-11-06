---
title: "Text"
description: "不可变富文本：按序的分段列表，每段携带字面内容与可选颜色、装饰、悬停文本、点击动作。实例只来自 chat.text(...).build()；不提供直接构造器。JSON.stringify 输出分段列表。"
---

::api-declaration{ kind="data" name="Text"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `plain` | `string` | 去样式后的纯文本。 :api-badge{kind="readonly"} |
| `segments` | `Array<TextSegmentData>` | 按序的样式分段。 :api-badge{kind="readonly"} |

## Methods

### `of(plain: string)`

Creates an unstyled single-segment text (compat/tests).

**Parameters**

- `plain` `string`: 

**Returns** [Text](text)

:api-badges{ since="0.2.0"}

### `toJSON()`

JSON.stringify 的纯对象渲染。

**Returns** `Array<Record<string, unknown>>`

:api-badges{ since="0.2.0"}

### `toString()`



**Returns** `string`

:api-badges{ since="0.2.0"}

