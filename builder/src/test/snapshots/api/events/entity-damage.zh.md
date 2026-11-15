---
title: "entity:damage"
description: "实体受伤时触发。"
---

::api-event-header{ event="entity:damage" direction="local" since="0.1.0" mc="*" loader="*"}
#payload
[`EntityDamageEvent`](../types/EntityDamageEvent.html)
::

**方向**：`local` — 客户端本地状态派生：仅观测，不可取消。

| Field | Type | Description |
| --- | --- | --- |
| `amount` | `number` | 伤害数值 |
| `entity` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} | 实体快照 |

