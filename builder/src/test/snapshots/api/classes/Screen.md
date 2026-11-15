---
title: "Screen"
description: "Base handle for any open screen: the MC class name, the kind label, the title, and Esc-style close."
---

::api-declaration{ kind="handle" name="Screen" wraps="net.minecraft.client.gui.screens.Screen"}
#extended-by
[`BookEditScreen`](BookEditScreen.html), [`BookViewScreen`](BookViewScreen.html), [`ChatScreen`](ChatScreen.html), [`CommandBlockScreen`](CommandBlockScreen.html), [`ConfirmScreen`](ConfirmScreen.html), [`ContainerScreen`](ContainerScreen.html), [`CreativeScreen`](CreativeScreen.html), [`DeathScreen`](DeathScreen.html), [`DialogScreen`](DialogScreen.html), [`DisconnectedScreen`](DisconnectedScreen.html), [`InventoryScreen`](InventoryScreen.html), [`JigsawScreen`](JigsawScreen.html), [`PauseScreen`](PauseScreen.html), [`ProgressScreen`](ProgressScreen.html), [`SignScreen`](SignScreen.html), [`StructureBlockScreen`](StructureBlockScreen.html), [`TitleScreen`](TitleScreen.html), [`WinScreen`](WinScreen.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `kind` | `string` | The screen kind label (e.g. title, chest). :api-badge{kind="readonly"} |
| `name` | `string` | The Minecraft screen class name (e.g. TitleScreen). :api-badge{kind="readonly"} |
| `title` | `string` | The screen title. :api-badge{kind="readonly"} |

## Methods

::api-method

### `close`

Closes the screen (the same path as pressing Esc).

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

