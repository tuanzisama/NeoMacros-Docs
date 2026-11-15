---
title: "AbstractSchoolingFishEntity"
description: "群游鱼类基类：鱼群成员关系。"
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
| `follower` | `boolean` | 该鱼是否跟随某个鱼群首领。 :api-badge{kind="readonly"} |

## Methods

::api-method

### `canBeFollowed`

其他鱼是否可跟随该鱼。

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `hasFollowers`

该鱼是否为带领至少一条跟随者的鱼群首领。

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

