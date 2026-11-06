---
title: "player:attackBlock"
description: "Payload of the block attack (start breaking) event; synchronous subscribers may cancel the break."
---

::api-event-header{ event="player:attackBlock" cancellable="true" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerAttackBlockEvent`](../../classes/playerattackblockevent)
::

| Field | Type | Description |
| --- | --- | --- |
| `block` | [Block](../classes/block) |  |
| `face` | `string` |  |

