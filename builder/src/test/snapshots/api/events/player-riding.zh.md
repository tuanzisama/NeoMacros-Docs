---
title: "player:riding"
description: "乘坐状态变化事件载荷；vehicle 为 null 表示玩家已下车。"
---

::api-event-header{ event="player:riding" direction="local" since="0.2.0" mc="*" loader="*"}
#payload
[`PlayerRidingEvent`](../types/PlayerRidingEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `vehicle` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} | 所乘坐实体的快照；下车时为 null |

