---
title: "entity:heal"
description: "Payload of the entity heal event."
---

::api-event-header{ event="entity:heal" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`EntityHealEvent`](../types/EntityHealEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `amount` | `number` |  |
| `entity` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} |  |

