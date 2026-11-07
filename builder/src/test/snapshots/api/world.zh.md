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

### `mark(pos: FixturePos)`

在指定位置放置方块高亮。

**Parameters**

- `pos` [FixturePos](classes/FixturePos.html): the block position to mark

**Returns** `Promise<void>` — 高亮放置完成后兑现的 Promise

:api-badges{ since="0.1.0" mc=">=1.20.6"}

**Example**

```js
world.mark(new Pos3d(1, 64, 1));
```

### `watch(listener: (message: string) => void)`

通过监听器观察聊天消息。

**Parameters**

- `listener` `(message: string) => void`: callback invoked for each message

:api-badges{ since="0.1.0" permission="command" experimental="true"}

