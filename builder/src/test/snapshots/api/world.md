---
title: "world"
description: "Fixture module exercising the full annotation set with complete bilingual documentation: class and member annotations, a handle type, a referenced record type, and an overridden parameter type."
---

:api-module-header{ category="test" neo-name="neo.world" since="0.1.0" mc=">=1.20.6"}

**Classes**

[`RegionHandle`](classes/RegionHandle.html) · [`WorldHandle`](classes/WorldHandle.html) · [`WorldInfo`](classes/WorldInfo.html)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `time` | `number` | Returns the world time of day in ticks. :api-badge{kind="readonly"} |

## Methods

::api-method

### `mark`

Marks a block highlight at the given position.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `pos` | :api-type{text='FixturePos' refs='FixturePos=classes/fixturepos'} | the block position to mark | — | — |

**Returns** `Promise<void>` — a promise completing once the highlight is placed

:api-badges{ since="0.1.0" mc=">=1.20.6"}

::

::api-method

### `setTime`

Sets the world time, optionally interpolating over the given ticks.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `ticks` | `number` | the target time in ticks | — | — |
| `interpolation` | `number` | ticks to interpolate over | ✓ | `10` |

:api-badges{ since="0.1.0"}

::

::api-method

### `watch`

Watches chat messages through the given listener.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `listener` | `(message: string) => void` | callback invoked for each message | — | — |

:api-badges{ since="0.1.0" permission="command" experimental="true"}

::

