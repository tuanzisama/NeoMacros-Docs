---
title: "entity:unload"
description: "实体离开跟踪范围时触发。"
---

::api-event-header{ event="entity:unload" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`EntityUnloadEvent`](../types/EntityUnloadEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `entity` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} | 实体快照 |

