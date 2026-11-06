---
title: "Creaking"
description: "A creaking: heart binding and mobility state."
---

::api-declaration{ kind="handle" name="Creaking" wraps="net.minecraft.world.entity.monster.creaking.Creaking"}
#extends
[`Mob`](mob)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `active` | `boolean` | Whether the creaking is active and stalking. :api-badge{kind="readonly"} |
| `heartBound` | `boolean` | Whether the creaking is bound to a creaking heart. :api-badge{kind="readonly"} |
| `tearingDown` | `boolean` | Whether the creaking is tearing down after its heart broke. :api-badge{kind="readonly"} |

## Methods

### `canMove()`

Whether the creaking may move right now.

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

