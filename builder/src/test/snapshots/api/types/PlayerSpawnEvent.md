---
title: "PlayerSpawnEvent"
description: "Payload of the local player spawning into the world event (first spawn of a world session)."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`player:spawn`](../events/player/player-spawn.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `player` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} |  |

