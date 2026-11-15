---
title: "Statistics"
description: "Live statistics handle: every read re-queries the client stat counters. Values are keyed by stat type and entry; only non-zero entries appear in the aggregate views."
---

::api-declaration{ kind="handle" name="Statistics" wraps="net.minecraft.stats.StatsCounter"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `entries` | :api-type{text='Array<StatisticsEntry>' refs='StatisticsEntry=classes/statisticsentry'} | Every non-zero stat as a typed entry (category is the stat type id, key the entry id). :api-badge{kind="readonly"} |
| `snapshot` | `Record<string, number>` | Reads the live non-zero stat map (statTypeId:valueId -> value). :api-badge{kind="readonly"} |

## Methods

::api-method

### `broken`

How many of the item the player has broken (depleted).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `itemId` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `crafted`

How many of the item the player has crafted.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `itemId` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `custom`

The custom stat value (minecraft:play_time, minecraft:walk_one_cm, ...).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `statId` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `dropped`

How many of the item the player has dropped.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `itemId` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `killed`

How many of the entity the player has killed.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `entityId` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `killedBy`

How many times the entity kind has killed the player.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `entityId` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `mined`

How many of the block the player has mined.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `blockId` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `pickedUp`

How many of the item the player has picked up.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `itemId` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `used`

How many times the player has used the item.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `itemId` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `value`

The value of one stat: category is the stat type id (minecraft:mined, minecraft:custom, ...), key the entry id. Unknown entries read as 0.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `category` | `string` |  | — | — |
| `key` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

