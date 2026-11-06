---
title: "AbstractSchoolingFish"
description: "群游鱼类基类：鱼群成员关系。"
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
| `follower` | `boolean` | 该鱼是否跟随某个鱼群首领。 :api-badge{kind="readonly"} |

## Methods

### `canBeFollowed()`

其他鱼是否可跟随该鱼。

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `hasFollowers()`

该鱼是否为带领至少一条跟随者的鱼群首领。

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

