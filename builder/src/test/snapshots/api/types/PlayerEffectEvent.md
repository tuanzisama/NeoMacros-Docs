---
title: "PlayerEffectEvent"
description: "Payload of the status effect change event; fires when the local player gains or loses a status effect."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`player:effect`](../events/player/player-effect.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `added` | `boolean` |  |
| `amplifier` | `number` |  |
| `effectId` | `string` |  |

