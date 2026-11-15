---
title: "entity:damage"
description: "Payload of the entity damage event; fires when a tracked entity takes damage."
---

::api-event-header{ event="entity:damage" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`EntityDamageEvent`](../types/EntityDamageEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `amount` | `number` |  |
| `entity` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} |  |

