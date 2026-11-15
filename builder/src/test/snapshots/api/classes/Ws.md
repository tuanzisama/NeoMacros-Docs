---
title: "Ws"
description: "Live WebSocket connection. Events surface through on with the names open, message (string payload), close, and error (message string)."
---

::api-declaration{ kind="handle" name="Ws"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `url` | `string` | The connected URL. :api-badge{kind="readonly"} |

## Methods

::api-method

### `close`

Closes the connection gracefully.

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `on`

Subscribes one event handler (open/message/ close/error).

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |
| `handler` | `(payload: string | undefined) => void` |  | — | — |

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `send`

Sends one text frame.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `data` | `string` |  | — | — |

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

