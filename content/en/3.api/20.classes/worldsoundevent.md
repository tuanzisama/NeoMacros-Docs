---
title: "WorldSoundEvent"
description: "Payload of the sound event; fires when the client plays a sound. High-traffic, so wildcard dispatch skips it by default."
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`world:sound`](../events/world/world-sound)
::

| Field | Type | Description |
| --- | --- | --- |
| `pitch` | `number` |  |
| `pos` | [Pos3D](../classes/pos3d) |  |
| `soundId` | `string` |  |
| `volume` | `number` |  |

