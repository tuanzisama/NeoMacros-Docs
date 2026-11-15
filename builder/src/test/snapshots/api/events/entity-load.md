---
title: "entity:load"
description: "Payload of the entity load event; fires when an entity enters the client's tracked range."
---

::api-event-header{ event="entity:load" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`EntityLoadEvent`](../types/EntityLoadEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `entity` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} |  |

