---
title: "Response"
description: "Live HTTP response: status/header properties plus async body readers (text(), json(), bytes())."
---

::api-declaration{ kind="handle" name="Response"}
::

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `headers` | `Record<string, string>` | Response headers, keyed by lower-cased name. :api-badge{kind="readonly"} |
| `ok` | `boolean` | Whether the status is in the 2xx range. :api-badge{kind="readonly"} |
| `status` | `number` | The HTTP status code. :api-badge{kind="readonly"} |

## Methods

::api-method

### `bytes`

Reads the body as raw bytes (rendered as a Uint8Array).

**Returns** `Promise<Uint8Array>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `json`

Parses the body as JSON; rejects when the body is not valid JSON.

**Returns** `Promise<JsonValue>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

::api-method

### `text`

Reads the body as UTF-8 text.

**Returns** `Promise<string>`

:api-badges{ since="0.1.0" mc="*" loader="*"}

::

