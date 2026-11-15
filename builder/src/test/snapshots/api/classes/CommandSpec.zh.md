---
title: "CommandSpec"
description: "一条客户端命令注册规格：命令名、可选描述、可选类型化参数槽与接收解析上下文的处理器。"
---

::api-declaration{ kind="data" name="CommandSpec"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `args` | :api-type{text='Array<CommandArg>' refs='CommandArg=classes/commandarg'} |  :api-badge{kind="readonly"} |
| `description` | `string` |  :api-badge{kind="readonly"} |
| `handler` | :api-type{text='(ctx: CommandContext) => void' refs='CommandContext=classes/commandcontext'} |  :api-badge{kind="readonly"} |
| `name` | `string` |  :api-badge{kind="readonly"} |

