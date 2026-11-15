---
title: "DisplayEvent"
description: "服务器下行显示事件（s2c）的中间基类：服务器发来的内容落地前触发，可取消、白名单字段可改写。"
---

::api-type-header{mc="*" loader="*"}
#extends
[`BaseEvent`](BaseEvent.html)
::

| Property | Type | Description |
| --- | --- | --- |
| `direction` | `'s2c'` | 本事件的流向字面量。 |

