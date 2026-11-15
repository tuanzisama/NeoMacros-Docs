---
title: "CommandSpec"
description: "One client command registration spec: the command name, an optional description, optional typed argument slots, and the handler receiving the parsed context."
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

