---
title: "Player"
description: ""
---

::api-declaration{ kind="handle" name="Player" wraps="net.minecraft.world.entity.player.Player"}
#extends
[`LivingEntity`](livingentity)
#extended-by
[`LocalPlayer`](localplayer)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `air` | `number` | The air (breath) value; only the local player carries it. :api-badge{kind="readonly"} |
| `gamemode` | `string` | The gamemode identifier (survival/creative/adventure/ spectator); only the local player carries it. :api-badge{kind="readonly"} |
| `health` | `number` | The health value; the local player reads through the player port (its vitals live on the player snapshot), a remote player falls back to the entity snapshot. :api-badge{kind="readonly"} |
| `hunger` | `number` | The hunger value; only the local player carries it. :api-badge{kind="readonly"} |
| `inventory` | [PlayerInventory](playerinventory) | The player's own inventory; only the local player carries it. :api-badge{kind="readonly"} |
| `saturation` | `number` | The food saturation value; only the local player carries it. :api-badge{kind="readonly"} |
| `xp` | `Record<string, unknown>` | The experience as {level, progress, total}; only the local player carries it. :api-badge{kind="readonly"} |

## Methods

### `snapshot()`

Returns a point-in-time snapshot copy, or null when the player is not loaded.

**Returns** [EntitySnapshot](entitysnapshot)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `toJSON()`

JSON form; the local player renders through the player view.

**Returns** `Record<string, unknown>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `toString()`

Human-readable form.

**Returns** `string`

