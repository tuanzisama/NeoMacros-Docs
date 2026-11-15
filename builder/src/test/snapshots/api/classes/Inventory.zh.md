---
title: "Inventory"
description: "物品栏句柄：槽位读取每次都重新查询物品栏端口；操作在主线程派发，处理完成后落定。"
---

::api-declaration{ kind="handle" name="Inventory"}
#extended-by
[`AnvilInventory`](AnvilInventory.html), [`BeaconInventory`](BeaconInventory.html), [`BrewingStandInventory`](BrewingStandInventory.html), [`CartographyInventory`](CartographyInventory.html), [`ContainerInventory`](ContainerInventory.html), [`CraftingInventory`](CraftingInventory.html), [`EnchantInventory`](EnchantInventory.html), [`FurnaceInventory`](FurnaceInventory.html), [`GrindstoneInventory`](GrindstoneInventory.html), [`HorseInventory`](HorseInventory.html), [`PlayerInventory`](PlayerInventory.html), [`SmithingInventory`](SmithingInventory.html), [`StonecutterInventory`](StonecutterInventory.html), [`VillagerInventory`](VillagerInventory.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `carried` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | 光标抓取中的物品堆；无则 undefined。 :api-badge{kind="readonly"} |
| `itemCount` | `Record<string, number>` | 物品栏内按物品 id 聚合的总数量。 :api-badge{kind="readonly"} |
| `items` | :api-type{text='Record<number, ItemStack>' refs='ItemStack=classes/itemstack'} | 全部非空物品，按槽位号键控；每个值都是完整的 ItemStack 句柄，与 slot() 返回值同类型。 |
| `kind` | `string` | 物品栏种类（player、chest、crafting 等）。 :api-badge{kind="readonly"} |
| `selectedHotbarSlot` | `number` | 当前选中的快捷栏槽位（0-8）；无则 undefined。 :api-badge{kind="readonly"} |
| `size` | `number` | 物品栏槽位总数。 :api-badge{kind="readonly"} |
| `title` | `string` | 物品栏显示标题。 :api-badge{kind="readonly"} |

## Methods

::api-method

### `click`

点击槽位（button 0 = 左键，1 = 右键，2 = 中键克隆（创造）；shift = 快速移动）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `slot` | `number` |  | — | — |
| `button` | `number` |  | — | — |
| `shift` | `boolean` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `close`

关闭物品栏界面。

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `closeAndDrop`

丢弃光标上的堆（如有）并关闭当前界面。

**Returns** `Promise<void>`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `contains`

物品栏中是否存在指定 id 的物品（命名空间可省略）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `itemId` | `string` |  | — | — |

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `countOf`

统计某物品 id 的数量。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `item` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `dragClick`

将光标堆拖拽分发到给定槽位（button 0 = 均分，其他 = 贪心填满）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `slots` | `Array<number>` | 菜单槽位号数组 | — | — |
| `button` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `drop`

丢弃槽位中的物品（all = 全部）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `slot` | `number` |  | — | — |
| `all` | `boolean` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `findAll`

持有指定物品 id 的槽位号列表（按序）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `itemId` | `string` |  | — | — |

**Returns** `Array<number>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `findFreeHotbarSlot`

第一个空的快捷栏槽位（0-8）；全满为 undefined。读取玩家自身物品栏，无需打开界面。

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `findFreeInventorySlot`

主背包（9-35）第一个空槽；全满为 undefined。读取玩家自身物品栏，无需打开界面。

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `findId`

第一个持有指定物品 id 的槽位；无则 undefined。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `itemId` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `grabAll`

拿起槽位物品，再把所有可合并堆聚拢到光标（双击聚拢语义）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `slot` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `quickAll`

快速移动所有可与指定槽位物品合并的槽（同一背后容器）。返回移动的物品总数。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `slot` | `number` |  | — | — |
| `button` | `number` |  | ✓ | — |

**Returns** `Promise<number>`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `quickMove`

将槽位物品快速移动到另一侧物品栏。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `slot` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `setSelectedHotbarSlot`

将快捷栏选中位切到指定槽（0-8）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `index` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `slot`

读取指定槽位的物品；越界或空槽为 undefined。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `index` | `number` |  | — | — |

**Returns** :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `split`

将光标上的堆拆放到两个空槽：第一槽放 1 个，其余放第二槽。两槽需为空且不同；违例由服务端裁决。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `slot1` | `number` |  | — | — |
| `slot2` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `swapHotbar`

将容器槽位与快捷栏槽位交换（0..8，或 40 = 副手）。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `slot` | `number` |  | — | — |
| `hotbarIndex` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

