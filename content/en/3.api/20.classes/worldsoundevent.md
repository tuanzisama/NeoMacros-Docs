---
title: "WorldSoundEvent"
description: "Payload of the sound event; fires when the client plays a sound. High-traffic, so wildcard dispatch skips it by default."
---

Extends: [`BaseEvent`](baseevent) · Raised by: [`world:sound`](../events/world/world-sound) · Since: 0.1.0 · MC: * · Loader: *

| Field | Type | Description |
| --- | --- | --- |
| `pitch` | `number` |  |
| `pos` | [Pos3D](../classes/pos3d) |  |
| `soundId` | `string` |  |
| `volume` | `number` |  |

