---
title: "input:keyPress"
description: "原始键盘事件载荷；同步订阅可在游戏处理前取消按键。"
---

::api-event-header{ event="input:keyPress" direction="c2s" cancellable="true" since="0.1.0" mc="*" loader="*"}
#payload
[`InputKeyPressEvent`](../types/InputKeyPressEvent.html)
::

**方向**：`c2s` — 客户端上行动作拦截：取消即抑制该动作（按键/聊天/交互）。

| Field | Type | Description |
| --- | --- | --- |
| `action` | `string` | 边沿方向：press 或 release |
| `code` | `number` | GLFW 键码 |
| `key` | `string` | 按键名（如 key.keyboard.r） |
| `modifiers` | `Array<string>` | 按下的修饰键列表 |

