---
title: "PlayerInteractBlockEvent"
description: "Payload of the block use (right-click) event; synchronous subscribers may cancel the interaction."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`player:interactBlock`](../events/player/player-interactblock)
::

| Field | Type | Description |
| --- | --- | --- |
| `block` | [Block](../classes/block) |  |
| `face` | `string` |  |

