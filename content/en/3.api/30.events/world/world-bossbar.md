---
title: "world:bossbar"
description: "Payload of the boss bar event; fires for each boss bar operation the client receives: add, remove, updateProgress, updateName, updateStyle, updateProperties. Fields the operation does not carry are null."
---

::api-event-header{ event="world:bossbar" since="0.1.0" mc="*" loader="*"}
#payload
[`WorldBossbarEvent`](../../classes/worldbossbarevent)
::

| Field | Type | Description |
| --- | --- | --- |
| `action` | `string` |  |
| `name` | `string` |  |
| `progress` | `number` |  |
| `uuid` | `string` |  |

