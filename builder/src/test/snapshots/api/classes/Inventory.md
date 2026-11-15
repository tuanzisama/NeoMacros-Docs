---
title: "Inventory"
description: "Live inventory handle: slot reads re-query the inventory port on every access; actions dispatch on the main thread and resolve once processed."
---

::api-declaration{ kind="handle" name="Inventory"}
#extended-by
[`AnvilInventory`](AnvilInventory.html), [`BeaconInventory`](BeaconInventory.html), [`BrewingStandInventory`](BrewingStandInventory.html), [`CartographyInventory`](CartographyInventory.html), [`ContainerInventory`](ContainerInventory.html), [`CraftingInventory`](CraftingInventory.html), [`EnchantInventory`](EnchantInventory.html), [`FurnaceInventory`](FurnaceInventory.html), [`GrindstoneInventory`](GrindstoneInventory.html), [`HorseInventory`](HorseInventory.html), [`PlayerInventory`](PlayerInventory.html), [`SmithingInventory`](SmithingInventory.html), [`StonecutterInventory`](StonecutterInventory.html), [`VillagerInventory`](VillagerInventory.html)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `carried` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} | The stack held on the mouse cursor over the open menu, or undefined. :api-badge{kind="readonly"} |
| `itemCount` | `Record<string, number>` | Total item count per item id across the inventory. :api-badge{kind="readonly"} |
| `items` | :api-type{text='Record<number, ItemStack>' refs='ItemStack=classes/itemstack'} | All non-empty stacks keyed by their slot index; every value is a full ItemStack handle, the same type slot() returns. |
| `kind` | `string` | The inventory kind (player, chest, crafting, ...). :api-badge{kind="readonly"} |
| `selectedHotbarSlot` | `number` | The selected hotbar slot (0-8), or undefined. :api-badge{kind="readonly"} |
| `size` | `number` | The inventory slot count. :api-badge{kind="readonly"} |
| `title` | `string` | The inventory display title. :api-badge{kind="readonly"} |

## Methods

::api-method

### `click`

Clicks a slot (button 0 = left, 1 = right, 2 = middle-click clone in creative; shift = quick move).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `slot` | `number` |  | — | — |
| `button` | `number` |  | — | — |
| `shift` | `boolean` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `close`

Closes the inventory screen.

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `closeAndDrop`

Drops the cursor-held stack (if any) and closes the open screen.

**Returns** `Promise<void>`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `contains`

Whether the inventory holds the given item id (namespace optional).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `itemId` | `string` |  | — | — |

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `countOf`

Counts occurrences of one item id.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `item` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `dragClick`

Drag-distributes the cursor stack over the given menu slots (button 0 = even split, other = greedy fill).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `slots` | `Array<number>` |  | — | — |
| `button` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `drop`

Drops the stack from a slot.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `slot` | `number` |  | — | — |
| `all` | `boolean` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `findAll`

Slot indices holding the given item id, in order.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `itemId` | `string` |  | — | — |

**Returns** `Array<number>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `findFreeHotbarSlot`

First empty hotbar slot (0-8), or undefined when full. Reads the player's own inventory, no GUI needed.

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `findFreeInventorySlot`

First empty main-inventory slot (9-35), or undefined when full. Reads the player's own inventory, no GUI needed.

**Returns** `number`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `findId`

First slot holding the given item id, or undefined.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `itemId` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `grabAll`

Picks the slot up, then gathers every matching stack onto the cursor (the double-click collect semantics).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `slot` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `quickAll`

Quick-moves every slot that can merge with the given slot's stack (same backing container). Returns the moved item count.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `slot` | `number` |  | — | — |
| `button` | `number` |  | ✓ | — |

**Returns** `Promise<number>`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `quickMove`

Quick-moves a slot to the other inventory.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `slot` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `setSelectedHotbarSlot`

Selects the active hotbar slot (0-8).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `index` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `slot`

Reads the stack at a slot, or undefined when out of range or empty.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `index` | `number` |  | — | — |

**Returns** :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `split`

Places the cursor stack split across two empty slots: one item into the first, the rest into the second. Both slots must be empty and distinct; the server arbitrates violations.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `slot1` | `number` |  | — | — |
| `slot2` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `swapHotbar`

Swaps a container slot with a hotbar slot (0..8, or 40 for the offhand).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `slot` | `number` |  | — | — |
| `hotbarIndex` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

