---
title: "Player"
description: "Player handle: the entity read face comes through the entity port (works for remote players too); the local-only extras (hunger, air, gamemode, xp) read through the player port and are undefined for remote players."
---

::api-declaration{ kind="handle" name="Player" wraps="net.minecraft.world.entity.player.Player"}
#extends
[`LivingEntity`](LivingEntity.html)
#extended-by
[`LocalPlayer`](LocalPlayer.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `air` | `number` | The air (breath) value; only the local player carries it. :api-badge{kind="readonly"} |
| `gamemode` | `string` | The gamemode identifier (survival/creative/adventure/ spectator); only the local player carries it. :api-badge{kind="readonly"} |
| `health` | `number` | The health value; the local player reads through the player port (its vitals live on the player snapshot), a remote player falls back to the entity snapshot. :api-badge{kind="readonly"} |
| `hunger` | `number` | The hunger value; only the local player carries it. :api-badge{kind="readonly"} |
| `inventory` | :api-type{text='PlayerInventory' refs='PlayerInventory=classes/playerinventory'} | The player's own inventory; only the local player carries it. :api-badge{kind="readonly"} |
| `saturation` | `number` | The food saturation value; only the local player carries it. :api-badge{kind="readonly"} |
| `xp` | :api-type{text='XpInfo' refs='XpInfo=classes/xpinfo'} | The experience as {level, progress, total}; only the local player carries it. :api-badge{kind="readonly"} |

## Methods

::api-method

### `snapshot`

Returns a point-in-time snapshot copy, or null when the player is not loaded.

**Returns** :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `toJSON`

JSON string; the local player renders through the player view.

**Returns** `string`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

