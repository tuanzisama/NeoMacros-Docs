---
title: "PrimedTnt"
description: "A primed TNT block entity: fuse countdown."
---

::api-declaration{ kind="handle" name="PrimedTnt" wraps="net.minecraft.world.entity.item.PrimedTnt"}
#extends
[`Entity`](entity)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `fuse` | `number` | The remaining fuse ticks before the explosion. :api-badge{kind="readonly"} |

