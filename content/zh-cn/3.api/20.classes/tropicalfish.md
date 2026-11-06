---
title: "TropicalFish"
description: "热带鱼：形态花纹与配色。"
---

::api-declaration{ kind="handle" name="TropicalFish" wraps="net.minecraft.world.entity.animal.fish.TropicalFish"}
#extends
[`AbstractFish`](abstractfish)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `baseColor` | `string` | 身体底色标识，如 minecraft:white。 :api-badge{kind="readonly"} |
| `pattern` | `string` | 形态花纹标识，如 minecraft:kob。 :api-badge{kind="readonly"} |
| `patternColor` | `string` | 花纹高光色标识，如 minecraft:blue。 :api-badge{kind="readonly"} |

