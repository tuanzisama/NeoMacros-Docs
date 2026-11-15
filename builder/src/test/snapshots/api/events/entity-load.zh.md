---
title: "entity:load"
description: "实体进入跟踪范围时触发。"
---

::api-event-header{ event="entity:load" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`EntityLoadEvent`](../types/EntityLoadEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `entity` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} | 实体快照 |

