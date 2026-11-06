---
title: "TropicalFish"
description: "A tropical fish: shape pattern and colors."
---

::api-declaration{ kind="handle" name="TropicalFish" wraps="net.minecraft.world.entity.animal.fish.TropicalFish"}
#extends
[`AbstractFish`](abstractfish)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `baseColor` | `string` | The base body color identifier, e.g. minecraft:white. :api-badge{kind="readonly"} |
| `pattern` | `string` | The shape pattern identifier, e.g. minecraft:kob. :api-badge{kind="readonly"} |
| `patternColor` | `string` | The pattern highlight color identifier, e.g. minecraft:blue. :api-badge{kind="readonly"} |

