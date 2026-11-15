---
title: "performance"
description: "The neo.performance module: Web-Performance-style macro profiling — a high-resolution monotonic clock anchored at the script's session origin, plus User Timing marks and measures kept in a bounded per-script buffer. Wall-clock timestamps remain the domain of the ES-native Date.now(); this module measures durations. Each script session owns an isolated timeline, so timeOrigin and buffered entries reset when the script reloads."
---

:api-module-header{ category="Core" neo-name="neo.performance" since="0.2.0" mc="*" loader="*"}

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `entries` | :api-type{text='Array<PerformanceEntry>' refs='PerformanceEntry=classes/performanceentry'} | All kept entries in insertion order; the buffer keeps the newest 4096 and evicts older ones. (The MDN getEntries() query lands as a read-only property under the house no-argument-property rule.) :api-badge{kind="readonly"} |
| `timeOrigin` | `number` | Wall-clock time, in milliseconds, at which this script's session started; performance.timeOrigin + performance.now() stays comparable to Date.now(). :api-badge{kind="readonly"} |

## Methods

::api-method

### `clearMarks`

Removes recorded marks — all of them when name is omitted, otherwise only those under that name.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | ✓ | — |

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `clearMeasures`

Removes recorded measures — all of them when name is omitted, otherwise only those under that name.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | ✓ | — |

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `entriesByName`

Kept entries under name, optionally restricted to one entryType ("mark" or "measure").

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |
| `entryType` | `string` |  | ✓ | — |

**Returns** :api-type{text='Array<PerformanceEntry>' refs='PerformanceEntry=classes/performanceentry'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `entriesByType`

Kept entries of one entryType ("mark" or "measure"); unknown types return an empty array.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `entryType` | `string` |  | — | — |

**Returns** :api-type{text='Array<PerformanceEntry>' refs='PerformanceEntry=classes/performanceentry'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `mark`

Records a zero-duration timestamp under name and returns the stored entry; the name must be non-empty.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |

**Returns** :api-type{text='PerformanceEntry' refs='PerformanceEntry=classes/performanceentry'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `measure`

Records a duration under name spanning start to end and returns the stored entry. Each bound accepts a mark name (that mark's timestamp) or a raw now() timestamp; omitted bounds default to the session origin and the current time.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |
| `start` | `string | number` |  | ✓ | — |
| `end` | `string | number` |  | ✓ | — |

**Returns** :api-type{text='PerformanceEntry' refs='PerformanceEntry=classes/performanceentry'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `now`

High-resolution monotonic timestamp in milliseconds (microsecond precision) since this script's session origin; unlike Date.now() it never steps backward with wall-clock changes.

**Returns** `number`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

