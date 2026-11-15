---
title: "BaseEvent"
description: "Base class shared by all event payloads; dispatched event instances are frozen subclasses of it."
---

| Property | Type | Description |
| --- | --- | --- |
| `type` | `string` | Event name, e.g. `chat:receive`. |
| `direction` | `'c2s' | 's2c' | 'local'` | Traffic direction: upstream interception / incoming display / local state. |
| `timestamp` | `number` | Dispatch time in epoch milliseconds. |
| `cancellable` | `boolean` | Whether this event is cancellable. |

## Methods

::api-method

### `toJSON()`

Plain-object form of the event so `JSON.stringify` renders it directly.

::

