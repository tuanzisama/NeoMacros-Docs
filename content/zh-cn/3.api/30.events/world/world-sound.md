---
title: "world:sound"
description: "声音播放事件；高流量事件，默认不进通配分发。"
---

Payload: [`WorldSoundEvent`](../../classes/worldsoundevent) · Since: 0.1.0 · MC: * · Loader: *

| Field | Type | Description |
| --- | --- | --- |
| `pitch` | `number` | 音调 |
| `pos` | [Pos3D](../classes/pos3d) | 声音源位置（Pos3D 实例） |
| `soundId` | `string` | 声音标识（如 minecraft:block.note_block.pling） |
| `volume` | `number` | 音量 |

