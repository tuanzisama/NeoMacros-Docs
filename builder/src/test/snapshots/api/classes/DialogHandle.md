---
title: "DialogHandle"
description: "Live dialog handle: reads resolve on every access, actions dispatch on the main thread."
---

::api-declaration{ kind="handle" name="DialogHandle" wraps="net.minecraft.server.dialog.Dialog"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `actions` | :api-type{text='Array<DialogAction>' refs='DialogAction=classes/dialogaction'} | The action buttons, in flattened click order. :api-badge{kind="readonly"} |
| `body` | `Array<string>` | The dialog body texts, in order. :api-badge{kind="readonly"} |
| `canCloseWithEscape` | `boolean` | Whether the dialog can be closed with Esc. :api-badge{kind="readonly"} |
| `inputs` | :api-type{text='Array<DialogInput>' refs='DialogInput=classes/dialoginput'} | The declared input controls. :api-badge{kind="readonly"} |
| `kind` | `string` | The dialog kind (notice, confirmation, multi_action, ...). :api-badge{kind="readonly"} |
| `title` | `string` | The dialog title. :api-badge{kind="readonly"} |

## Methods

::api-method

### `clickAction`

Clicks one action button by its flattened index (script-shown dialogs resolve their show() future with the action id).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `index` | `number` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.3.0" mc=">=1.21.6" loader="*"}

::

::api-method

### `close`

Closes the dialog (Esc path; script dialogs resolve showDialog with null).

**Returns** `Promise<void>`

:api-badges{ since="0.3.0" mc=">=1.21.6" loader="*"}

::

