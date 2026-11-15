---
title: "CommandContext"
description: "The live value handed to a command handler: typed parsed arguments plus the raw remainder string. Rendered to scripts as a flat handle with the args property and the raw property."
---

::api-declaration{ kind="handle" name="CommandContext"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `args` | `Record<string, number | string | boolean>` | The parsed, typed argument map (slot name → value). :api-badge{kind="readonly"} |
| `raw` | `string` | The raw remainder string after the command name. :api-badge{kind="readonly"} |

