---
title: "EntitySpawnEvent"
---

Extends: [`BaseEvent`](baseevent) · Raised by: [`entity:spawn`](../events/entity/entity-spawn) · Since: 0.1.0 · MC: * · Loader: *

Payload of the entity spawn/despawn edge events derived from per-tick entity tracking. These are distinct from entity:load/unload which track the vanilla entity lifecycle.

| Field | Type | Description |
| --- | --- | --- |
| `entityTypeId` | `string` |  |
| `uuid` | `string` |  |

