---
title: "BlockState"
description: "Immutable block state: the namespaced block identifier plus the vanilla state properties (facing, open, ...)."
---

::api-declaration{ kind="data" name="BlockState"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `burnable` | `boolean` | Whether lava can ignite the block. :api-badge{kind="readonly"} |
| `fluid` | `string` | The contained fluid identifier, or null when dry. :api-badge{kind="readonly"} |
| `hardness` | `number` | The destroy hardness, or undefined for unbreakable blocks. :api-badge{kind="readonly"} |
| `id` | `string` | The namespaced block identifier, e.g. minecraft:chest. :api-badge{kind="readonly"} |
| `isAir` | `boolean` | Whether the state is one of the air blocks. |
| `liquid` | `boolean` | Whether the state is a liquid (water or lava family). |
| `luminance` | `number` | The block light emission level (0-15). :api-badge{kind="readonly"} |
| `opaque` | `boolean` | Whether the state visually occludes the sky and neighbors. :api-badge{kind="readonly"} |
| `pistonBehaviour` | `string` | The piston push behaviour (lowercase, e.g. normal). :api-badge{kind="readonly"} |
| `props` | `Record<string, string>` | The vanilla state properties. :api-badge{kind="readonly"} |
| `replaceable` | `boolean` | Whether the block can be replaced by placing into it. :api-badge{kind="readonly"} |
| `suffocating` | `boolean` | Whether this state suffocates entities standing inside it. :api-badge{kind="readonly"} |
| `toolRequired` | `boolean` | Whether the correct tool is required for drops. :api-badge{kind="readonly"} |

## Methods

::api-method

### `emitsRedstonePower`

Whether the state emits redstone power.

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `hasBlockEntity`

Whether the state carries a block entity.

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `hasRandomTicks`

Whether the state receives random ticks.

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `is`

Whether the state's block matches the identifier (namespace optional).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `idOrPredicate` | `string` |  | — | — |

**Returns** `boolean`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `isProps`



| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `props` | `Record<string, string>` |  | — | — |

**Returns** `boolean`

::

