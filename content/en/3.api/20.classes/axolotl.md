---
title: "Axolotl"
description: "An axolotl: variant, playing-dead state, and bucket origin."
---

::api-declaration{ kind="handle" name="Axolotl" wraps="net.minecraft.world.entity.animal.axolotl.Axolotl"}
#extends
[`Animal`](animal)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `fromBucket` | `boolean` | Whether the axolotl came from a bucket. :api-badge{kind="readonly"} |
| `playingDead` | `boolean` | Whether the axolotl is playing dead. :api-badge{kind="readonly"} |
| `variant` | `string` | The variant identifier. :api-badge{kind="readonly"} |

