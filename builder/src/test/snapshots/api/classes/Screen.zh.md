---
title: "Screen"
description: "任意打开屏幕的基础句柄：MC 类名、类别标签、标题与 Esc 式关闭。"
---

::api-declaration{ kind="handle" name="Screen" wraps="net.minecraft.client.gui.screens.Screen"}
#extended-by
[`BookEditScreen`](BookEditScreen.html), [`BookViewScreen`](BookViewScreen.html), [`ChatScreen`](ChatScreen.html), [`CommandBlockScreen`](CommandBlockScreen.html), [`ConfirmScreen`](ConfirmScreen.html), [`ContainerScreen`](ContainerScreen.html), [`CreativeScreen`](CreativeScreen.html), [`DeathScreen`](DeathScreen.html), [`DialogScreen`](DialogScreen.html), [`DisconnectedScreen`](DisconnectedScreen.html), [`InventoryScreen`](InventoryScreen.html), [`JigsawScreen`](JigsawScreen.html), [`PauseScreen`](PauseScreen.html), [`ProgressScreen`](ProgressScreen.html), [`SignScreen`](SignScreen.html), [`StructureBlockScreen`](StructureBlockScreen.html), [`TitleScreen`](TitleScreen.html), [`WinScreen`](WinScreen.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `kind` | `string` | 屏幕类别标签（如 title、chest）。 :api-badge{kind="readonly"} |
| `name` | `string` | Minecraft 屏幕类名（如 TitleScreen）。 :api-badge{kind="readonly"} |
| `title` | `string` | 屏幕标题。 :api-badge{kind="readonly"} |

## Methods

::api-method

### `close`

关闭屏幕（与按 Esc 同路）。

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

