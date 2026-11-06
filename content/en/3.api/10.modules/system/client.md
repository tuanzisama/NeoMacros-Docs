---
title: "client"
description: "The neo.client facade: process-level facts about the running game client, window and input surfaces, the connection lifecycle, and read-only registry and option slices."
---

Category: System · Since: 0.2.0 · MC availability: * · Loader availability: * · Exposed as `neo.client` and `@neomacros/client`

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `clipboard` | `string` | The current system clipboard text. (read-only) |
| `devEnv` | `boolean` | Whether the game runs in a development environment. (read-only) |
| `fps` | `number` | The current frames-per-second measurement of the client. (read-only) |
| `gameVersion` | `string` | The game version string the client runs on. (read-only) |
| `minecraft` | `unknown` | The raw host client instance as a JavaObject proxy. Requires the java permission; equivalent to java.type('net.minecraft.client.Minecraft').getInstance(). |
| `mods` | `Array<Record<string, unknown>>` | The installed mods as [{id, name, version, authors}] in loader order. (read-only) |
| `mouse` | `Record<string, unknown>` | The cursor position in window pixels as {x, y}. (read-only) |
| `options` | `Record<string, unknown>` | A small read-only slice of the game options as {fov, gamma, guiScale, renderDistance}. (read-only) |
| `ping` | `number` | The server-reported latency for the local player in milliseconds, or null without a connection. (read-only) |
| `serverInfo` | `Record<string, unknown>` | The connected server entry as {name, address}, or null in singleplayer. (read-only) |
| `window` | `Record<string, unknown>` | The window metrics as {width, height, scaledWidth, scaledHeight}. (read-only) |

## Methods

### `connect(address: string)`

Connects to the server at the address, leaving any current world. Resolves once the connection is initiated; failures reject.

**Parameters**

- `address` `string`: 服务器地址（host 或 host:port）

**Returns** `Promise<void>`

Since: 0.2.0 · MC: * · Loader: *

### `disconnect()`

Disconnects from the current server. Resolves once initiated; rejects in singleplayer.

**Returns** `Promise<void>`

Since: 0.2.0 · MC: * · Loader: *

### `forceShutdown()`

Closes the game immediately, skipping save and shutdown hooks.

Since: 0.2.0 · MC: * · Loader: *

### `getMod(id: string)`

The metadata of one loaded mod as {id, name, version, authors}, or null when not loaded.

**Parameters**

- `id` `string`: 模组标识

**Returns** `Record<string, unknown>`

Since: 0.2.0 · MC: * · Loader: *

### `grabMouse()`

Grabs the mouse cursor back into the game window.

Since: 0.2.0 · MC: * · Loader: *

### `grabScreenshot()`

Captures the game framebuffer as an Image; the promise resolves after the next frame read.

**Returns** `Promise<`[Image](../../classes/image)`>`

Since: 0.2.0 · MC: * · Loader: *

### `isModLoaded(id: string)`

Whether a mod with the identifier is loaded.

**Parameters**

- `id` `string`: 模组标识

**Returns** `boolean`

Since: 0.2.0 · MC: * · Loader: *

### `loadWorld(name: string)`

Loads the local save with the given name. Resolves once the load flow starts; unknown saves reject.

**Parameters**

- `name` `string`: 存档名称

**Returns** `Promise<void>`

Since: 0.2.0 · MC: * · Loader: *

### `registryIds(kind: string)`

The identifiers of one registry kind (block, item, entity_type, sound_event, particle_type, mob_effect); unknown kinds throw.

**Parameters**

- `kind` `string`: 

**Returns** `Array<string>`

Since: 0.2.0 · MC: * · Loader: *

### `registryLookup(kind: string, id: string)`

Returns the full identifier when the registry kind contains the id (missing namespace defaults to minecraft), or null.

**Parameters**

- `kind` `string`: 注册表类别
- `id` `string`: 标识

**Returns** `string`

Since: 0.2.0 · MC: * · Loader: *

### `releaseMouse()`

Releases the mouse cursor to the operating system.

Since: 0.2.0 · MC: * · Loader: *

### `setClipboard(value: string)`

Writes text to the system clipboard.

**Parameters**

- `value` `string`: 剪贴板文本

Since: 0.2.0 · MC: * · Loader: *

### `shutdown()`

Closes the game gracefully.

Since: 0.2.0 · MC: * · Loader: *


## Examples

Read process-level client facts; the raw minecraft entry requires the java permission.

```js
const { client } = neo;

// Process-level facts, readable at any time
if (client.fps < 30) {
  // client is struggling — skip heavy per-tick work
}
const version = client.gameVersion; // the game version string

// Escape hatch to the raw client; requires the java permission
const mc = client.minecraft; // ≙ java.type('net.minecraft.client.Minecraft').getInstance()
```
