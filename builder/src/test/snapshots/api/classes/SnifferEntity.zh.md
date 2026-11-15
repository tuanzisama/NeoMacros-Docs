---
title: "SnifferEntity"
description: "嗅探兽：嗅探与挖刨状态。"
---

::api-declaration{ kind="handle" name="SnifferEntity" wraps="net.minecraft.world.entity.animal.sniffer.Sniffer"}
#extends
[`AnimalEntity`](AnimalEntity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `searching` | `boolean` | 嗅探兽是否正在嗅探地面寻找种子。 :api-badge{kind="readonly"} |
| `tempted` | `boolean` | 嗅探兽是否被玩家手持物品引诱。 :api-badge{kind="readonly"} |

## Methods

::api-method

### `canSniff`

嗅探兽当前能否嗅探。

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

