---
title: "world:sound"
description: "Payload of the sound event; fires when the client plays a sound. High-traffic, so wildcard dispatch skips it by default."
---

::api-event-header{ event="world:sound" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`WorldSoundEvent`](../types/WorldSoundEvent.html)
::

**Direction**: `local` — client-derived local state; observation only, never cancellable.

| Field | Type | Description |
| --- | --- | --- |
| `pitch` | `number` |  |
| `pos` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} |  |
| `soundId` | `string` |  |
| `volume` | `number` |  |

