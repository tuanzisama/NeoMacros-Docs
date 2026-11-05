---
title: "world:bossbar"
---

Payload: [`WorldBossbarEvent`](../types/worldbossbarevent) · Since: 0.1.0 · MC: * · Loader: *

Payload of the boss bar event; fires for each boss bar operation the client receives: add, remove, updateProgress, updateName, updateStyle, updateProperties. Fields the operation does not carry are null.

| Field | Type | Description |
| --- | --- | --- |
| `action` | `string` |  |
| `name` | `string` |  |
| `progress` | `number` |  |
| `uuid` | `string` |  |

