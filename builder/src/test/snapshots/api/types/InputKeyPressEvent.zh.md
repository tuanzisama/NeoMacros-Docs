---
title: "InputKeyPressEvent"
description: "原始键盘事件载荷；同步订阅可在游戏处理前取消按键。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`InputEvent`](InputEvent.html)
#raised-by
[`input:keyPress`](../events/input/input-keypress.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `action` | `string` | 边沿方向：press 或 release |
| `code` | `number` | GLFW 键码 |
| `key` | `string` | 按键名（如 key.keyboard.r） |
| `modifiers` | `Array<string>` | 按下的修饰键列表 |

## 同步通道可变面（`MutableInputKeyPressEvent`）

`events.onSync` 的处理器收到同一载荷的可变视图：下表成员可写/可调，写入经引擎提交回发布方；未列出的载荷字段保持只读（严格模式写入抛 `TypeError`）。异步通道投递的同一对象是冻结快照，没有这些成员。

| Member | Type | Description |
| --- | --- | --- |
| `cancel()` | `() => void` | 标记事件为已取消；后续优先级的处理器可以用 `cancelled = false` 撤销（last-write-wins）。 |
| `cancelled` | `boolean` | 当前取消状态；可写，最后一次写入生效。 |

