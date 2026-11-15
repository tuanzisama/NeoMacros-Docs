---
title: "screen:signEdit"
description: "告示牌编辑打开事件载荷；同步订阅可取消编辑界面、改写四行文本，或置 closeScreen 跳过编辑器直接提交（可能是替换后的）文本。"
---

::api-event-header{ event="screen:signEdit" direction="s2c" cancellable="true" since="0.4.0" mc="*" loader="*"}
#payload
[`ScreenSignEditEvent`](../types/ScreenSignEditEvent.html)
::

**方向**：`s2c` — 服务器下行显示拦截：取消即抑制显示，白名单字段可本地改写。

| Field | Type | Description |
| --- | --- | --- |
| `closeScreen` | `boolean` | 是否跳过编辑器直接提交（仅同步通道提交时有意义，异步载荷恒为 false）（同步通道可改写） |
| `front` | `boolean` | 是否正面 |
| `lines` | `Array<string>` | 当前四行文本（同步通道可改写） |
| `x` | `number` | 方块 X 坐标 |
| `y` | `number` | 方块 Y 坐标 |
| `z` | `number` | 方块 Z 坐标 |

