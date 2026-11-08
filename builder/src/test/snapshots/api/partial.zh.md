---
title: "partial"
description: "Fixture module exercising the generation warning paths: no @zh module body, no class-level @ApiSince, one fully documented member, and one member with neither a translation nor a version annotation."
---

:api-module-header{ category="test" neo-name="neo.partial"}

## Methods

::api-method

### `tagged`

返回完整文档化的值。

**Returns** `string` — 标注过的值

:api-badges{ since="0.1.0"}

::

::api-method

### `untagged`

Returns a value whose member lacks translation and version annotation.

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `input` | `string` | the input value | — | — |

**Returns** `string` — the untouched input

::

