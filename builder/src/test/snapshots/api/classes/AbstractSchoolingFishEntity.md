---
title: "AbstractSchoolingFishEntity"
description: "The schooling fish base: school membership."
---

::api-declaration{ kind="handle" name="AbstractSchoolingFishEntity" wraps="net.minecraft.world.entity.animal.fish.AbstractSchoolingFish"}
#extends
[`AbstractFishEntity`](AbstractFishEntity.html)
#extended-by
[`CodEntity`](CodEntity.html), [`SalmonEntity`](SalmonEntity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `follower` | `boolean` | Whether this fish follows a school leader. :api-badge{kind="readonly"} |

## Methods

::api-method

### `canBeFollowed`

Whether other fish may follow this one.

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `hasFollowers`

Whether this fish leads a school with at least one follower.

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

