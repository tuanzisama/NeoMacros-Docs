---
title: "player:interactBlock"
---

Payload: [`PlayerInteractBlockEvent`](../types/playerinteractblockevent) · Cancellable · Since: 0.1.0 · MC: * · Loader: *

玩家对方块使用物品事件载荷；同步订阅可取消交互。

| Field | Type | Description |
| --- | --- | --- |
| `block` | [Block](../classes/block) | 被交互方块的句柄 |
| `face` | `string` | 交互面方向名（如 north） |

