---
title: "PlayerAttackBlockEvent"
description: "玩家开始破坏方块事件载荷；同步订阅可取消破坏。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`InputEvent`](InputEvent.html)
#raised-by
[`player:attackBlock`](../events/player/player-attackblock.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `block` | :api-type{text='Block' refs='Block=classes/block'} | 被攻击方块的句柄 |
| `face` | `string` | 交互面方向名（如 north） |

## 同步通道可变面（`MutablePlayerAttackBlockEvent`）

`events.onSync` 的处理器收到同一载荷的可变视图：下表成员可写/可调，写入经引擎提交回发布方；未列出的载荷字段保持只读（严格模式写入抛 `TypeError`）。异步通道投递的同一对象是冻结快照，没有这些成员。

| Member | Type | Description |
| --- | --- | --- |
| `cancel()` | `() => void` | 标记事件为已取消；后续优先级的处理器可以用 `cancelled = false` 撤销（last-write-wins）。 |
| `cancelled` | `boolean` | 当前取消状态；可写，最后一次写入生效。 |

