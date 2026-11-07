---
title: "partial"
description: "Fixture module exercising the generation warning paths: no @zh module body, no class-level @ApiSince, one fully documented member, and one member with neither a translation nor a version annotation."
---

:api-module-header{ category="test" neo-name="neo.partial"}

## Methods

### `tagged()`

Returns a fully documented value.

**Returns** `string` — the tagged value

:api-badges{ since="0.1.0"}

### `untagged(input: string)`

Returns a value whose member lacks translation and version annotation.

**Parameters**

- `input` `string`: the input value

**Returns** `string` — the untouched input

