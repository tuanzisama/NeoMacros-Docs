---
title: "ContainerInventory"
description: "箱子容器界面：容器行先于玩家行。"
---

::api-declaration{ kind="handle" name="ContainerInventory" wraps="net.minecraft.world.inventory.ChestMenu"}
#extends
[`Inventory`](inventory)
::

## Methods

### `firstEmpty()`

第一个空容器槽位号；全满为 undefined。

**Returns** `number`

:api-badges{ since="0.2.0" mc="*" loader="*"}

