---
title: "Entity"
description: "实体句柄：属性实时回读世界状态；实体消失后属性回读为 undefined 而不报错。"
---

::api-declaration{ kind="handle" name="Entity" wraps="net.minecraft.world.entity.Entity"}
#extended-by
[`ItemEntity`](ItemEntity.html), [`LivingEntity`](LivingEntity.html), [`AreaEffectCloudEntity`](AreaEffectCloudEntity.html), [`FallingBlockEntity`](FallingBlockEntity.html), [`ItemFrameEntity`](ItemFrameEntity.html), [`PrimedTntEntity`](PrimedTntEntity.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `alive` | `boolean` | 实体是否加载且存活（生物需生命值大于零）。 |
| `blockPos` | :api-type{text='BlockPos' refs='BlockPos=classes/blockpos'} | 方块网格坐标（向下取整）；实体消失后为 undefined。 :api-badge{kind="readonly"} |
| `boundingBox` | :api-type{text='BoundingBox' refs='BoundingBox=classes/boundingbox'} | 轴对齐包围盒 {min, max}；实体消失后为 undefined。 :api-badge{kind="readonly"} |
| `chunk` | :api-type{text='ChunkPos' refs='ChunkPos=classes/chunkpos'} | 实体所在区块坐标；实体消失后为 undefined。 :api-badge{kind="readonly"} |
| `dimension` | `string` | 实体所在维度标识；实体消失后为 undefined。 :api-badge{kind="readonly"} |
| `direction` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} | 视线方向单位向量；实体消失后为 undefined。 :api-badge{kind="readonly"} |
| `eyeHeight` | `number` | 眼睛高度；实体消失后为 undefined。 :api-badge{kind="readonly"} |
| `eyePos` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} | 眼睛位置；实体消失后为 undefined。 :api-badge{kind="readonly"} |
| `facing` | `string` | 离散水平朝向（north/south/east/west）；实体消失后为 undefined。 :api-badge{kind="readonly"} |
| `gliding` | `boolean` | 实体是否在鞘翅滑翔。 |
| `inLava` | `boolean` | 实体是否在熔岩中。 |
| `inWater` | `boolean` | 实体是否在水中。 |
| `name` | `string` | 显示名称；实体消失后为 undefined。 :api-badge{kind="readonly"} |
| `onFire` | `boolean` | 实体是否着火。 |
| `onGround` | `boolean` | 实体是否站在地面上。 |
| `passengers` | :api-type{text='Array<Entity>' refs='Entity=classes/entity'} | 骑在本实体上的乘客句柄数组；无乘客时为空数组。 :api-badge{kind="readonly"} |
| `pitch` | `number` | 俯仰角（角度）；实体消失后为 undefined。 :api-badge{kind="readonly"} |
| `pos` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} | 世界坐标位置；实体消失后为 undefined。 :api-badge{kind="readonly"} |
| `pose` | `string` | 实体姿态名（standing、crouching 等）；实体消失后为 undefined。 :api-badge{kind="readonly"} |
| `raw` | :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'} | 穿透口：原始宿主实体对象（需 java 权限）。 |
| `rotation` | :api-type{text='Pos2D' refs='Pos2D=classes/pos2d'} | 朝向 Pos2D(yaw, pitch)（角度）；实体消失后为 undefined。 :api-badge{kind="readonly"} |
| `sneaking` | `boolean` | 实体是否在潜行。 |
| `sprinting` | `boolean` | 实体是否在疾跑。 |
| `swimming` | `boolean` | 实体是否在游泳。 |
| `type` | `string` | 实体类型标识（如 minecraft:pig）；实体消失后为 undefined。 :api-badge{kind="readonly"} |
| `uuid` | `string` | 实体 UUID 字符串。 :api-badge{kind="readonly"} |
| `valid` | `boolean` | 实体是否仍在世界中加载。 |
| `vehicle` | :api-type{text='Entity' refs='Entity=classes/entity'} | 本实体骑乘的载具句柄；无骑乘时为 undefined。 :api-badge{kind="readonly"} |
| `velocity` | :api-type{text='Pos3D' refs='Pos3D=classes/pos3d'} | 速度向量；实体消失后为 undefined。 :api-badge{kind="readonly"} |
| `yaw` | `number` | 偏航角（角度）；实体消失后为 undefined。 :api-badge{kind="readonly"} |

## Methods

::api-method

### `distanceTo`

到另一实体或坐标点的距离。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `target` | :api-type{text='Entity \| Pos3D' refs='Entity=classes/entity,Pos3D=classes/pos3d'} | 实体句柄或 Pos3D | — | — |

**Returns** `number` — 距离（格）

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `snapshot`

返回时点快照；实体消失时返回 null。

**Returns** :api-type{text='EntitySnapshot' refs='EntitySnapshot=classes/entitysnapshot'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `toJSON`

时点快照的 JSON 字符串；JSON.stringify 经此渲染句柄。

**Returns** `string`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

