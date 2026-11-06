---
title: "PlayerHealEvent"
description: "Payload of the local player heal event; carries the regained amount and the resulting health."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`player:heal`](../events/player/player-heal)
::

| Field | Type | Description |
| --- | --- | --- |
| `amount` | `number` |  |
| `health` | `number` |  |

