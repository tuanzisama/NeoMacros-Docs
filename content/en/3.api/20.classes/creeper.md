---
title: "Creeper"
description: "A creeper: charge and ignition state. The fuse countdown accessor is not exposed by the vanilla client classes; it rides the species gap follow-up."
---

::api-declaration{ kind="handle" name="Creeper" wraps="net.minecraft.world.entity.monster.Creeper"}
#extends
[`Mob`](mob)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `ignited` | `boolean` | Whether the fuse has been lit by a flint and steel. :api-badge{kind="readonly"} |
| `powered` | `boolean` | Whether the creeper is charged by a lightning strike. :api-badge{kind="readonly"} |

