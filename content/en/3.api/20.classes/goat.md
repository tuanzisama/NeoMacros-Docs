---
title: "Goat"
description: "A goat: horn state and screaming variant."
---

::api-declaration{ kind="handle" name="Goat" wraps="net.minecraft.world.entity.animal.goat.Goat"}
#extends
[`Animal`](animal)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `screamingGoat` | `boolean` | Whether this is a screaming goat. :api-badge{kind="readonly"} |

## Methods

### `hasLeftHorn()`

Whether the left horn is present.

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `hasRightHorn()`

Whether the right horn is present.

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

