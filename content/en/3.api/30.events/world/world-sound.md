---
title: "world:sound"
description: "Payload of the sound event; fires when the client plays a sound. High-traffic, so wildcard dispatch skips it by default."
---

::api-event-header{ event="world:sound" since="0.1.0" mc="*" loader="*"}
#payload
[`WorldSoundEvent`](../../classes/worldsoundevent)
::

| Field | Type | Description |
| --- | --- | --- |
| `pitch` | `number` |  |
| `pos` | [Pos3D](../classes/pos3d) |  |
| `soundId` | `string` |  |
| `volume` | `number` |  |

