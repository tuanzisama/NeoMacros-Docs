# BaseEvent

Base class shared by all event payloads; dispatched event instances are frozen subclasses of it.

| Property | Type | Description |
| --- | --- | --- |
| `type` | `string` | Event name, e.g. `chat:receive`. |
| `timestamp` | `number` | Dispatch time in epoch milliseconds. |
| `cancellable` | `boolean` | Whether this event is cancellable. |

## Methods

### `toJSON()`

Plain-object form of the event so `JSON.stringify` renders it directly.

