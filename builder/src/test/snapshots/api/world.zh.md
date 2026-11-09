---
title: "world"
description: "练习完整注解集与完整双语文档的 fixture 模块：类级与方法级注解、句柄类型、签名引用的 record 类型与覆写的参数类型。"
---

:api-module-header{ category="test" neo-name="neo.world" since="0.1.0" mc=">=1.20.6"}

**Classes**

[`RegionHandle`](classes/RegionHandle.html) · [`WorldHandle`](classes/WorldHandle.html) · [`WorldInfo`](classes/WorldInfo.html)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `time` | `number` | 返回当前世界时间（tick）。 :api-badge{kind="readonly"} |

## Methods

::api-method

### `mark`

在指定位置放置方块高亮。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `pos` | :api-type{text='FixturePos' refs='FixturePos=classes/fixturepos'} | 要标记的方块位置 | — | — |

**Returns** `Promise<void>` — 高亮放置完成后兑现的 Promise

:api-badges{ since="0.1.0" mc=">=1.20.6"}

**Example**

```js
world.mark(new Pos3d(1, 64, 1));
```

::

::api-method

### `setTime`

设置世界时间，可选地在给定 tick 数内插值过渡。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `ticks` | `number` | 目标时间（tick） | — | — |
| `interpolation` | `number` | 插值过渡的 tick 数 | ✓ | `10` |

:api-badges{ since="0.1.0"}

::

::api-method

### `watch`

通过监听器观察聊天消息。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `listener` | `(message: string) => void` | 每条消息触发的回调 | — | — |

:api-badges{ since="0.1.0" permission="command" experimental="true"}

::

