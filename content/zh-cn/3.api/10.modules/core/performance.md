---
title: "performance"
description: "neo.performance 门面：Web Performance 风格的宏性能分析——锚定脚本会话起点的高精度单调时钟，外加保存在每脚本有界缓冲中的 User Timing 标记与测量。墙钟时间仍用 ES 原生 Date.now()；本模块负责耗时测量。每脚本会话持有独立时间线，脚本重载后 timeOrigin 与缓冲随之重置。"
---

:api-module-header{ category="核心" global="true" neo-name="neo.performance" esm-name="@neomacros/performance" since="0.2.0" mc="*" loader="*"}

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `entries` | `Array<`[PerformanceEntry](../../classes/performanceentry)`>` | 按录入顺序返回全部保留条目；缓冲保留最新 4096 条，更早的已被挤出。（MDN 的 getEntries() 按无参状态属性化铁律落地为只读属性。） :api-badge{kind="readonly"} |
| `timeOrigin` | `number` | 本脚本会话启动的墙钟毫秒时刻；performance.timeOrigin + performance.now() 与 Date.now() 可比。 :api-badge{kind="readonly"} |

## Methods

### `clearMarks(name?: string)`

移除已记录的 mark；缺省 name 时全部移除，否则仅移除同名条目。

**Parameters**

- `name` `string`: （可选，缺省按方法说明取默认值）

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `clearMeasures(name?: string)`

移除已记录的 measure；缺省 name 时全部移除，否则仅移除同名条目。

**Parameters**

- `name` `string`: （可选，缺省按方法说明取默认值）

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `entriesByName(name: string, entryType?: string)`

返回名为 name 的保留条目；entryType 可选（"mark" 或 "measure"），用于再过滤。

**Parameters**

- `name` `string`: 
- `entryType` `string`: （可选，缺省按方法说明取默认值）

**Returns** `Array<`[PerformanceEntry](../../classes/performanceentry)`>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `entriesByType(entryType: string)`

返回指定 entryType（"mark" 或 "measure"）的保留条目；未知类型返回空数组。

**Parameters**

- `entryType` `string`: 

**Returns** `Array<`[PerformanceEntry](../../classes/performanceentry)`>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `mark(name: string)`

以 name 记录一个零时长时间戳并返回条目；name 必须非空。

**Parameters**

- `name` `string`: 

**Returns** [PerformanceEntry](../../classes/performanceentry)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `measure(name: string, start?: string | number, end?: string | number)`

以 name 记录一段从 start 到 end 的耗时并返回条目。两端各自接受 mark 名（取其时间戳）或 now() 原始时间戳；缺省时起点为会话原点、终点为当前时刻。

**Parameters**

- `name` `string`: 
- `start` `string | number`: （可选，缺省按方法说明取默认值）
- `end` `string | number`: （可选，缺省按方法说明取默认值）

**Returns** [PerformanceEntry](../../classes/performanceentry)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `now()`

距本脚本会话起点的高精度单调毫秒时间戳（微秒精度）；与 Date.now() 不同，不随墙钟调整回退。

**Returns** `number`

:api-badges{ since="0.2.0" mc="*" loader="*"}


## Examples

热循环的分段计时——measure 两端可传 mark 名或原始时间戳：

```js
const { performance } = neo.performance;

performance.mark("batch");
for (let i = 0; i < 100; i++) processOne();
const batch = performance.measure("batch-x100", "batch");
chat.log(`100 件耗时 ${batch.duration.toFixed(2)}ms`);

// 用两个 mark 的时间戳拆分区间：
performance.mark("split");
const half = performance.measure("first-half", "batch", "split");
```

逐 tick 性能分析也不必手动清理：缓冲是每脚本 4096 条的环形（挤掉最旧），
长会话直接读取即可：

```js
events.on("tick", () => {
  performance.mark("tick-start");
  step();
  performance.measure("step", "tick-start");
});

// 随时读取最近的样本：
const recent = performance.entriesByName("step", "measure").slice(-20);
const avg = recent.reduce((sum, entry) => sum + entry.duration, 0) / recent.length;
chat.log(`step 平均 ${avg.toFixed(3)}ms`);
```
