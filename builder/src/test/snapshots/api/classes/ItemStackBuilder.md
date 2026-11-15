---
title: "ItemStackBuilder"
description: "Builder for local values; the single construction path for script-made stacks. The product is local data: it enters the world only through privileged writes (creative inventory) or stays comparison/display data — survival mode has no \"materialize items\" path (server authority)."
---

::api-declaration{ kind="data" name="ItemStackBuilder" ctor="new ItemStackBuilder(itemId: string)"}
::

## Methods

::api-method

### `build`

Validates and produces the immutable stack.

**Returns** :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `copyFrom`

Copies all fields from an existing stack as the base draft, then lets chained calls override.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `stack` | :api-type{text='ItemStack' refs='ItemStack=classes/itemstack'} |  | — | — |

**Returns** :api-type{text='ItemStackBuilder' refs='ItemStackBuilder=classes/itemstackbuilder'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `count`

Sets the stack size.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `size` | `number` |  | — | — |

**Returns** :api-type{text='ItemStackBuilder' refs='ItemStackBuilder=classes/itemstackbuilder'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `damage`

Sets the current durability damage.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `value` | `number` |  | — | — |

**Returns** :api-type{text='ItemStackBuilder' refs='ItemStackBuilder=classes/itemstackbuilder'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `enchant`

Adds one enchantment (chainable, repeats allowed).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `enchantId` | `string` |  | — | — |
| `level` | `number` |  | — | — |

**Returns** :api-type{text='ItemStackBuilder' refs='ItemStackBuilder=classes/itemstackbuilder'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `lore`

Appends lore lines (varargs form).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `...lines` | `Array<string>` |  | — | — |

**Returns** :api-type{text='ItemStackBuilder' refs='ItemStackBuilder=classes/itemstackbuilder'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `loreLines`

Replaces lore lines from an array form.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `lines` | `Array<string>` |  | — | — |

**Returns** :api-type{text='ItemStackBuilder' refs='ItemStackBuilder=classes/itemstackbuilder'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `maxDamage`

Sets the maximum durability.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `value` | `number` |  | — | — |

**Returns** :api-type{text='ItemStackBuilder' refs='ItemStackBuilder=classes/itemstackbuilder'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `name`

Sets a custom display name.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `value` | `string` |  | — | — |

**Returns** :api-type{text='ItemStackBuilder' refs='ItemStackBuilder=classes/itemstackbuilder'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `unbreakable`

Marks the stack unbreakable (default true when called without arguments).

**Returns** :api-type{text='ItemStackBuilder' refs='ItemStackBuilder=classes/itemstackbuilder'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `unbreakable`

Marks the stack unbreakable on or off.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `on` | `boolean` |  | — | — |

**Returns** :api-type{text='ItemStackBuilder' refs='ItemStackBuilder=classes/itemstackbuilder'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

