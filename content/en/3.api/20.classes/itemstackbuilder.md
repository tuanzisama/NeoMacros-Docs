---
title: "ItemStackBuilder"
description: "Builder for local values; the single construction path for script-made stacks. The product is local data: it enters the world only through privileged writes (creative inventory) or stays comparison/display data — survival mode has no \"materialize items\" path (server authority)."
---

::api-declaration{ kind="data" name="ItemStackBuilder"}
::

## Methods

### `build()`

Validates and produces the immutable stack.

**Returns** [ItemStack](itemstack)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `construct(args: unknown)`



**Parameters**

- `args` `unknown`: 

**Returns** `unknown`

:api-badges{ since="0.2.0"}

### `copyFrom(stack: ItemStack)`

Copies all fields from an existing stack as the base draft, then lets chained calls override.

**Parameters**

- `stack` [ItemStack](itemstack): 

**Returns** [ItemStackBuilder](itemstackbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `count(size: number)`

Sets the stack size.

**Parameters**

- `size` `number`: 

**Returns** [ItemStackBuilder](itemstackbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `damage(value: number)`

Sets the current durability damage.

**Parameters**

- `value` `number`: 

**Returns** [ItemStackBuilder](itemstackbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `enchant(enchantId: string, level: number)`

Adds one enchantment (chainable, repeats allowed).

**Parameters**

- `enchantId` `string`: 
- `level` `number`: 

**Returns** [ItemStackBuilder](itemstackbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `lore(lines: unknown)`

Appends lore lines (varargs form).

**Parameters**

- `lines` `unknown`: 

**Returns** [ItemStackBuilder](itemstackbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `loreLines(lines: Array<string>)`

Replaces lore lines from an array form.

**Parameters**

- `lines` `Array<string>`: 

**Returns** [ItemStackBuilder](itemstackbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `maxDamage(value: number)`

Sets the maximum durability.

**Parameters**

- `value` `number`: 

**Returns** [ItemStackBuilder](itemstackbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `name(value: string)`

Sets a custom display name.

**Parameters**

- `value` `string`: 

**Returns** [ItemStackBuilder](itemstackbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `toString()`



**Returns** `string`

:api-badges{ since="0.2.0"}

### `unbreakable()`

Marks the stack unbreakable (default true when called without arguments).

**Returns** [ItemStackBuilder](itemstackbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

### `unbreakable(on: boolean)`

Marks the stack unbreakable on or off.

**Parameters**

- `on` `boolean`: 

**Returns** [ItemStackBuilder](itemstackbuilder)

:api-badges{ since="0.2.0" mc="*" loader="*"}

