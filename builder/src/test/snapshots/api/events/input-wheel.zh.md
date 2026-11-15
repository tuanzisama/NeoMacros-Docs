---
title: "input:wheel"
description: "鼠标滚轮事件载荷；正值表示向上滚动。"
---

::api-event-header{ event="input:wheel" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`InputWheelEvent`](../types/InputWheelEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `amount` | `number` | 滚动偏移量 |

