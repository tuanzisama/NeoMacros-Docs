---
title: "EntitySpawnEvent"
description: "Payload of the entity spawn/despawn edge events derived from per-tick entity tracking. These are distinct from entity:load/unload which track the vanilla entity lifecycle."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`entity:spawn`](../events/entity/entity-spawn.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `entityTypeId` | `string` |  |
| `uuid` | `string` |  |

