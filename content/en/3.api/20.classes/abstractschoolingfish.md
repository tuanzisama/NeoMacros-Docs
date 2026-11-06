---
title: "AbstractSchoolingFish"
description: "The schooling fish base: school membership."
---

::api-declaration{ kind="handle" name="AbstractSchoolingFish" wraps="net.minecraft.world.entity.animal.fish.AbstractSchoolingFish"}
#extends
[`AbstractFish`](abstractfish)
#extended-by
[`Cod`](cod), [`Salmon`](salmon)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `follower` | `boolean` | Whether this fish follows a school leader. :api-badge{kind="readonly"} |

## Methods

### `canBeFollowed()`

Whether other fish may follow this one.

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `hasFollowers()`

Whether this fish leads a school with at least one follower.

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

