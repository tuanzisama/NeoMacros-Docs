---
title: "command"
description: "neo.command 门面：客户端命令注册与派发。命令以声明式注册，经 command.arg 构建带类型的参数槽（int() float() bool() word() string() greedy() player() pos()，另有 optional() 与 default(v)）；处理器收到的上下文 args 携带解析值，raw 保留剩余字符串。"
---

:api-module-header{ category="界面" global="true" neo-name="neo.command" esm-name="@neomacros/command" since="0.1.0" mc="*" loader="*"}

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `arg` | `CommandArgFactory` | 带类型的参数槽工厂（command.arg）。 :api-badge{kind="readonly"} |

## Methods

### `argKindNames()`

参数槽工厂应答的全部槽位类型名（供测试与文档保留）。

**Returns** `Array<string>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `execute(commandLine: string)`

以玩家身份执行客户端命令（走原版派发器，主线程执行）。

**Parameters**

- `commandLine` `string`: 

**Returns** `Promise<boolean>`

:api-badges{ since="0.1.0" mc="*" loader="*" permission="command"}

### `register(spec: Record<string, unknown>)`

注册一个客户端命令；spec 携带 name/description/args 槽位与 handler（收到解析后的上下文）。

**Parameters**

- `spec` `Record<string, unknown>`: 

**Returns** `unknown` — 注销用的不透明句柄

:api-badges{ since="0.1.0" mc="*" loader="*" permission="command"}

### `unregister(handleOrName: unknown)`

按句柄或命令名注销。

**Parameters**

- `handleOrName` `unknown`: 

:api-badges{ since="0.1.0" mc="*" loader="*"}


## Examples

注册带类型参数槽的客户端命令，并以玩家身份派发另一条命令（register 与 execute 需要 command 权限）。

```js
const { command } = neo;

// register/execute both require the 'command' permission
command.register({
  name: 'mine',
  description: 'Announce a mining route',
  args: {
    ore: command.arg.word(), // required word slot
    seconds: command.arg.int().optional(),
  },
  handler(ctx) {
    // ctx.args: parsed values (ctx.args.ore); ctx.raw: the remainder string
  },
});

await command.execute('/neomacros list'); // dispatch as if typed
```
