---
title: "ScreenSignEditEvent"
description: "告示牌编辑打开事件载荷；同步订阅可取消编辑界面、改写四行文本，或置 closeScreen 跳过编辑器直接提交（可能是替换后的）文本。"
---

::api-type-header{ since="0.4.0" mc="*" loader="*"}
#extends
[`DisplayEvent`](DisplayEvent.html)
#raised-by
[`screen:signEdit`](../events/screen/screen-signedit.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `closeScreen` | `boolean` | 是否跳过编辑器直接提交（仅同步通道提交时有意义，异步载荷恒为 false） |
| `front` | `boolean` | 是否正面 |
| `lines` | `Array<string>` | 当前四行文本 |
| `x` | `number` | 方块 X 坐标 |
| `y` | `number` | 方块 Y 坐标 |
| `z` | `number` | 方块 Z 坐标 |

## 同步通道可变面（`MutableScreenSignEditEvent`）

`events.onSync` 的处理器收到同一载荷的可变视图：下表成员可写/可调，写入经引擎提交回发布方；未列出的载荷字段保持只读（严格模式写入抛 `TypeError`）。异步通道投递的同一对象是冻结快照，没有这些成员。

| Member | Type | Description |
| --- | --- | --- |
| `closeScreen` | `boolean` | 同步通道可改写；提交的值回传发布方。 |
| `lines` | `Array<string>` | 同步通道可改写；提交的值回传发布方。 |
| `cancel()` | `() => void` | 标记事件为已取消；后续优先级的处理器可以用 `cancelled = false` 撤销（last-write-wins）。 |
| `cancelled` | `boolean` | 当前取消状态；可写，最后一次写入生效。 |

