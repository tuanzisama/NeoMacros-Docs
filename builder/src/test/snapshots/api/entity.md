---
title: "entity"
description: "The neo.entity module: entity queries over the loaded world. Queries return live handles whose getters read current state in real time; a vanished entity reads back as undefined instead of raising."
---

:api-module-header{ category="World" neo-name="neo.entity" since="0.1.0" mc="*" loader="*"}

**Classes**

[`BoundingBox`](classes/BoundingBox.html) · [`Entity`](classes/Entity.html) · [`ItemEntity`](classes/ItemEntity.html) · [`LivingEntity`](classes/LivingEntity.html) · [`StatusEffectData`](classes/StatusEffectData.html)

## Methods

::api-method

### `inRadius`

Returns handles of every entity within range blocks of the center point.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `x` | `number` |  | — | — |
| `y` | `number` |  | — | — |
| `z` | `number` |  | — | — |
| `range` | `number` |  | — | — |

**Returns** :api-type{text='Array<Entity>' refs='Entity=classes/entity'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `lookup`

Looks up a live entity handle by its UUID; undefined when absent or unloaded.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `uuid` | `string` |  | — | — |

**Returns** :api-type{text='Entity' refs='Entity=classes/entity'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `nearest`

Returns the nearest entity, or undefined when none matches.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `x` | `number` |  | — | — |
| `y` | `number` |  | — | — |
| `z` | `number` |  | — | — |
| `range` | `number` |  | — | — |

**Returns** :api-type{text='Entity' refs='Entity=classes/entity'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `players`

Returns handles of every loaded player in the world.

**Returns** :api-type{text='Array<Entity>' refs='Entity=classes/entity'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

