---
title: "AbstractSchoolingFish"
description: "The schooling fish base: school membership."
---

Handle · Wraps: `net.minecraft.world.entity.animal.fish.AbstractSchoolingFish` · Extends: [`AbstractFish`](abstractfish) · Extended by: [`Cod`](cod), [`Salmon`](salmon)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `follower` | `boolean` | Whether this fish follows a school leader. (read-only) |

## Methods

### `canBeFollowed()`

Whether other fish may follow this one.

**Returns** `boolean`

Since: 0.2.0 · MC: * · Loader: *

### `hasFollowers()`

Whether this fish leads a school with at least one follower.

**Returns** `boolean`

Since: 0.2.0 · MC: * · Loader: *

