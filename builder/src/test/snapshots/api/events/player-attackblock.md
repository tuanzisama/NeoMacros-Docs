---
title: "player:attackBlock"
description: "Payload of the block attack (start breaking) event; synchronous subscribers may cancel the break."
---

::api-event-header{ event="player:attackBlock" direction="c2s" cancellable="true" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerAttackBlockEvent`](../types/PlayerAttackBlockEvent.html)
::

**Direction**: `c2s` — client-to-server action interception: cancelling suppresses the action.

| Field | Type | Description |
| --- | --- | --- |
| `block` | :api-type{text='Block' refs='Block=classes/block'} |  |
| `face` | `string` |  |

