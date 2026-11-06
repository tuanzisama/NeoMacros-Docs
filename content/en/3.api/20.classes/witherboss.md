---
title: "WitherBoss"
description: "A wither boss: invulnerable armor phase state."
---

::api-declaration{ kind="handle" name="WitherBoss" wraps="net.minecraft.world.entity.boss.wither.WitherBoss"}
#extends
[`Mob`](mob)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `invulnerableTicks` | `number` | The remaining invulnerability armor ticks (0 after the entry phase). :api-badge{kind="readonly"} |

