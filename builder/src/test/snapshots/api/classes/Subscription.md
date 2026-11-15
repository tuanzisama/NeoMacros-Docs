---
title: "Subscription"
description: "Handle of one event subscription; returned to scripts by events.on / once / onSync. Unsubscribing through the handle removes the subscription from dispatch; module dispose iterates its handles the same way."
---

::api-declaration{ kind="handle" name="Subscription"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `active` | `boolean` | Returns whether this subscription still receives events. :api-badge{kind="readonly"} |
| `sync` | `boolean` | Returns whether this is a synchronous-channel subscription. :api-badge{kind="readonly"} |
| `wildcard` | `boolean` | Returns whether the pattern is a wildcard rather than an exact name. :api-badge{kind="readonly"} |

## Methods

::api-method

### `pattern`

Subscription pattern: exact event name or wildcard (domain:*, *).

**Returns** `string`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `unsubscribe`

Unsubscribes; idempotent.

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

