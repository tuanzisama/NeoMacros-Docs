---
title: "player:interactBlock"
description: "Payload of the block use (right-click) event; synchronous subscribers may cancel the interaction."
---

::api-event-header{ event="player:interactBlock" cancellable="true" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerInteractBlockEvent`](../../classes/playerinteractblockevent)
::

| Field | Type | Description |
| --- | --- | --- |
| `block` | [Block](../classes/block) |  |
| `face` | `string` |  |

