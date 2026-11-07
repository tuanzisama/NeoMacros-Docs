# 18 个门面模块速查(中文参考)

每个门面的完整签名在其生成页上;此处只列已确认的核心成员,未列出的
成员一律以门面页与 `neomacros.d.ts` 为准,不要臆造。

页 URL 模式:`https://neomacros.tuanzi.ink/en/api/modules/<域>/<名>`,
域目录:core / ui / world / input / system。

## Core

### events — 事件订阅(`/api/modules/core/events`)

`on(name, handler)` · `onSync(name, handler)`(仅可取消事件,truthy 否决)
· `off(handleOrName)` · `once(name, handler)` · `waitFor(name)` ·
`waitForUntil(name, filter, timeoutMillis)` · `register('ns:name')` ·
`emit(name, payload)`。事件名 `domain:name` 驼峰,裸 `tick` 例外。

### thread — 线程与计时(`/api/modules/core/thread`)

`sleep(ms)`(墙钟)· `ticks(n)` / `nextTick()`(tick 边界)·
`runOnMain(task)`(已在主线程则内联)· `after(ms, task)` / `every(ms, task)`
· `afterTick(count, task)` / `everyTick(count, task)`;定时器返回
`TimerHandle`,有 `cancel()`。

### storage — 持久化键值(`/api/modules/core/storage`)

`put(key, value)`(`null` 删除)· `get(key)`(缺失返回 `null`)·
`has(key)` · `remove(key)`。仅 JSON 可序列化值,按脚本隔离。

### performance — 性能剖析(`/api/modules/core/performance`)

Web Performance 风格:会话锚定的单调时钟、User Timing mark 与 measure。

## UI

### chat — 聊天(`/api/modules/ui/chat`)

发送到服务器、本地日志行(`log`)、动作栏(`actionbar`)。

### hud — HUD 文本(`/api/modules/ui/hud`)

`addText(id, text, x, y, argb)`(同 id 原位替换)· `removeText(id)` ·
`textIds()`。ARGB 整数颜色。脚本卸载条目随之消失。

### command — 客户端命令(`/api/modules/ui/command`,需 `command` 权限)

`register({name, description, args, handler})` 返回句柄 ·
`unregister(handleOrName)` · `execute` · `arg.int()/float()/bool()/
word()/string()/greedy()/player()/pos()`,槽修饰 `.optional()` /
`.defaultTo(v)`(**是 defaultTo,不是 default**)。处理器收
`ctx.args`(类型化)+ `ctx.raw`(原始剩余串)。

### render — 世界线框(`/api/modules/ui/render`)

`drawBox(layerId, min, max, color)` · `drawLine(layerId, from, to, color)`
· `clearLayer(layerId)` · `layerIds()`。坐标为 Pos3D;按层累积,脚本卸载
自动清空。

### screen — 屏幕元信息(`/api/modules/ui/screen`)

当前打开屏幕的元数据。

## World

### world — 世界查询(`/api/modules/world/world`)

时间、维度、天气、方块与区块查询(`blockAt(x, y, z)` 返回带 `.pos` 的
方块句柄)。

### player — 本地玩家(`/api/modules/world/player`)

`player.self` — 活句柄,不在世界时为 `undefined`;`.pos` 是 Pos3D。
另有当前打开的容器访问。

### entity — 实体查找(`/api/modules/world/entity`)

按 UUID、类型、半径查找实体。

## Input

### input — 输入(`/api/modules/input/input`)

控件菜单里的按键绑定注册、按键监听与注入。

## System(均需对应权限)

### fs — 沙箱文件系统(`fs` 权限)

`readText` · `writeText` · `readJSON` · `writeJSON` · `list` · `mkdir` ·
`delete` 等;路径相对游戏目录。

### net — HTTP(`net` 权限)

`fetch`(fetch 语义)· `get` · `post`。

### java — JVM 逃生口(`java` 权限)

`type('binary.ClassName')`(Mojmap 名)→ 类代理;`File.new(...)` 构造;
`proxy(interfaces, handlers)` 反向桥;`toList` / `fromList` / `toArray`
集合转换。

### client — 客户端事实

`fps` · 游戏版本;`client.minecraft` 需 `java` 权限,交出原始客户端对象
代理(等价 `java.type('net.minecraft.client.Minecraft').getInstance()`)。

### reflect — 精确反射(`java` 权限)

`method(target, name, [paramTypes])`(精确重载)· `invoke(m, target, args)`
(静态省略 target)· `newInstance(className)` · `className(value)`。

## 事件目录

见 `event-catalog.zh.md`(45 个事件的精确驼峰名与页面 URL)。
