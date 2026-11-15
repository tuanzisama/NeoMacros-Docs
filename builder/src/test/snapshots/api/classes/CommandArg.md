---
title: "CommandArg"
description: "One typed argument slot of a registered command. Slots build through the dynamic command.arg factory (int() float() bool() word() string() greedy() player() pos()) and chain optional() and default(v). Parsing walks slots in declaration order against the raw remainder; greedy consumes everything that is left."
---

::api-declaration{ kind="handle" name="CommandArg"}
::

## Methods

::api-method

### `defaultTo`

Supplies the fallback value for an optional slot.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `value` | `number | string | boolean` |  | — | — |

**Returns** :api-type{text='CommandArg' refs='CommandArg=classes/commandarg'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `optional`

Marks the slot optional (missing input falls back, never raises).

**Returns** :api-type{text='CommandArg' refs='CommandArg=classes/commandarg'}

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

