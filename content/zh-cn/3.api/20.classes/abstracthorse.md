---
title: "AbstractHorse"
description: "马基类：驯服/进食/繁殖状态与鞍上背包容量。"
---

::api-declaration{ kind="handle" name="AbstractHorse" wraps="net.minecraft.world.entity.animal.equine.AbstractHorse"}
#extends
[`Animal`](animal)
#extended-by
[`AbstractChestedHorse`](abstractchestedhorse), [`Camel`](camel), [`Horse`](horse)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `bred` | `boolean` | 驯服后是否已繁殖过。 :api-badge{kind="readonly"} |
| `eating` | `boolean` | 该马是否正在进食。 :api-badge{kind="readonly"} |
| `inventorySize` | `number` | 鞍上背包槽位数。 :api-badge{kind="readonly"} |
| `tamed` | `boolean` | 该马是否已被驯服。 :api-badge{kind="readonly"} |

