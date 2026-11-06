---
title: "PlayerAttackBlockEvent"
description: "Payload of the block attack (start breaking) event; synchronous subscribers may cancel the break."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`player:attackBlock`](../events/player/player-attackblock)
::

| Field | Type | Description |
| --- | --- | --- |
| `block` | [Block](../classes/block) |  |
| `face` | `string` |  |

