---
title: "AllayEntity"
description: "悦灵：唱片机起舞与持物状态。"
---

::api-declaration{ kind="handle" name="AllayEntity" wraps="net.minecraft.world.entity.animal.allay.Allay"}
#extends
[`MobEntity`](MobEntity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `dancing` | `boolean` | 悦灵是否正随附近唱片机起舞。 :api-badge{kind="readonly"} |
| `flapping` | `boolean` | 悦灵本刻是否正在扇动翅膀。 :api-badge{kind="readonly"} |
| `spinning` | `boolean` | 起舞的悦灵是否正在转圈。 :api-badge{kind="readonly"} |

## Methods

::api-method

### `hasItemInHand`

悦灵当前是否持有物品。

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

