---
title: "player:spawn"
description: "Payload of the local player spawning into the world event (first spawn of a world session)."
---

::api-event-header{ event="player:spawn" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerSpawnEvent`](../types/PlayerSpawnEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `player` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} |  |

