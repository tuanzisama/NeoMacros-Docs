---
title: "EntityHealEvent"
description: "实体恢复时触发。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`entity:heal`](../events/entity/entity-heal.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `amount` | `number` | 恢复数值 |
| `entity` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} | 实体快照 |

