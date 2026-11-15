---
title: "entity:heal"
description: "实体恢复时触发。"
---

::api-event-header{ event="entity:heal" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`EntityHealEvent`](../types/EntityHealEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `amount` | `number` | 恢复数值 |
| `entity` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} | 实体快照 |

