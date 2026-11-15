---
title: "player:interactBlock"
description: "Payload of the block use (right-click) event; synchronous subscribers may cancel the interaction."
---

::api-event-header{ event="player:interactBlock" direction="c2s" cancellable="true" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerInteractBlockEvent`](../types/PlayerInteractBlockEvent.html)
::

**Direction**: `c2s` — client-to-server action interception: cancelling suppresses the action.

| Field | Type | Description |
| --- | --- | --- |
| `block` | :api-type{text='Block' refs='Block=classes/block'} |  |
| `face` | `string` |  |

