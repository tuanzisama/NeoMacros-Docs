---
title: "player:effect"
description: "玩家状态效果变更时触发。"
---

::api-event-header{ event="player:effect" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`PlayerEffectEvent`](../types/PlayerEffectEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `added` | `boolean` | true=新增效果，false=移除效果 |
| `amplifier` | `number` | 效果等级 |
| `effectId` | `string` | 效果标识（如 minecraft:speed） |

