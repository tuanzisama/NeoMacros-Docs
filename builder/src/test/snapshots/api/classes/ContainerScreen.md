---
title: "ContainerScreen"
description: "Any container screen (chest, furnace, villager, mount, ...)."
---

::api-declaration{ kind="handle" name="ContainerScreen" wraps="net.minecraft.client.gui.screens.inventory.AbstractContainerScreen"}
#extends
[`Screen`](Screen.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `container` | :api-type{text='Inventory' refs='Inventory=classes/inventory'} | The open container handle, or undefined outside a world. :api-badge{kind="readonly"} |

