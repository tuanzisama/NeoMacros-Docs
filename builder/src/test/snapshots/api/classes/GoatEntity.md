---
title: "GoatEntity"
description: "A goat: horn state and screaming variant."
---

::api-declaration{ kind="handle" name="GoatEntity" wraps="net.minecraft.world.entity.animal.goat.Goat"}
#extends
[`AnimalEntity`](AnimalEntity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `screamingGoat` | `boolean` | Whether this is a screaming goat. :api-badge{kind="readonly"} |

## Methods

::api-method

### `hasLeftHorn`

Whether the left horn is present.

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `hasRightHorn`

Whether the right horn is present.

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

