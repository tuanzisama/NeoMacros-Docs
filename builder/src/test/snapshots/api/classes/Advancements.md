---
title: "Advancements"
description: "Live advancements handle: tree queries plus per-advancement progress, re-read on every access. Requires a server connection (singleplayer integrated server included)."
---

::api-declaration{ kind="handle" name="Advancements" wraps="net.minecraft.client.multiplayer.ClientAdvancements"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `completed` | `Array<string>` | The ids of fully completed advancements. :api-badge{kind="readonly"} |
| `ids` | `Array<string>` | The ids of every client-known advancement, in registry order. :api-badge{kind="readonly"} |
| `roots` | `Array<string>` | The ids of root advancements (those without a parent). :api-badge{kind="readonly"} |
| `started` | `Array<string>` | The ids of started but incomplete advancements. :api-badge{kind="readonly"} |

## Methods

::api-method

### `children`

The children (direct sub-advancements) of one advancement id, in registry order; unknown ids return an empty list.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `id` | `string` |  | — | — |

**Returns** `Array<string>`

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

::api-method

### `get`

The live advancement handle for one id, or undefined when unknown.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `id` | `string` |  | — | — |

**Returns** :api-type{text='Advancement' refs='Advancement=classes/advancement'}

:api-badges{ since="0.3.0" mc="*" loader="*"}

::

