---
title: "player:effect"
description: "玩家状态效果变更时触发。"
---

Payload: [`PlayerEffectEvent`](../../classes/playereffectevent) · Since: 0.1.0 · MC: * · Loader: *

| Field | Type | Description |
| --- | --- | --- |
| `added` | `boolean` | true=新增效果，false=移除效果 |
| `amplifier` | `number` | 效果等级 |
| `effectId` | `string` | 效果标识（如 minecraft:speed） |

