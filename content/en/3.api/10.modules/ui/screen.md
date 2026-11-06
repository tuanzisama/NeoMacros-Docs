---
title: "screen"
description: "The neo.screen facade: metadata about the currently open screen. The script-built GUI surface stays a later-phase design."
---

:api-module-header{ category="UI" global="true" neo-name="neo.screen" esm-name="@neomacros/screen" since="0.2.0" mc="*" loader="*"}

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `opened` | `Record<string, unknown>` | The currently open screen as {title, kind}, or null when no screen is open. kind carries the container screen kind (chest, crafting, ...) for container screens and screen otherwise; the container itself is reachable through player.opened. :api-badge{kind="readonly"} |

