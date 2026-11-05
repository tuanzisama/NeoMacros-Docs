---
title: "PlayerInteractBlockEvent"
description: "玩家对方块使用物品事件载荷；同步订阅可取消交互。"
---

Extends: [`BaseEvent`](baseevent) · Raised by: [`player:interactBlock`](../events/player/player-interactblock) · Since: 0.1.0 · MC: * · Loader: *

| Field | Type | Description |
| --- | --- | --- |
| `block` | [Block](../classes/block) | 被交互方块的句柄 |
| `face` | `string` | 交互面方向名（如 north） |

