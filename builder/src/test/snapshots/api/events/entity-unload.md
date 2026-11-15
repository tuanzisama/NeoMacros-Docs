---
title: "entity:unload"
description: "Payload of the entity unload event; fires when an entity leaves the client's tracked range."
---

::api-event-header{ event="entity:unload" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`EntityUnloadEvent`](../types/EntityUnloadEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `entity` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} |  |

