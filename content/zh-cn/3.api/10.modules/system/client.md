---
title: "client"
description: "neo.client 门面：运行中游戏客户端的进程级事实、窗口与输入面、连接生命周期，以及只读的注册表与设置切片。"
---

Category: 系统 · Since: 0.2.0 · MC availability: * · Loader availability: * · Exposed as `neo.client` and `@neomacros/client`

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `clipboard` | `string` | 当前系统剪贴板文本。 (read-only) |
| `devEnv` | `boolean` | 游戏是否运行在开发环境。 (read-only) |
| `fps` | `number` | 客户端当前帧率。 (read-only) |
| `gameVersion` | `string` | 客户端运行的游戏版本串。 (read-only) |
| `minecraft` | `unknown` | 原始宿主客户端实例（JavaObject 代理）。需 java 权限；等价于 java.type('net.minecraft.client.Minecraft').getInstance()。 |
| `mods` | `Array<Record<string, unknown>>` | 已安装模组数组 [{id, name, version, authors}]，按加载器顺序。 (read-only) |
| `mouse` | `Record<string, unknown>` | 鼠标位置（窗口像素）{x, y}。 (read-only) |
| `options` | `Record<string, unknown>` | 游戏设置只读切片 {fov, gamma, guiScale, renderDistance}。 (read-only) |
| `ping` | `number` | 服务器报告的本地玩家延迟（毫秒）；未连接时为 null。 (read-only) |
| `serverInfo` | `Record<string, unknown>` | 当前服务器条目 {name, address}；单人世界为 null。 (read-only) |
| `window` | `Record<string, unknown>` | 窗口度量 {width, height, scaledWidth, scaledHeight}。 (read-only) |

## Methods

### `connect(address: string)`

连接到目标地址的服务器（先离开当前世界）；发起连接后即 resolve，失败 reject。

**Parameters**

- `address` `string`: 服务器地址（host 或 host:port）

**Returns** `Promise<void>`

Since: 0.2.0 · MC: * · Loader: *

### `disconnect()`

断开与服务器的连接；发起后即 resolve，单人世界下 reject。

**Returns** `Promise<void>`

Since: 0.2.0 · MC: * · Loader: *

### `forceShutdown()`

立即关闭游戏，跳过保存与关闭钩子。

Since: 0.2.0 · MC: * · Loader: *

### `getMod(id: string)`

指定 id 模组的元数据 {id, name, version, authors}；未加载时为 null。

**Parameters**

- `id` `string`: 模组标识

**Returns** `Record<string, unknown>`

Since: 0.2.0 · MC: * · Loader: *

### `grabMouse()`

把鼠标收回游戏窗口（重新捕获）。

Since: 0.2.0 · MC: * · Loader: *

### `grabScreenshot()`

抓取游戏画面为 Image；Promise 在下一帧读取后落定。

**Returns** `Promise<`[Image](../../classes/image)`>`

Since: 0.2.0 · MC: * · Loader: *

### `isModLoaded(id: string)`

判断指定 id 的模组是否已加载。

**Parameters**

- `id` `string`: 模组标识

**Returns** `boolean`

Since: 0.2.0 · MC: * · Loader: *

### `loadWorld(name: string)`

加载指定名称的本地存档；加载流程开始后即 resolve，存档不存在 reject。

**Parameters**

- `name` `string`: 存档名称

**Returns** `Promise<void>`

Since: 0.2.0 · MC: * · Loader: *

### `registryIds(kind: string)`

返回一类注册表的全部标识（block/item/entity_type/sound_event/particle_type/mob_effect）；未知类别抛错。

**Parameters**

- `kind` `string`: 

**Returns** `Array<string>`

Since: 0.2.0 · MC: * · Loader: *

### `registryLookup(kind: string, id: string)`

判断注册表中是否存在该 id（省略命名空间默认 minecraft:），存在返回全名，否则 null。

**Parameters**

- `kind` `string`: 注册表类别
- `id` `string`: 标识

**Returns** `string`

Since: 0.2.0 · MC: * · Loader: *

### `releaseMouse()`

把鼠标释放给操作系统。

Since: 0.2.0 · MC: * · Loader: *

### `setClipboard(value: string)`

写入系统剪贴板。

**Parameters**

- `value` `string`: 剪贴板文本

Since: 0.2.0 · MC: * · Loader: *

### `shutdown()`

优雅地关闭游戏。

Since: 0.2.0 · MC: * · Loader: *


## Examples

读取进程级客户端事实；访问原始客户端入口 minecraft 需要 java 权限。

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
