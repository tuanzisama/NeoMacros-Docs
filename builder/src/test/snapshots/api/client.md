---
title: "client"
description: "The neo.client module: process-level facts about the running game client, window and input surfaces, the connection lifecycle, and read-only registry and option slices."
---

:api-module-header{ category="System" neo-name="neo.client" since="0.2.0" mc="*" loader="*"}

**Classes**

[`MousePos`](classes/MousePos.html)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `clipboard` | `string` | The current system clipboard text. :api-badge{kind="readonly"} |
| `devEnv` | `boolean` | Whether the game runs in a development environment. :api-badge{kind="readonly"} |
| `fps` | `number` | The current frames-per-second measurement of the client. :api-badge{kind="readonly"} |
| `gameVersion` | `string` | The game version string the client runs on. :api-badge{kind="readonly"} |
| `minecraft` | :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'} | The raw host client instance as a JavaObject proxy. Requires the java permission; equivalent to java.type('net.minecraft.client.Minecraft').getInstance(). |
| `mods` | :api-type{text='Array<ModData>' refs='ModData=classes/moddata'} | The installed mods as [{id, name, version, authors}] in loader order. :api-badge{kind="readonly"} |
| `mouse` | :api-type{text='MousePos' refs='MousePos=classes/mousepos'} | The cursor position in window pixels as {x, y}. :api-badge{kind="readonly"} |
| `options` | :api-type{text='OptionsData' refs='OptionsData=classes/optionsdata'} | A small read-only slice of the game options as {fov, gamma, guiScale, renderDistance}. :api-badge{kind="readonly"} |
| `ping` | `number` | The server-reported latency for the local player in milliseconds, or null without a connection. :api-badge{kind="readonly"} |
| `serverInfo` | :api-type{text='ServerInfoData' refs='ServerInfoData=classes/serverinfodata'} | The connected server entry as {name, address, ping}, or null in singleplayer. :api-badge{kind="readonly"} |
| `window` | :api-type{text='WindowData' refs='WindowData=classes/windowdata'} | The window metrics as {width, height, scaledWidth, scaledHeight}. :api-badge{kind="readonly"} |

## Methods

::api-method

### `connect`

Connects to the server at the address, leaving any current world. Resolves once the connection is initiated; failures reject.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `address` | `string` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `disconnect`

Disconnects from the current server. Resolves once initiated; rejects in singleplayer.

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `forceShutdown`

Closes the game immediately, skipping save and shutdown hooks.

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `getMod`

The metadata of one loaded mod as {id, name, version, authors}, or null when not loaded.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `id` | `string` |  | — | — |

**Returns** :api-type{text='ModData' refs='ModData=classes/moddata'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `grabMouse`

Grabs the mouse cursor back into the game window.

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `grabScreenshot`

Captures the game framebuffer as an Image; the promise resolves after the next frame read.

**Returns** :api-type{text='Promise<Image>' refs='Image=classes/image'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `isModLoaded`

Whether a mod with the identifier is loaded.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `id` | `string` |  | — | — |

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `loadWorld`

Loads the local save with the given name. Resolves once the load flow starts; unknown saves reject.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `option`

One game option value by name (fov, sensitivity, particles, ...); the value is a Boolean, a number, or a lowercase enum name. Unknown names return null.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `name` | `string` |  | — | — |

**Returns** `boolean | number | string`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `registryIds`

The identifiers of one built-in registry kind, e.g. block, item, enchantment, worldgen/biome; any registry id resolves, unknown kinds throw.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `kind` | `string` |  | — | — |

**Returns** `Array<string>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `registryLookup`

Returns the full identifier when the registry kind contains the id (missing namespace defaults to minecraft), or null.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `kind` | `string` |  | — | — |
| `id` | `string` |  | — | — |

**Returns** `string`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `releaseMouse`

Releases the mouse cursor to the operating system.

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `setClipboard`

Writes text to the system clipboard.

| Parameter | Type | Description | Optional | Default |
| --- | --- | --- | --- | --- |
| `value` | `string` |  | — | — |

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `shutdown`

Closes the game gracefully.

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

