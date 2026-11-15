---
title: "performance"
description: "neo.performance：Web Performance 风格的宏性能分析——锚定脚本会话起点的高精度单调时钟，外加保存在每脚本有界缓冲中的 User Timing 标记与测量。墙钟时间仍用 ES 原生 Date.now()；本模块负责耗时测量。每脚本会话持有独立时间线，脚本重载后 timeOrigin 与缓冲随之重置。"
---

:api-module-header{ category="核心" neo-name="neo.performance" since="0.2.0" mc="*" loader="*"}

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `entries` | :api-type{text='Array<PerformanceEntry>' refs='PerformanceEntry=classes/performanceentry'} | 按录入顺序返回全部保留条目；缓冲保留最新 4096 条，更早的已被挤出。（MDN 的 getEntries() 按无参状态属性化铁律落地为只读属性。） :api-badge{kind="readonly"} |
| `timeOrigin` | `number` | 本脚本会话启动的墙钟毫秒时刻；performance.timeOrigin + performance.now() 与 Date.now() 可比。 :api-badge{kind="readonly"} |

## Methods

::api-method

### `clearMarks`

移除已记录的 mark；缺省 name 时全部移除，否则仅移除同名条目。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | ✓ | — |

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `clearMeasures`

移除已记录的 measure；缺省 name 时全部移除，否则仅移除同名条目。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | ✓ | — |

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `entriesByName`

返回名为 name 的保留条目；entryType 可选（"mark" 或 "measure"），用于再过滤。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |
| `entryType` | `string` |  | ✓ | — |

**Returns** :api-type{text='Array<PerformanceEntry>' refs='PerformanceEntry=classes/performanceentry'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `entriesByType`

返回指定 entryType（"mark" 或 "measure"）的保留条目；未知类型返回空数组。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `entryType` | `string` |  | — | — |

**Returns** :api-type{text='Array<PerformanceEntry>' refs='PerformanceEntry=classes/performanceentry'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `mark`

以 name 记录一个零时长时间戳并返回条目；name 必须非空。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |

**Returns** :api-type{text='PerformanceEntry' refs='PerformanceEntry=classes/performanceentry'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `measure`

以 name 记录一段从 start 到 end 的耗时并返回条目。两端各自接受 mark 名（取其时间戳）或 now() 原始时间戳；缺省时起点为会话原点、终点为当前时刻。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |
| `start` | `string | number` |  | ✓ | — |
| `end` | `string | number` |  | ✓ | — |

**Returns** :api-type{text='PerformanceEntry' refs='PerformanceEntry=classes/performanceentry'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `now`

距本脚本会话起点的高精度单调毫秒时间戳（微秒精度）；与 Date.now() 不同，不随墙钟调整回退。

**Returns** `number`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

