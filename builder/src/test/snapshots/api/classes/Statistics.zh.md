---
title: "Statistics"
description: "活统计句柄：每次读取都重新查询客户端统计计数器。数值按统计类型与条目键控；聚合视图只含非零条目。"
---

::api-declaration{ kind="handle" name="Statistics" wraps="net.minecraft.stats.StatsCounter"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `entries` | :api-type{text='Array<StatisticsEntry>' refs='StatisticsEntry=classes/statisticsentry'} | 每条非零统计的类型化条目（category 为统计类型 id，key 为条目 id）。 :api-badge{kind="readonly"} |
| `snapshot` | `Record<string, number>` | 读取实时非零统计映射（类型id:条目id -> 数值）。 :api-badge{kind="readonly"} |

## Methods

::api-method

### `broken`

玩家已用坏该物品的数量。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `itemId` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `crafted`

玩家已合成该物品的数量。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `itemId` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `custom`

自定义统计值（minecraft:play_time、minecraft:walk_one_cm 等）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `statId` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `dropped`

玩家已丢弃该物品的数量。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `itemId` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `killed`

玩家已击杀该实体的数量。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `entityId` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `killedBy`

该实体击杀玩家的次数。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `entityId` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `mined`

玩家已挖掘该方块的数量。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `blockId` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `pickedUp`

玩家已拾取该物品的数量。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `itemId` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `used`

玩家已使用该物品的次数。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `itemId` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `value`

单条统计值：category 为统计类型 id（minecraft:mined、minecraft:custom 等），key 为条目 id；未知条目读作 0。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `category` | `string` |  | — | — |
| `key` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

