---
title: "entity:spawn"
description: "Payload of the entity spawn/despawn edge events derived from per-tick entity tracking. These are distinct from entity:load/unload which track the vanilla entity lifecycle."
---

::api-event-header{ event="entity:spawn" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`EntitySpawnEvent`](../types/EntitySpawnEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `entityTypeId` | `string` |  |
| `uuid` | `string` |  |

