---
title: "AbstractSchoolingFish"
description: "群游鱼类基类：鱼群成员关系。"
---

Handle · Wraps: `net.minecraft.world.entity.animal.fish.AbstractSchoolingFish` · Extends: [`AbstractFish`](abstractfish) · Extended by: [`Cod`](cod), [`Salmon`](salmon)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `follower` | `boolean` | 该鱼是否跟随某个鱼群首领。 (read-only) |

## Methods

### `canBeFollowed()`

其他鱼是否可跟随该鱼。

**Returns** `boolean`

Since: 0.2.0 · MC: * · Loader: *

### `hasFollowers()`

该鱼是否为带领至少一条跟随者的鱼群首领。

**Returns** `boolean`

Since: 0.2.0 · MC: * · Loader: *

