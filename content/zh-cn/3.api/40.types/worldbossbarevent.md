# WorldBossbarEvent

Extends: [`BaseEvent`](baseevent) · Raised by: [`world:bossbar`](../events/world/world-bossbar) · Since: 0.1.0 · MC: * · Loader: *

Boss 血条更新时触发。

| Field | Type | Description |
| --- | --- | --- |
| `action` | `string` | 操作类型（add/remove/updateProgress/updateName/updateStyle/updateProperties） |
| `name` | `string` | 血条标题（仅 add/updateName 携带，其余为 null） |
| `progress` | `number` | 血条进度 0.0~1.0（仅 add/updateProgress 携带，其余为 null） |
| `uuid` | `string` | 血条标识 |

