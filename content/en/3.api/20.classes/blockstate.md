---
title: "BlockState"
description: "Immutable block state: the namespaced block identifier plus the vanilla state properties (facing, open, ...)."
---

Data

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `burnable` | `boolean` | Whether lava can ignite the block. (read-only) |
| `hardness` | `number` | The destroy hardness, or undefined for unbreakable blocks. (read-only) |
| `id` | `string` | The namespaced block identifier, e.g. minecraft:chest. (read-only) |
| `isAir` | `boolean` | Whether the state is one of the air blocks. |
| `liquid` | `boolean` | Whether the state is a liquid (water or lava family). |
| `luminance` | `number` | The block light emission level (0-15). (read-only) |
| `opaque` | `boolean` | Whether the state visually occludes the sky and neighbors. (read-only) |
| `props` | `Record<string, string>` | The vanilla state properties. (read-only) |
| `replaceable` | `boolean` | Whether the block can be replaced by placing into it. (read-only) |
| `toolRequired` | `boolean` | Whether the correct tool is required for drops. (read-only) |

## Methods

### `emitsRedstonePower()`

Whether the state emits redstone power.

**Returns** `boolean`

Since: 0.2.0 · MC: * · Loader: *

### `hasBlockEntity()`

Whether the state carries a block entity.

**Returns** `boolean`

Since: 0.2.0 · MC: * · Loader: *

### `hasRandomTicks()`

Whether the state receives random ticks.

**Returns** `boolean`

Since: 0.2.0 · MC: * · Loader: *

### `is(idOrPredicate: string)`

Whether the state's block matches the identifier (namespace optional).

**Parameters**

- `idOrPredicate` `string`: 

**Returns** `boolean`

Since: 0.1.0 · MC: * · Loader: *

### `isProps(props: Record<string, string>)`



**Parameters**

- `props` `Record<string, string>`: 

**Returns** `boolean`

### `toString()`



**Returns** `string`

