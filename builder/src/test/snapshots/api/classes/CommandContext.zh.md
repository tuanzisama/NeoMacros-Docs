---
title: "CommandContext"
description: "交给命令处理器的实时值：类型化解析参数加原始余串。以扁平句柄呈现给脚本，带 args 与 raw 属性。"
---

::api-declaration{ kind="handle" name="CommandContext"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `args` | `Record<string, number | string | boolean>` | 解析后的类型化参数表（槽名 → 值）。 :api-badge{kind="readonly"} |
| `raw` | `string` | 命令名之后的原始余串。 :api-badge{kind="readonly"} |

