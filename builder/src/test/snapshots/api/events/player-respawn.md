---
title: "player:respawn"
description: "Payload of the local player respawn event."
---

::api-event-header{ event="player:respawn" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerRespawnEvent`](../types/PlayerRespawnEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `player` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} |  |

