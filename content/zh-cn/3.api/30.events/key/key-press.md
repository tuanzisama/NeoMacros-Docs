---
title: "key:press"
---

Payload: [`KeyPressEvent`](../types/keypressevent) · Cancellable · Since: 0.1.0 · MC: * · Loader: *

原始键盘事件载荷；同步订阅可在游戏处理前取消按键。

| Field | Type | Description |
| --- | --- | --- |
| `action` | `string` | 边沿方向：press 或 release |
| `code` | `number` | GLFW 键码 |
| `key` | `string` | 按键名（如 key.keyboard.r） |
| `modifiers` | `Array<string>` | 按下的修饰键列表 |

