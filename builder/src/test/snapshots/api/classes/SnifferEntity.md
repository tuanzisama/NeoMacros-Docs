---
title: "SnifferEntity"
description: "A sniffer: sniffing and digging state."
---

::api-declaration{ kind="handle" name="SnifferEntity" wraps="net.minecraft.world.entity.animal.sniffer.Sniffer"}
#extends
[`AnimalEntity`](AnimalEntity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `searching` | `boolean` | Whether the sniffer is searching the ground for seeds. :api-badge{kind="readonly"} |
| `tempted` | `boolean` | Whether the sniffer is tempted by a player-held item. :api-badge{kind="readonly"} |

## Methods

::api-method

### `canSniff`

Whether the sniffer can sniff right now.

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

