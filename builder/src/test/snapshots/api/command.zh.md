---
title: "command"
description: "neo.command：客户端命令注册与派发。命令以声明式注册，经 command.arg 构建带类型的参数槽（int() float() bool() word() string() greedy() player() pos()，另有 optional() 与 default(v)）；处理器收到的上下文 args 携带解析值，raw 保留剩余字符串。"
---

:api-module-header{ category="界面" neo-name="neo.command" since="0.1.0" mc="*" loader="*"}

**Classes**

[`CommandSpec`](classes/CommandSpec.html)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `arg` | :api-type{text='Record<"int" \| "float" \| "bool" \| "word" \| "string" \| "greedy" \| "player" \| "pos", () => CommandArg>' refs='CommandArg=classes/commandarg'} | 带类型的参数槽工厂（command.arg）。 :api-badge{kind="readonly"} |

## Methods

::api-method

### `argKindNames`

参数槽工厂应答的全部槽位类型名（供测试与文档保留）。

**Returns** `Array<string>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `execute`

以玩家身份执行客户端命令（走原版派发器，主线程执行）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `commandLine` | `string` |  | — | — |

**Returns** `Promise<boolean>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="command"}

::

::api-method

### `register`

注册一个客户端命令；spec 携带 name/description/args 槽位与 handler（收到解析后的上下文）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `spec` | :api-type{text='CommandSpec' refs='CommandSpec=classes/commandspec'} |  | — | — |

**Returns** `string` — 命令名（即 的注销键）

:api-badges{ since="0.1.0" mc="*" loader="*" permission="command"}

::

::api-method

### `unregister`

按 返回的命令名注销。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `handleOrName` | `string` |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

