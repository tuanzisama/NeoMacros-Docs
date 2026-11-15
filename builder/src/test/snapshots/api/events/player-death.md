---
title: "player:death"
description: "Payload of the local player death event."
---

::api-event-header{ event="player:death" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerDeathEvent`](../types/PlayerDeathEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `player` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} |  |

