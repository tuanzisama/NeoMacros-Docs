---
title: "EntityUnloadEvent"
description: "实体离开跟踪范围时触发。"
---

::api-type-header{ since="0.1.0" mc="*" loader="*"}
#extends
[`StateEvent`](StateEvent.html)
#raised-by
[`entity:unload`](../events/entity/entity-unload.html)
::

| Field | Type | Description |
| --- | --- | --- |
| `entity` | :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'} | 实体快照 |

