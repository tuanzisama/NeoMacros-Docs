---
title: "Creaking"
description: "嘎枝：心脏绑定与移动状态。"
---

::api-declaration{ kind="handle" name="Creaking" wraps="net.minecraft.world.entity.monster.creaking.Creaking"}
#extends
[`Mob`](mob)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `active` | `boolean` | 嘎枝是否处于活跃游荡状态。 :api-badge{kind="readonly"} |
| `heartBound` | `boolean` | 嘎枝是否绑定在嘎枝心脏上。 :api-badge{kind="readonly"} |
| `tearingDown` | `boolean` | 嘎枝是否在心脏被破坏后的消散中。 :api-badge{kind="readonly"} |

## Methods

### `canMove()`

嘎枝当前是否可以移动。

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

