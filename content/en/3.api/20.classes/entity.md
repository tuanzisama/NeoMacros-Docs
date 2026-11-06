---
title: "Entity"
description: "Live entity handle: getters re-query the world on every access; a vanished entity reads back as undefined instead of raising."
---

::api-declaration{ kind="handle" name="Entity" wraps="net.minecraft.world.entity.Entity"}
#extended-by
[`ItemEntity`](itementity), [`LivingEntity`](livingentity), [`PrimedTnt`](primedtnt)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `alive` | `boolean` | Whether the entity is loaded and alive (living entities must hold positive health). |
| `blockPos` | [BlockPos](blockpos) | The block-grid position (floored); undefined once the entity is gone. :api-badge{kind="readonly"} |
| `boundingBox` | `Record<string, unknown>` | The axis-aligned bounding box as {min, max} points; undefined once the entity is gone. :api-badge{kind="readonly"} |
| `chunk` | [ChunkPos](chunkpos) | The chunk coordinate containing this entity; undefined once the entity is gone. :api-badge{kind="readonly"} |
| `dimension` | `string` | The dimension identifier the entity lives in; undefined once the entity is gone. :api-badge{kind="readonly"} |
| `direction` | [Pos3D](pos3d) | The view direction unit vector; undefined once the entity is gone. :api-badge{kind="readonly"} |
| `eyeHeight` | `number` | The eye height; undefined once the entity is gone. :api-badge{kind="readonly"} |
| `eyePos` | [Pos3D](pos3d) | The eye position; undefined once the entity is gone. :api-badge{kind="readonly"} |
| `facing` | `string` | The discretized horizontal facing (north/south/east/west); undefined once the entity is gone. :api-badge{kind="readonly"} |
| `gliding` | `boolean` | Whether the entity is gliding with an elytra. |
| `inLava` | `boolean` | Whether the entity is in lava. |
| `inWater` | `boolean` | Whether the entity is in water. |
| `name` | `string` | The display name; undefined once the entity is gone. :api-badge{kind="readonly"} |
| `onFire` | `boolean` | Whether the entity is on fire. |
| `onGround` | `boolean` | Whether the entity stands on the ground. |
| `passengers` | `Array<`[Entity](entity)`>` | The entity poses riding on this one, as entity handles; empty when none. :api-badge{kind="readonly"} |
| `pitch` | `number` | The pitch angle in degrees; undefined once the entity is gone. :api-badge{kind="readonly"} |
| `pos` | [Pos3D](pos3d) | The world position; undefined once the entity is gone. :api-badge{kind="readonly"} |
| `pose` | `string` | The entity pose name (standing, crouching, ...); undefined once the entity is gone. :api-badge{kind="readonly"} |
| `raw` | `unknown` | Escape hatch: the raw host entity object wrapped as a JavaObject proxy. Requires the java permission. |
| `rotation` | [Pos2D](pos2d) | The rotation as Pos2D(yaw, pitch) in degrees; undefined once the entity is gone. :api-badge{kind="readonly"} |
| `sneaking` | `boolean` | Whether the entity is sneaking. |
| `sprinting` | `boolean` | Whether the entity is sprinting. |
| `swimming` | `boolean` | Whether the entity is swimming. |
| `type` | `string` | The entity type identifier, e.g. minecraft:pig; undefined once the entity is gone. :api-badge{kind="readonly"} |
| `uuid` | `string` | The entity UUID string. :api-badge{kind="readonly"} |
| `valid` | `boolean` | Whether the entity is still loaded in the world. |
| `vehicle` | [Entity](entity) | The entity this one is riding, or undefined. :api-badge{kind="readonly"} |
| `velocity` | [Pos3D](pos3d) | The velocity vector; undefined once the entity is gone. :api-badge{kind="readonly"} |
| `yaw` | `number` | The yaw angle in degrees; undefined once the entity is gone. :api-badge{kind="readonly"} |

## Methods

### `distanceTo(target: unknown)`

The distance to another entity or point.

**Parameters**

- `target` `unknown`: 实体句柄或 Pos3D

**Returns** `number`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `snapshot()`

Returns a point-in-time snapshot copy, or null when the entity is gone.

**Returns** [EntitySnapshot](entitysnapshot)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `toJSON()`

JSON form of ; lets JSON.stringify render the handle directly.

**Returns** `Record<string, unknown>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `toString()`

Human-readable form.

**Returns** `string`

