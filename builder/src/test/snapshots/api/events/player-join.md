---
title: "player:join"
description: "Payload of the local player joining a world event."
---

::api-event-header{ event="player:join" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerJoinEvent`](../types/PlayerJoinEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `player` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} |  |

