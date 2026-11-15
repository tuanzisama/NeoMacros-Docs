---
title: "chat"
description: "The neo.chat module: chat output services. Sending targets the connected server; log and actionbar render locally only. Text-taking members accept a TextComponent | string: components render with their full styling where the surface supports it, strings render plain."
---

:api-module-header{ category="UI" neo-name="neo.chat" since="0.1.0" mc="*" loader="*"}

## Methods

::api-method

### `actionbar`

Renders the message on the action bar above the hotbar; components render with full styling.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `message` | :api-type{text='TextComponent \| string' refs='TextComponent=classes/textcomponent'} |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `getWidth`

The rendered pixel width of the text in the chat font.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `text` | `string` |  | — | — |

**Returns** `number`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `log`

Prints the message to the local chat HUD only; components render with full color/decoration/hover/click.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `message` | :api-type{text='TextComponent \| string' refs='TextComponent=classes/textcomponent'} |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `say`

Sends the message to the connected server as if typed by the player. A component rides its plain form (the server chat is text-only).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `message` | :api-type{text='TextComponent \| string' refs='TextComponent=classes/textcomponent'} |  | — | — |

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `title`

Shows a title (and optional subtitle) overlay; null lines are skipped and non-null durations override the vanilla fade timings in ticks. Lines may be components or strings.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `title` | :api-type{text='TextComponent \| string' refs='TextComponent=classes/textcomponent'} |  | ✓ | — |
| `subtitle` | :api-type{text='TextComponent \| string' refs='TextComponent=classes/textcomponent'} |  | ✓ | — |
| `fadeIn` | `number` |  | ✓ | — |
| `stay` | `number` |  | ✓ | — |
| `fadeOut` | `number` |  | ✓ | — |

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `toast`

Shows a system toast notification in the screen corner; lines may be components or strings.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `title` | :api-type{text='TextComponent \| string' refs='TextComponent=classes/textcomponent'} |  | ✓ | — |
| `message` | :api-type{text='TextComponent \| string' refs='TextComponent=classes/textcomponent'} |  | ✓ | — |

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

