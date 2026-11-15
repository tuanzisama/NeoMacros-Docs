---
title: "ContainerScreen"
description: "任意容器界面（箱子、熔炉、村民、坐骑等）。"
---

::api-declaration{ kind="handle" name="ContainerScreen" wraps="net.minecraft.client.gui.screens.inventory.AbstractContainerScreen"}
#extends
[`Screen`](Screen.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `container` | :api-type{text='Inventory' refs='Inventory=classes/inventory'} | 打开的容器句柄；不在世界内为 undefined。 :api-badge{kind="readonly"} |

