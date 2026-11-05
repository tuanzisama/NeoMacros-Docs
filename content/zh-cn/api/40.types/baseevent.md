# BaseEvent

所有事件载荷共用的基类；分发到脚本的事件实例都是它的冻结子类实例。

| Property | Type | Description |
| --- | --- | --- |
| `type` | `string` | 事件名，如 `chat:receive`。 |
| `timestamp` | `number` | 事件分发时的毫秒时间戳。 |
| `cancellable` | `boolean` | 本事件是否可取消。 |

## Methods

### `toJSON()`

返回事件的普通对象形式，可直接 `JSON.stringify`。

