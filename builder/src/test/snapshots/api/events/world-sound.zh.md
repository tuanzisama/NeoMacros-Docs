---
title: "world:sound"
description: "声音播放事件；高流量事件，默认不进通配分发。"
---

::api-event-header{ event="world:sound" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`WorldSoundEvent`](../types/WorldSoundEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `pitch` | `number` | 音调 |
| `pos` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} | 声音源位置（Pos3D 实例） |
| `soundId` | `string` | 声音标识（如 minecraft:block.note_block.pling） |
| `volume` | `number` | 音量 |

