---
title: "KeyPressEvent"
description: "原始键盘事件载荷；同步订阅可在游戏处理前取消按键。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`BaseEvent`](baseevent)
#raised-by
[`key:press`](../events/key/key-press)
::

| Field | Type | Description |
| --- | --- | --- |
| `action` | `string` | 边沿方向：press 或 release |
| `code` | `number` | GLFW 键码 |
| `key` | `string` | 按键名（如 key.keyboard.r） |
| `modifiers` | `Array<string>` | 按下的修饰键列表 |

