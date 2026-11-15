---
title: "Component"
description: "Builder for immutable values; the single construction path for script-made styled text. Style setters mutate the draft in place and return the same builder; build() is non-destructive, so the draft stays reusable for further chaining. Click actions and hover content are mutually exclusive — the latest call wins."
---

::api-declaration{ kind="data" name="Component" ctor="new Component(text: string)"}
::

## Methods

::api-method

### `append`

Appends one child: another draft (built immediately), a built value, or a plain string. Children inherit this node's styling unless they set their own.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `child` | :api-type{text='Component \| TextComponent \| string' refs='Component=classes/component,TextComponent=classes/textcomponent'} |  | — | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `bold`

Sets bold on (default when called without arguments).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `value` | `boolean` |  | ✓ | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `build`

Produces the immutable value; the draft stays usable.

**Returns** :api-type{text='TextComponent' refs='TextComponent=classes/textcomponent'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `clickCommand`

Click runs the command as the local player.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `command` | `string` |  | — | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `clickCopyToClipboard`

Click copies the text to the clipboard.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `text` | `string` |  | — | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `clickSuggestCommand`

Click fills the command into the chat input without sending.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `command` | `string` |  | — | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `clickUrl`

Click opens the URL in the browser (vanilla confirmation applies).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `url` | `string` |  | — | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `color`

Sets the color: a vanilla formatting name or #rrggbb.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `value` | `string` |  | — | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `copyFrom`

Copies content, own styling, and children from an existing value as the base draft, then lets chained calls override.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `other` | :api-type{text='TextComponent' refs='TextComponent=classes/textcomponent'} |  | — | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `hover`

Sets a show-text hover; replaces any item hover.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `text` | `string` |  | — | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `hoverItem`

Sets a show-item hover; replaces any text hover. A string is the item id (count 1); an ItemStack rides its full snapshot.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `item` | :api-type{text='ItemStack \| string' refs='ItemStack=classes/itemstack'} |  | — | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `italic`

Sets italic on or off.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `value` | `boolean` |  | ✓ | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `obfuscated`

Sets obfuscated on or off.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `value` | `boolean` |  | ✓ | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `strikethrough`

Sets strikethrough on or off.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `value` | `boolean` |  | ✓ | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

::api-method

### `underlined`

Sets underline on or off.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `value` | `boolean` |  | ✓ | — |

**Returns** :api-type{text='Component' refs='Component=classes/component'}

:api-badges{ since="0.4.0" mc="*" loader="*"}

::

