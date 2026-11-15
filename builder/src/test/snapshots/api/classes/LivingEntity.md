---
title: "LivingEntity"
description: "Living entity handle: adds the health and equipment read face on top of the entity base."
---

::api-declaration{ kind="handle" name="LivingEntity" wraps="net.minecraft.world.entity.LivingEntity"}
#extends
[`Entity`](Entity.html)
#extended-by
[`Player`](Player.html), [`MobEntity`](MobEntity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `absorption` | `number` | The absorption hearts from golden apples and effects. :api-badge{kind="readonly"} |
| `air` | `number` | The remaining air ticks; 300 max in vanilla water. :api-badge{kind="readonly"} |
| `armorValue` | `number` | The armor points from worn gear (0-20 scale). :api-badge{kind="readonly"} |
| `effects` | :api-type{text='Array<StatusEffectData>' refs='StatusEffectData=classes/statuseffectdata'} | The active status effects as {id, duration, amplifier, infinite} entries; empty once the entity is gone. :api-badge{kind="readonly"} |
| `glowing` | `boolean` | Whether the entity is currently glowing (outline). :api-badge{kind="readonly"} |
| `health` | `number` | The health value; undefined once the entity is gone. :api-badge{kind="readonly"} |
| `heldItem` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The item in the main hand; undefined for an empty hand or a gone entity. :api-badge{kind="readonly"} |
| `hostile` | `boolean` | Whether the entity is hostile (implements the Enemy marker). :api-badge{kind="readonly"} |
| `maxAir` | `number` | The maximum air ticks (300 in vanilla). :api-badge{kind="readonly"} |
| `maxHealth` | `number` | The maximum health value; undefined once the entity is gone. :api-badge{kind="readonly"} |
| `noGravity` | `boolean` | Whether gravity is disabled for the entity. :api-badge{kind="readonly"} |
| `offhandItem` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The item in the off hand; undefined for an empty hand or a gone entity. :api-badge{kind="readonly"} |
| `sleeping` | `boolean` | Whether the entity is sleeping in a bed. |
| `tags` | `Array<string>` | The command tags attached to the entity. :api-badge{kind="readonly"} |
| `useItemRemainingTicks` | `number` | The remaining use ticks while eating, drinking, or blocking. :api-badge{kind="readonly"} |

## Methods

::api-method

### `hasEffect`

Whether a status effect with the given id is active.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `id` | `string` |  | — | — |

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `isHolding`

Whether either hand holds an item of the given id (namespace optional).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `itemId` | `string` |  | — | — |

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

