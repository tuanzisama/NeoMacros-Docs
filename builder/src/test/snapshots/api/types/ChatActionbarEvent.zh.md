---
title: "ChatActionbarEvent"
description: "动作栏显示事件载荷；同步订阅返回 truthy 取消显示，或返回 {text:\"...\"} 替换文本。"
---

::api-type-header{ since="0.4.0" mc="*" loader="*"}
#extends
[`DisplayEvent`](DisplayEvent.html)
#raised-by
[`chat:actionbar`](../events/chat/chat-actionbar.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `source` | `string` | 来源：server（服务器动作栏包）或 local（客户端本地 overlay 提示） |
| `text` | :api-type{text='TextComponent' refs='TextComponent=classes/textcomponent'} | 显示的文本 |

## 同步通道可变面（`MutableChatActionbarEvent`）

`events.onSync` 的处理器收到同一载荷的可变视图：下表成员可写/可调，写入经引擎提交回发布方；未列出的载荷字段保持只读（严格模式写入抛 `TypeError`）。异步通道投递的同一对象是冻结快照，没有这些成员。

| Member | Type | Description |
| --- | --- | --- |
| `text` | :api-type{text='TextComponent' refs='TextComponent=classes/textcomponent'} | 同步通道可改写；提交的值回传发布方。 |
| `cancel()` | `() => void` | 标记事件为已取消；后续优先级的处理器可以用 `cancelled = false` 撤销（last-write-wins）。 |
| `cancelled` | `boolean` | 当前取消状态；可写，最后一次写入生效。 |

