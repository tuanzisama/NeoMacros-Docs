---
title: "WorldBossbarEvent"
description: "Payload of the boss bar event; fires for each boss bar operation the client receives: add, remove, updateProgress, updateName, updateStyle, updateProperties. Fields the operation does not carry are null."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`world:bossbar`](../events/world/world-bossbar)
::

| Field | Type | Description |
| --- | --- | --- |
| `action` | `string` |  |
| `name` | `string` |  |
| `progress` | `number` |  |
| `uuid` | `string` |  |

