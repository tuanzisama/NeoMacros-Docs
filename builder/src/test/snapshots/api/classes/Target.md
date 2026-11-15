---
title: "Target"
description: "Live crosshair pick handle: what the player is currently aiming at, capped by the block and entity interaction ranges; re-read on every access."
---

::api-declaration{ kind="handle" name="Target" wraps="net.minecraft.world.phys.HitResult"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `block` | :api-type{text='Block' refs='Block=classes/block'} | The aimed block handle, or undefined on entity hits or misses. :api-badge{kind="readonly"} |
| `distance` | `number` | The eye-to-hit distance in blocks (0 on a miss). :api-badge{kind="readonly"} |
| `entity` | :api-type{text='Entity' refs='Entity=classes/entity'} | The aimed entity handle, or undefined on block hits or misses. :api-badge{kind="readonly"} |
| `face` | `string` | The aimed block face name (up, north, ...), or undefined on entity hits or misses. :api-badge{kind="readonly"} |
| `hit` | `boolean` | Whether the crosshair is on anything at all. |
| `pos` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} | The exact hit position, or undefined on a miss. :api-badge{kind="readonly"} |

