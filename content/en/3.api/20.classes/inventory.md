---
title: "Inventory"
description: "Live inventory handle: slot reads re-query the inventory port on every access; actions dispatch on the main thread and resolve once processed."
---

::api-declaration{ kind="handle" name="Inventory"}
#extended-by
[`AnvilInventory`](anvilinventory), [`BeaconInventory`](beaconinventory), [`BrewingStandInventory`](brewingstandinventory), [`CartographyInventory`](cartographyinventory), [`ContainerInventory`](containerinventory), [`CraftingInventory`](craftinginventory), [`EnchantInventory`](enchantinventory), [`FurnaceInventory`](furnaceinventory), [`GrindstoneInventory`](grindstoneinventory), [`HorseInventory`](horseinventory), [`PlayerInventory`](playerinventory), [`SmithingInventory`](smithinginventory), [`StonecutterInventory`](stonecutterinventory), [`VillagerInventory`](villagerinventory)
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `items` | `Array<Record<string, unknown>>` | All non-empty stacks with their slot indices. |
| `kind` | `string` | The inventory kind (player, chest, crafting, ...). :api-badge{kind="readonly"} |
| `size` | `number` | The inventory slot count. :api-badge{kind="readonly"} |
| `title` | `string` | The inventory display title. :api-badge{kind="readonly"} |

## Methods

### `click(slot: number, button: number, shift: boolean)`

Clicks a slot (button 0 = left, 1 = right; shift = quick move).

**Parameters**

- `slot` `number`: 
- `button` `number`: 
- `shift` `boolean`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `close()`

Closes the inventory screen.

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `contains(itemId: string)`

Whether the inventory holds the given item id (namespace optional).

**Parameters**

- `itemId` `string`: 

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `countOf(item: string)`

Counts occurrences of one item id.

**Parameters**

- `item` `string`: 

**Returns** `number`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `drop(slot: number, all: boolean)`

Drops the stack from a slot.

**Parameters**

- `slot` `number`: 
- `all` `boolean`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `findAll(itemId: string)`

Slot indices holding the given item id, in order.

**Parameters**

- `itemId` `string`: 

**Returns** `Array<number>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `findId(itemId: string)`

First slot holding the given item id, or undefined.

**Parameters**

- `itemId` `string`: 

**Returns** `number`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `quickMove(slot: number)`

Quick-moves a slot to the other inventory.

**Parameters**

- `slot` `number`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `slot(index: number)`

Reads the stack at a slot, or undefined when out of range or empty.

**Parameters**

- `index` `number`: 

**Returns** [ItemStack](itemstack)

:api-badges{ since="0.1.0" mc="*" loader="*"}

### `swapHotbar(slot: number, hotbarIndex: number)`

Swaps a container slot with a hotbar slot (0..8).

**Parameters**

- `slot` `number`: 
- `hotbarIndex` `number`: 

**Returns** `Promise<void>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

