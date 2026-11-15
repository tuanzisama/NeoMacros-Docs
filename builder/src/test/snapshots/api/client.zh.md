---
title: "client"
description: "neo.client：运行中游戏客户端的进程级事实、窗口与输入面、连接生命周期，以及只读的注册表与设置切片。"
---

:api-module-header{ category="系统" neo-name="neo.client" since="0.2.0" mc="*" loader="*"}

**Classes**

[`MousePos`](classes/MousePos.html)

## Properties

| Property | Type | Description |
| --- | --- | --- |
| `clipboard` | `string` | 当前系统剪贴板文本。 :api-badge{kind="readonly"} |
| `devEnv` | `boolean` | 游戏是否运行在开发环境。 :api-badge{kind="readonly"} |
| `fps` | `number` | 客户端当前帧率。 :api-badge{kind="readonly"} |
| `gameVersion` | `string` | 客户端运行的游戏版本串。 :api-badge{kind="readonly"} |
| `minecraft` | :api-type{text='JavaObject' refs='JavaObject=classes/javaobject'} | 原始宿主客户端实例（JavaObject 代理）。需 java 权限；等价于 java.type('net.minecraft.client.Minecraft').getInstance()。 |
| `mods` | :api-type{text='Array<ModData>' refs='ModData=classes/moddata'} | 已安装模组数组 [{id, name, version, authors}]，按加载器顺序。 :api-badge{kind="readonly"} |
| `mouse` | :api-type{text='MousePos' refs='MousePos=classes/mousepos'} | 鼠标位置（窗口像素）{x, y}。 :api-badge{kind="readonly"} |
| `options` | :api-type{text='OptionsData' refs='OptionsData=classes/optionsdata'} | 游戏设置只读切片 {fov, gamma, guiScale, renderDistance}。 :api-badge{kind="readonly"} |
| `ping` | `number` | 服务器报告的本地玩家延迟（毫秒）；未连接时为 null。 :api-badge{kind="readonly"} |
| `serverInfo` | :api-type{text='ServerInfoData' refs='ServerInfoData=classes/serverinfodata'} | 当前服务器条目 {name, address, ping}；单人世界为 null。 :api-badge{kind="readonly"} |
| `window` | :api-type{text='WindowData' refs='WindowData=classes/windowdata'} | 窗口度量 {width, height, scaledWidth, scaledHeight}。 :api-badge{kind="readonly"} |

## Methods

::api-method

### `connect`

连接到目标地址的服务器（先离开当前世界）；发起连接后即 resolve，失败 reject。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `address` | `string` | 服务器地址（host 或 host:port） | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `disconnect`

断开与服务器的连接；发起后即 resolve，单人世界下 reject。

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `forceShutdown`

立即关闭游戏，跳过保存与关闭钩子。

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `getMod`

指定 id 模组的元数据 {id, name, version, authors}；未加载时为 null。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `id` | `string` | 模组标识 | — | — |

**Returns** :api-type{text='ModData' refs='ModData=classes/moddata'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `grabMouse`

把鼠标收回游戏窗口（重新捕获）。

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `grabScreenshot`

抓取游戏画面为 Image；Promise 在下一帧读取后落定。

**Returns** :api-type{text='Promise<Image>' refs='Image=classes/image'}

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `isModLoaded`

判断指定 id 的模组是否已加载。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `id` | `string` | 模组标识 | — | — |

**Returns** `boolean`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `loadWorld`

加载指定名称的本地存档；加载流程开始后即 resolve，存档不存在 reject。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `name` | `string` | 存档名称 | — | — |

**Returns** `Promise<void>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `option`

按名称读取单个游戏设置（fov/sensitivity/particles 等）；值为布尔、数字或小写枚举名；未知名称为 null。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `name` | `string` | 设置名 | — | — |

**Returns** `boolean | number | string`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `registryIds`

返回一类内置注册表的全部标识，如 block/item/enchantment/worldgen/biome；任意注册表 id 均可解析；未知类别抛错。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `kind` | `string` |  | — | — |

**Returns** `Array<string>`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `registryLookup`

判断注册表中是否存在该 id（省略命名空间默认 minecraft:），存在返回全名，否则 null。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `kind` | `string` | 注册表类别 | — | — |
| `id` | `string` | 标识 | — | — |

**Returns** `string`

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `releaseMouse`

把鼠标释放给操作系统。

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `setClipboard`

写入系统剪贴板。

| 参数 | 类型 | 说明 | 可选 | 默认 |
| --- | --- | --- | --- | --- |
| `value` | `string` | 剪贴板文本 | — | — |

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

::api-method

### `shutdown`

优雅地关闭游戏。

:api-badges{ since="0.2.0" mc="*" loader="*"}

::

