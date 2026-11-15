---
title: "DialogScreen"
description: "The dialog screen (server dialogs and script-shown dialogs)."
---

::api-declaration{ kind="handle" name="DialogScreen" wraps="net.minecraft.client.gui.screens.dialog.DialogScreen"}
#extends
[`Screen`](Screen.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `dialog` | :api-type{text='DialogHandle' refs='DialogHandle=classes/dialoghandle'} | The open dialog handle, or undefined when none. :api-badge{kind="readonly"} |

